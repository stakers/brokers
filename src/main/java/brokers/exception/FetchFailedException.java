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
public class FetchFailedException extends DataAccessException {

    private static final long serialVersionUID = -7269868833650565260L;

    public FetchFailedException(String msg) {
        super(msg);
    }
}
