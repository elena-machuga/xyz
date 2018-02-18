package by.epam.bikerent.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SessionAttributeListener implements HttpSessionAttributeListener {
	
	private static final Logger LOG = LogManager.getLogger(SessionAttributeListener.class.getName());

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		LOG.info("attribute added: " + se.getClass().getSimpleName() + " : " + se.getName() + " : " + se.getValue());
	
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		LOG.info("attribute replaced: " + se.getClass().getSimpleName() + " : " + se.getName() + " : " + se.getValue());
		
	}

}
