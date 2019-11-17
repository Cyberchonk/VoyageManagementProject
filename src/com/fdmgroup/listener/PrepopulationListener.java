package com.fdmgroup.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.dao.PackageDaoJpaImpl;

/**
 * Application Lifecycle Listener implementation class PrepopulationListener
 *
 */
@WebListener
public class PrepopulationListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(PrepopulationListener.class);
	
    /**
     * Default constructor. 
     */
    public PrepopulationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 

    ServletContext sContext = sce.getServletContext();
    
    PackageDaoJpaImpl packDao = new PackageDaoJpaImpl();
    
    sContext.setAttribute("P1001", packDao.findPackageById(1001));
    sContext.setAttribute("P1002", packDao.findPackageById(1002));
    sContext.setAttribute("P1003", packDao.findPackageById(1003));
    sContext.setAttribute("P1004", packDao.findPackageById(1004));
    sContext.setAttribute("P1005", packDao.findPackageById(1005));
    sContext.setAttribute("P1006", packDao.findPackageById(1006));
    sContext.setAttribute("P1007", packDao.findPackageById(1007));
    sContext.setAttribute("P1008", packDao.findPackageById(1008));
    
    }
	
}
