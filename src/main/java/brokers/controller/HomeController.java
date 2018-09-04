/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brokers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tiyakubu
 */
@Controller
public class HomeController {
	final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void welcome(ModelMap model, HttpServletResponse resp) {
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.println("Hi Am Alive.");
		} catch (IOException e) {
			LOGGER.error("********Oops Something went wrong **********" + e);
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

}
