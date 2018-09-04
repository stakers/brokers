/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brokers.exception;

/**
 *
 * @author tiyakubu
 */
public class GlobalRestException extends AbstractException {

    public GlobalRestException(String code, String msg) {
        super(code, msg);
    }
}
