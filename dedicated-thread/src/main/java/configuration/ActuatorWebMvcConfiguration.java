//package configuration;
//
//import org.apache.catalina.connector.Connector;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.server.WebServerFactoryCustomizer;
//import org.springframework.context.annotation.Bean;
//
//@ManagementContextConfiguration
//public class ActuatorWebMvcConfiguration {
//
//    @Value("${management.server.port}")
//    static int managementPort;
//
//    @Bean
//    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatConfiguration() {
//        return new TomcatConfiguration();
//    }
//
//    private static class TomcatConfiguration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
//        @Override
//        public void customize(TomcatServletWebServerFactory factory) {
//            factory.addConnectorCustomizers(new TomcatConnectorConfiguration());
//        }
//    }
//
//    private static class TomcatConnectorConfiguration implements TomcatConnectorCustomizer {
//        @Override
//        public void customize(Connector connector) {
//            // do stuff
//            if (connector.getPort() == managementPort) {
//                connector.setProperty("maxThreads", "10");
//                connector.setProperty("minSpareThreads", "2");
//                System.out.println("Configured management server thread pool: maxThreads=10, minSpareThreads=2");
//            }
//        }
//    }
//}
