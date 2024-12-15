package com.example.dedicated_thread.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@ManagementContextConfiguration
public class ActuatorWebMvcConfiguration {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatConfiguration() {
        return new TomcatConfiguration();
    }

    private static class TomcatConfiguration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
        @Override
        public void customize(TomcatServletWebServerFactory factory) {
            factory.addConnectorCustomizers(new TomcatConnectorConfiguration());
        }
    }

    private static class TomcatConnectorConfiguration implements TomcatConnectorCustomizer {
        @Override
        public void customize(Connector connector) {
            System.out.println("max threads: "+connector.getProperty("maxThreads"));
            connector.setProperty("maxThreads", "2");
            connector.setProperty("minSpareThreads", "2");
            System.out.println("max threads: "+connector.getProperty("maxThreads"));

        }
    }
}
