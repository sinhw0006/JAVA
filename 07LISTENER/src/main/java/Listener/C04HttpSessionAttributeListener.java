package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class C04HttpSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("ADD SESSION..");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("REMOVE SESSION..");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("REPLACE SESSION..");
	}
	

}
