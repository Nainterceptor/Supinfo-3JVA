package com.supinfo.supcommerce.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.supinfo.supcommerce.util.PersistenceManager;

/**
 * Application Lifecycle Listener implementation class PersistenceAppListener
 *
 */
@WebListener
public class PersistenceAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public PersistenceAppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	PersistenceManager.closeEntityManagerFactory();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
