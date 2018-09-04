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
public class InsertFailedException extends DataAccessException{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4982434315083940151L;

	public InsertFailedException(String msg)
    {
    super("*********Insert Failed While Performing DML at "+msg+" ***********");
    }
    
    
}
