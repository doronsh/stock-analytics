package com.amdocs.engagewebgrabber.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

@Configuration
public class RestTemplateConfiguration {


    private int connectTimeout = 3000;
    private final RestTemplateCustomiziationProxyWithDummySSL restcust = new RestTemplateCustomiziationProxyWithDummySSL();

    public RestTemplateConfiguration() throws NoSuchAlgorithmException, KeyManagementException {
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder bldr){
        return bldr.setConnectTimeout(connectTimeout)
                   .customizers(restcust)
                   .build();
    }
}
