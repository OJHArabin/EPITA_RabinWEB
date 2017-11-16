/**
 * 
 */
package fr.epita.rabincore.exception;

/**
 * @author rabin
 *
 */
public class DAODeleteException extends Exception {

	
private String deleteFault;
	
	public DAODeleteException(String message) {
		this.deleteFault = message;
	}

	public String getSaveFault() {
		return deleteFault;
	}

}
