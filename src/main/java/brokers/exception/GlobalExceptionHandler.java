/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brokers.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import brokers.model.Response;
import brokers.model.RestResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author tiyakubu
 */
@ControllerAdvice//(basePackages = "com.unionbank.bvnaccountmismatch")
@ResponseBody
public class GlobalExceptionHandler {
 
    
    @ExceptionHandler(GlobalRestException.class)
    @ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
    @ResponseBody
//    public Response handleGlobalRestException(GlobalRestException ex) {
//        Response response = new Response();
//        response.setResponseCode(ex.getCode());
//        response.setResponseMessage(ex.getMessage());
//        return response;
//    } 
    
    public RestResponse handleGlobalRestException(GlobalRestException ex) {
    	RestResponse response = new RestResponse();
        response.setCode(ex.getCode());
        response.setDescription(ex.getMessage());
        return response;
    }  
}
