package xyz.fefine.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 找不到requestHandler
 */
public class NoHandlerFoundException extends Exception {

	private Logger LOG = Logger.getLogger(this.getClass().getName(), null);


	@Override
	public void printStackTrace() {
		
		LOG.log(Level.WARNING, "Not found RequestHandler");
		
		super.printStackTrace();
	}

}
