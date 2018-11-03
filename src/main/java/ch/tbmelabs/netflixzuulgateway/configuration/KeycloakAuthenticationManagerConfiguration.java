package ch.tbmelabs.netflixzuulgateway.configuration;

import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;

@Configuration
public class KeycloakAuthenticationManagerConfiguration {

  private ObjectPostProcessor<Object> objectPostProcessor;

  public KeycloakAuthenticationManagerConfiguration(
      ObjectPostProcessor<Object> objectPostProcessor) {
    this.objectPostProcessor = objectPostProcessor;
  }

  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    final AuthenticationManagerBuilder builder =
        new AuthenticationManagerBuilder(objectPostProcessor);
    builder.authenticationProvider(keycloakAuthenticationProvider());
    return builder.build();
  }

  private KeycloakAuthenticationProvider keycloakAuthenticationProvider() {
    final KeycloakAuthenticationProvider keycloakAuthenticationProvider =
        new KeycloakAuthenticationProvider();
    keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
    return keycloakAuthenticationProvider;
  }
}
