package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(RegistrationServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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

		String userName = request.getParameter("username");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		String passwordRep = request.getParameter("psw-repeat");
		
		UserDaoJpaImpl userDao = new UserDaoJpaImpl();
		
		ServletContext context = request.getServletContext();
		
		if (userDao.findUsernameDuplicate(userName)){
			
			request.setAttribute("errorMessage", "Username already exists!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/RegistrationViewer.jsp");
			dispatcher.forward(request, response);
			
		}
			
		if (!password.equals(passwordRep)){
			
			request.setAttribute("errorMessage", "Passwords not matching!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/RegistrationViewer.jsp");
			dispatcher.forward(request, response);
		} else {
			
			userDao.create(new User(userName, password, firstName, lastName, email));
			
			request.setAttribute("errorMessage", "Registration Completed !");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/LoginViewer.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
