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
 * Servlet implementation class BookingCPServlet
 */
@WebServlet("/customizepackage")
public class BookingCPServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(BookingCPServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingCPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PackageDaoJpaImpl packDao = new PackageDaoJpaImpl();
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		List<Package> bookedPackageList = user.getpList();
		
		String cityName1 = "";
		while(cityName1.isEmpty()){
		cityName1 = request.getParameter("cityname");
		}
		
		String hotelName1 = request.getParameter("hotel");
		if (hotelName1.isEmpty()){
			hotelName1 = "N/A";
		}
		
		String departureDate1 = "";
		while(departureDate1.isEmpty()){
		departureDate1 = request.getParameter("date");
		}
		
		String dur1 = request.getParameter("duration");
		int duration1 = 0;
		if (!dur1.isEmpty()){
			duration1 = Integer.parseInt(dur1);
		}
		
		String cost1 = request.getParameter("budget");
		int budget1 = 10000;
		if (!cost1.isEmpty()){
			budget1 = Integer.parseInt(cost1);
			}
		
		String comment = request.getParameter("comment");
		if (comment.isEmpty()){
			comment = "N/A";
		}
		
		packDao.createCustomizedPackage(cityName1, hotelName1, departureDate1, duration1, budget1, comment);
		
		request.setAttribute("finishmessage", "Your request has been submitted ! Our customer service representative will get back to you shortly. ");
		request.getRequestDispatcher("WEB-INF/views/PostBookingViewer.jsp").forward(request, response);		

}
	
	}
