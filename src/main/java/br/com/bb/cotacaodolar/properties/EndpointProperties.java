package br.com.bb.cotacaodolar.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("endpoints")
@Data
public class EndpointProperties {
    private boolean debug;
    private API api1;

    @Data
    public static class API {
        @Value("${base-url}")
        private String baseUrl;
        private String username;
        private String password;
    }
}
