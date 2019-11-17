package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.dao.PackageDaoJpaImpl;
import com.fdmgroup.model.Package;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/book")
public class BookingServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(BookingServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PackageDaoJpaImpl packDao = new PackageDaoJpaImpl();
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		List<Package> bookedPackageList = user.getpList();
		System.out.println(bookedPackageList);
		
		int pID = Integer.parseInt(request.getParameter("pID"));
		
		Package foundPackage = packDao.findPackageById(pID);		
		bookedPackageList.contains(foundPackage);
		
		Boolean isBooked = false;
		
		if(bookedPackageList.contains(foundPackage)){
			
			System.out.println("The package has already being booked !");
			
			isBooked = true;
			
			request.setAttribute("isBooked", isBooked);
			request.setAttribute("finishmessage", "You have already booked this package! ");
			request.getRequestDispatcher("WEB-INF/views/PostBookingViewer.jsp").forward(request, response);
			
		} else {
			
			System.out.println("The package has not being booked !");
			
			packDao.pRegister(pID);
			
			user.getpList().add(foundPackage);
			session.setAttribute("user", user);
			
			request.setAttribute("finishmessage", "You have successfully booked this package! ");
			request.getRequestDispatcher("WEB-INF/views/PostBookingViewer.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
