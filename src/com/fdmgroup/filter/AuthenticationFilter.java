package com.fdmgroup.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(urlPatterns = { "/package","/packagedetail", "/customize", "/dashboard", "/search", 
		"/PackageDetailP1001", "/PackageDetailP1002", "/PackageDetailP1003", "/PackageDetailP1004", 
		"/PackageDetailP1005", "/PackageDetailP1006", "/PackageDetailP1007", "/PackageDetailP1008"})
public class AuthenticationFilter implements Filter {

	private static Logger log = Logger.getLogger(AuthenticationFilter.class);
	
	private List<String> excludedUrl;
	
    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("***Authentication Filter");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		String incomeUrl = httpRequest.getServletPath();
		
		if(session != null && session.getAttribute("user") == null){
			System.out.println("Checking if user logged in");
			System.out.println(incomeUrl);
		}
		
		if(session != null && session.getAttribute("user") == null && excludedUrl.contains(incomeUrl)){
			
			request.setAttribute("errorMessage", "Please login to proceed !");
			httpRequest.getRequestDispatcher("/WEB-INF/views/LoginViewer.jsp").forward(request, response);
			
		}else {
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		excludedUrl = new ArrayList<>();
		excludedUrl.add("/login");
		excludedUrl.add("/authenticate");
		excludedUrl.add("/register");
		excludedUrl.add("//WEB-INF/views/HomeViewer.jsp");
		excludedUrl.add("/packagedetail");
		excludedUrl.add("/search");
		excludedUrl.add("/dashboard");
		excludedUrl.add("/PackageDetailP1001");
		excludedUrl.add("/PackageDetailP1002");
		excludedUrl.add("/PackageDetailP1003");
		excludedUrl.add("/PackageDetailP1004");
		excludedUrl.add("/PackageDetailP1005");
		excludedUrl.add("/PackageDetailP1006");
		excludedUrl.add("/PackageDetailP1007");
		excludedUrl.add("/PackageDetailP1008");
		
	}

}
