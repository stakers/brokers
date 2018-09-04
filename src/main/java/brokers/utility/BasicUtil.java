package brokers.utility;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecobank.esc.dom.DocumentManagerFactory;
import com.ecobank.esc.model.SaveDocResponse;
import com.ecobank.esc.util.DocManagerSettings;
import com.fasterxml.jackson.databind.ObjectMapper;

import brokers.model.Response;
import brokers.model.RestResponse;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class BasicUtil {

	final static DateFormat MARSHARLLERDATEFORMAT = new SimpleDateFormat("dd-MMM-YYYY");
	final static DateFormat POSTINGDATEFORMAT = new SimpleDateFormat("YYYY-MM-dd");
	final static Logger LOGGER = LoggerFactory.getLogger(BasicUtil.class);
	final static PBEncrytor ENCRYPTOR = new PBEncrytor();
	final static ObjectMapper MAPPER = new ObjectMapper();

	public static String getUniqueId() {
		return UUID.randomUUID().toString().substring(0, 22);
	}

	public static String encryptPayload(String clearPayload) {
		return ENCRYPTOR.PBEncrypt(clearPayload);
	}

	public static String decryptPayload(String encryptedPayload) {
		return ENCRYPTOR.PBDecrypt(encryptedPayload);
	}

	public static String leftPad(String originalString, int length, String padCharacter) {
		originalString = originalString == null ? "" : originalString;
		padCharacter = padCharacter == null ? "" : padCharacter;
		String paddedString = originalString;
		while (paddedString.length() < length) {
			paddedString = padCharacter + paddedString;
		}
		return paddedString;
	}

	// convert InputStream to String

	public static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			LOGGER.error("********Oops Something went wrong **********" + e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					LOGGER.error("********Oops Something went wrong **********" + e);
				}
			}
		}

		return sb.toString();

	}

	public static Response sendSMSToHost(String url) {
		try {
			URL smsGetUrl = new URL(url);
			URLConnection conn = smsGetUrl.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				LOGGER.debug(inputLine);
			// System.out.println(inputLine);
			in.close();
			return new Response("00", "Success.");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return new Response("99", "********Oops Something went wrong **********" + e);
		} catch (IOException e) {
			e.printStackTrace();
			return new Response("99", "********Oops Something went wrong **********" + e);
		}
	}
	
	public static <T> Response marshalObj(Object obj, String logFileLocation, String requestType, Class<T> objectClass){ 
		PrintWriter out = null;
		try { 
			
			switch(requestType==null?"":requestType){
			case "json" :
			ObjectMapper mapper = new ObjectMapper();
			File file = new File(logFileLocation+"-"+(new SimpleDateFormat("dd-MMM-YYYY").format(new Date()))+".json");
			out = new PrintWriter(new FileWriter(file, true));
			mapper.writeValue(out, obj);
			return new Response("00", "Success."); 
			
			case "xml" :
				JAXBContext jContext = JAXBContext.newInstance(objectClass);
				Marshaller marshallObj = jContext.createMarshaller();
				marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);   
				File xmlFile = new File(logFileLocation+"-"+(new SimpleDateFormat("dd-MMM-YYYY").format(new Date()))+".xml");
				out = new PrintWriter(new FileWriter(xmlFile, true));
				marshallObj.marshal(obj, out);  
				return new Response("00", "Success."); 
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new Response("99", "********Oops Something went wrong **********" + e);
		}finally{ 
			if(out!=null){
			out.flush();
			out.close();
			}
		}
		return new Response();
	}
	
	public static String getCatFORMMEXPIRYMailBody(String acctno, String acctname, String amount,String formmref, String filePath) { 
		StringBuilder responseSB =new StringBuilder();
		//Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(System.out::println); 
		try {
			Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(line -> responseSB.append(line));
		} catch (IOException e) { 
			LOGGER.error("********Oops Something went wrong **********" + e);
		} 
		
		return
		
		responseSB.toString()!=null?responseSB.toString()
				.replace("[acctno]", acctno)
				.replace("[acctname]", acctname)
				.replace("[amount]", amount)
				.replace("[formmref]", formmref)
				//.replace("[appServerandPort]", appServerAndPort)
				:""
				;
	 }	
	
	 
	  


	public static void main(String[] args) throws UnsupportedEncodingException, IOException { 
		
	

 //		PrintWriter out = null;
//		try {
//			JAXBContext jContext = JAXBContext.newInstance(HeaderRequest.class);
//			Marshaller marshallObj = jContext.createMarshaller();
//			marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);   
//			File file = new File("D:\\Logs\\RetailTreasuryAPI\\webservicerequests-"+(new SimpleDateFormat("dd-MMM-YYYY").format(new Date()))+".xml");
//			out = new PrintWriter(new FileWriter(file, true));
//			marshallObj.marshal(hostHeaderInfo, out); 
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{ 
//			if(out!=null){
//			out.flush();
//			out.close();
//			}
//		}

		// BigDecimal sharedFeeValue = new BigDecimal("0");
		// sharedFeeValue =sharedFeeValue.add(new BigDecimal("30000"));
		// LOGGER.info("++++ sharedFeeValue ==> " + sharedFeeValue + " ++++");

		// String advCust = "Dear Tunde, @*)@*#(#(It is well..";
		// //String advCust = "Dear Customer, your Debit Card is ready. Pls pick
		// it up at Ecobank Emab Plaza branch, Abuja or change pickup point via
		// email to AdvantageBankingNG@ecobank.com (158)";
		//
		// System.out.println((advCust==null?"":advCust.replaceAll("[^\\w\\.\\,\\s\\-]",
		// "").replaceAll(" ", "%20")));
		//// String premCust = "Evien, where are you? So u can see how SMS is
		// suppose to work???";
		////
		//// String deal1 =
		// "http://10.12.224.142:8080/SmsUrlService/smsSender?accountId=141-461-796-12348&password=LkaSKIvM&srcAddr=ECOBANK&destAddr=+2348162810070&msg='"+
		// advCust +"'%20Cards!!!&hostName=wmp.ecobank.com&carrierId=6";
		//// //URLConnectionReader(deal1);
		//// System.out.println(deal1);
		////
		// String advCust="test";
		// String deal2 =
		// "http://10.12.224.142:8080/SmsUrlService/smsSender?accountId=141-461-796-12348&password=LkaSKIvM&srcAddr=ECOBANK&destAddr=+2348077922440&msg="+
		// (advCust==null?"":advCust.replaceAll("[^\\w\\.\\,\\s\\-]",
		// "").replaceAll(" ", "%20")) +"&hostName=wmp.ecobank.com&carrierId=6";
		// sendSMSToHost(deal2);
		// System.out.println(deal2);

		// BmDYNH0WiXKWIjQ85Iv03g==
		// String clear = decryptPassword("xjzUGF6SvAptjZwHkJkK7g==");
		// LOGGER.info("+++++ clear "+clear);

		// DocManagerSettings.setHost("10.12.193.203");
		// DocManagerSettings.setPort(8888);
		// // DocumentManagerFactory factory = new DocumentManagerFactory();
		// File file = new
		// File("C:\\Users\\tyakubu\\Documents\\docman\\testfilert.txt");
		// SaveDocResponse saveDocumentResponse =
		// DocumentManagerFactory.saveDocumentFile("RT", "Test Document", file,
		// "text/plain");
		// Response response = new Response();
		// response.setResponseCode(saveDocumentResponse.getResponseCode()!=null?saveDocumentResponse.getResponseCode():"");
		//
		//
		// System.out.println("++++++++ Response ==> " + (saveDocumentResponse
		// != null ? saveDocumentResponse.getResponseMessage() : ""));
	}

}
