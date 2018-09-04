package brokers;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException; 
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder; 
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import; 
import org.springframework.context.support.ResourceBundleMessageSource; 
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.client.RestTemplate;

import brokers.configuration.DbConfiguration;
import brokers.configuration.SwaggerConfig; 

@Import({ DbConfiguration.class,SwaggerConfig.class })
@SpringBootApplication(scanBasePackages = { "bokers" })  
@EnableScheduling  
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	} 

	/**
	 * Configure MessageSource to lookup any validation/error message in
	 * Internationalised property files
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}


	@SuppressWarnings("deprecation")
	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException { 
		SSLContextBuilder builder = new SSLContextBuilder();
		 builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());

		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(builder.build(), NoopHostnameVerifier.INSTANCE);
		
		
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
	            .register("http", new PlainConnectionSocketFactory())
	            .register("https", csf)
	            .build();

		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
		 cm.setMaxTotal(100);
		 CloseableHttpClient httpclient = HttpClients.custom()
		            .setSSLSocketFactory(csf)
		            .setConnectionManager(cm)
		            .build();

		HttpComponentsClientHttpRequestFactory requestFactory =
		        new HttpComponentsClientHttpRequestFactory();

		requestFactory.setHttpClient(httpclient); 
		
		RestTemplate restTemplate = new RestTemplate(requestFactory);	 
		
		return restTemplate; 
	}
 
}
