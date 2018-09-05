package brokers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Broker Backend Service Main App
 *
 */
@SpringBootApplication
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Configuration
    public class RestSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("---------------------->>>>>>>>>>>>>>>>>>>>>>>>>disabled");
            http.csrf().disable();
        }
    }
}
