package by.epam.bikerent.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SessionListener implements HttpSessionListener{
	
	private static final Logger LOG = LogManager.getLogger(SessionListener.class.getName());

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		LOG.debug("session created: " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		LOG.debug("session destroyed: " + se.getSession().getId());
		
	}

}
