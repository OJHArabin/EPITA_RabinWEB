/**
 * 
 */
package fr.epita.rabincore.exception;

/**
 * @author rabin
 *
 */
public class DAOgetIdException extends Exception {
	
private String IdFault;
	
	public DAOgetIdException(String message) {
		this.IdFault = message;
	}

	public String getSaveFault() {
		return IdFault;
	}


}
