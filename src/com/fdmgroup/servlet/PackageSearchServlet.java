package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.dao.PackageDaoJpaImpl;
import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.model.User;
import com.fdmgroup.model.Package;

/**
 * Servlet implementation class PackageSearchServlet
 */
@WebServlet("/search")
public class PackageSearchServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(PackageSearchServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackageSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String theme = request.getParameter("theme");
		String departureDate = request.getParameter("departureDate");
		String cityName = request.getParameter("city");
		
		ServletContext context = request.getServletContext();
		
		request.setAttribute("date1001", ((Package)context.getAttribute("P1001")).getDeparture_Date());
		request.setAttribute("city1001", ((Package)context.getAttribute("P1001")).getCity());
		request.setAttribute("date1002", ((Package)context.getAttribute("P1002")).getDeparture_Date());
		request.setAttribute("city1002", ((Package)context.getAttribute("P1002")).getCity());
		request.setAttribute("date1003", ((Package)context.getAttribute("P1003")).getDeparture_Date());
		request.setAttribute("city1003", ((Package)context.getAttribute("P1003")).getCity());
		request.setAttribute("date1004", ((Package)context.getAttribute("P1004")).getDeparture_Date());
		request.setAttribute("city1004", ((Package)context.getAttribute("P1004")).getCity());
		request.setAttribute("date1005", ((Package)context.getAttribute("P1005")).getDeparture_Date());
		request.setAttribute("city1005", ((Package)context.getAttribute("P1005")).getCity());
		request.setAttribute("date1006", ((Package)context.getAttribute("P1006")).getDeparture_Date());
		request.setAttribute("city1006", ((Package)context.getAttribute("P1006")).getCity());
		request.setAttribute("date1007", ((Package)context.getAttribute("P1007")).getDeparture_Date());
		request.setAttribute("city1007", ((Package)context.getAttribute("P1007")).getCity());
		request.setAttribute("date1008", ((Package)context.getAttribute("P1008")).getDeparture_Date());
		request.setAttribute("city1008", ((Package)context.getAttribute("P1008")).getCity());
		
		PackageDaoJpaImpl packageDao = new PackageDaoJpaImpl();
		
		List<Package> pList = packageDao.findPackage(theme, cityName, departureDate);
		System.out.println(pList);
		
		HttpSession session = request.getSession();
		request.setAttribute("cityName", cityName);
		request.setAttribute("theme", theme);
		request.setAttribute("departureDate", departureDate);

		request.getRequestDispatcher("WEB-INF/views/PackageViewer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
