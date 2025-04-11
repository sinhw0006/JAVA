package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class C02ServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("[LISTENER] C02ServletContextAttributeListener ADD..");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("[LISTENER] C02ServletContextAttributeListener REMOVE..");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("[LISTENER] C02ServletContextAttributeListener REPLACE..");
	}
	

}
