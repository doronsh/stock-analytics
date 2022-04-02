package com.amdocs.engagewebgrabber.configuration;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;


public class RestTemplateCustomiziationProxyWithDummySSL implements RestTemplateCustomizer {

    @Value("${engage.proxy.server}")
    private String PROXY_SERVER_HOST;
    @Value("${engage.proxy.port}")
    private int PROXY_SERVER_PORT;
    private SSLContext sc = null;

    // Create a trust manager that does not validate certificate chains
    TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
        public X509Certificate[] getAcceptedIssuers(){return null;}
        public void checkClientTrusted(X509Certificate[] certs, String authType){}
        public void checkServerTrusted(X509Certificate[] certs, String authType){}
    }};

    private void init() throws NoSuchAlgorithmException, KeyManagementException {
        sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new SecureRandom());

    }

    public RestTemplateCustomiziationProxyWithDummySSL() throws NoSuchAlgorithmException, KeyManagementException {
        this.init();
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        HttpHost proxy = new HttpHost("gproxy", 8080);
        HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {

            @Override
            public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
                    throws HttpException {
                if (target.getHostName().equals("localhost")) { //It is to filter none proxy setup
                    return null;
                }
                return super.determineProxy(target, request, context);
            }

        })      .setSslcontext(sc)
                .build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}
