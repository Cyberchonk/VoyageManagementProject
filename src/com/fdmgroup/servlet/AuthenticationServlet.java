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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/authenticate")
public class AuthenticationServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(AuthenticationServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
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
		
		String userName = request.getParameter("name");
		String password = request.getParameter("pwd");
		
		UserDaoJpaImpl userDao = new UserDaoJpaImpl();
		
		User foundUser = userDao.findUserByUsername(userName);
		
		HttpSession session = request.getSession();

		
		if(foundUser != null && foundUser.getPassword().equals(password)){
			
			session.setAttribute("user", foundUser);
			UserSession.setLoggedInUser(foundUser);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/DashboardViewer.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			request.setAttribute("errorMessage", "Username Password Incorrect!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/LoginViewer.jsp");
			dispatcher.forward(request, response);
		}
	}

}
