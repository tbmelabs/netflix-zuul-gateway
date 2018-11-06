package ch.tbmelabs.netflixzuulgateway.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource({"classpath:config/zuul.routes"})
public class ZuulRoutesConfiguration {

}
