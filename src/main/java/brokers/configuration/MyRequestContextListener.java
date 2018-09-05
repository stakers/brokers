/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brokers.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import javax.annotation.PostConstruct;

//import javax.servlet.annotation.WebListener;

/**
 *
 * @author tiyakubu
 */
@Configuration
//@WebListener
public class MyRequestContextListener extends RequestContextListener {
    //This Class for sorting Aop Request Scope
    final static Logger logger = LoggerFactory.getLogger(MyRequestContextListener.class);
     @PostConstruct
    private void startup() {
        logger.info("***************************REQUEST CONTEXT LISTENER STARTED******************************");
    }
//     @PreDestroy
//    private static void destroy() {
//        logger.info("**********************RequestContextListener Destroyed...**********************");
//    }
}
