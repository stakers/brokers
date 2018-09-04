/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brokers.exception;

import org.springframework.dao.DataAccessException;

/**
 *
 * @author tiyakubu
 */
public class UpdateFailedException extends DataAccessException{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8064096341860799781L;

	public UpdateFailedException(String msg)
    {
    super("*********Update Failed While Performing DML at "+msg+" ***********");
    }
    
    
}
