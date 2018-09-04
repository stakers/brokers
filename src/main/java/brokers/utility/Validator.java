/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brokers.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import brokers.model.Response;

/**
 *
 * @author tiyakubu
 */
@Component
public class Validator {

    @Autowired
    private Environment environment; 
}
