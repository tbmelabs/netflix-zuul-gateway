package ch.tbmelabs.netflixzuulgateway.configuration;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.spi.HttpFacade.Request;
import org.keycloak.representations.adapters.config.AdapterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfigResolverConfiguration {

  private AdapterConfig adapterConfig;

  public KeycloakConfigResolverConfiguration(AdapterConfig adapterConfig) {
    this.adapterConfig = adapterConfig;
  }

  @Bean
  public KeycloakConfigResolver keycloakConfigResolver() {
    return new CustomKeycloakSpringBootConfigResolver(adapterConfig);
  }

  public static class CustomKeycloakSpringBootConfigResolver implements KeycloakConfigResolver {

    private KeycloakDeployment keycloakDeployment;

    public CustomKeycloakSpringBootConfigResolver(AdapterConfig adapterConfig) {
      this.keycloakDeployment = KeycloakDeploymentBuilder.build(adapterConfig);
    }

    public KeycloakDeployment resolve(Request facade) {
      return keycloakDeployment;
    }
  }
}
