package com.example.dedicated_thread.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AdditionalTomcatConnectorConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return factory -> {
            Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
            connector.setPort(9090);
            connector.setProperty("maxThreads", "2");
            connector.setProperty("minSpareThreads", "2");
            factory.addAdditionalTomcatConnectors(connector);
            System.out.println("max threads: "+connector.getProperty("maxThreads"));
            System.out.println("new connector: protocol handler: "+connector.getProtocolHandler() + "port:"+connector.getPort());
        };
    }
}