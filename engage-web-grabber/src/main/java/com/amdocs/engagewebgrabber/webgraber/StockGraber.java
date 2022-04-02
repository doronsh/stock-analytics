package com.amdocs.engagewebgrabber.webgraber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.util.concurrent.Callable;

public class StockGraber implements Callable<Object> {

    private String stockname;
    private String baseUrl = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=";

    URI stockUrl;

    @Autowired
    private RestTemplate resTemplate;

    public StockGraber(String stockname,RestTemplate restmpl) {
        this.stockname = stockname;
        this.stockUrl = URI.create(this.baseUrl+stockname);
        this.resTemplate = restmpl;
    }

    @Override
    public String call() throws Exception {
        String StockDetails =  resTemplate.getForObject(this.stockUrl,String.class);
        System.out.printf(StockDetails);
        return StockDetails;
    }
}
