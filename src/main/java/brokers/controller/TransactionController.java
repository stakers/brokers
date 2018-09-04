/*
s * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brokers.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import brokers.exception.GlobalRestException;
import brokers.model.RestResponse;
import brokers.service.AncilliaryService;
import brokers.service.AuditService;
import brokers.service.TransactionService;
import brokers.utility.Validator;

/**
 *
 * @author tiyakubu
 */
@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

	 final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TransactionController.class); 
	    @Autowired
	    TransactionService service;
	    @Autowired
	    Environment environment;
	    @Autowired
	    Validator validator;
	    @Autowired
	    AuditService auditService;
	    @Autowired
	    AncilliaryService ancilliaryService;

    //*************  Operation one Method ********************************************
    @SuppressWarnings("all")
    @RequestMapping(value = "/operationone/", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> operation1(@RequestBody Object request, HttpServletRequest httpServletRequest) {

        try {
            LOGGER.info("********* Attempting to perform operation one ***********"); 
 
            return new ResponseEntity<>(new RestResponse("00",""), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("********Oops Something went wrong **********" + e);
            throw new GlobalRestException("99", e.toString());
        }
    } 
   
    
}
