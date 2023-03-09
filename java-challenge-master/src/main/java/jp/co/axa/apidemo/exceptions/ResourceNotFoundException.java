package jp.co.axa.apidemo.exceptions;

/**
 * @author Aarti
 * Thrown when a resource does not exist
 *
 */
public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	

}
