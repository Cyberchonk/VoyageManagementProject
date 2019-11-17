package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;

/**
 * Servlet implementation class CustomizationServlet
 */
@WebServlet("/customize")
public class CustomizationServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(CustomizationServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		
		if(session != null && session.getAttribute("user") != null){
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/CustomizationViewer.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			request.setAttribute("errorMessage", "Please login to customize a package !");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/LoginViewer.jsp");
			dispatcher.forward(request, response);
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
