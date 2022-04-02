package com.amdocs.engagewebgrabber.rest;

import com.amdocs.engagewebgrabber.componentes.InitLoader;
import com.amdocs.engagewebgrabber.domain.Stock;
import javafx.beans.binding.StringBinding;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Date;

@RestController
public class GetStockInfo {

    @Autowired
    private RestTemplate resTemplate;

    @Value("${engage.base.url}")
    private String baseUrl;

    @RequestMapping(path = "/")
    public String apiTestUrl() throws IOException {
        return "<p>Current date " + new Date() + "</p>";
    }

    @RequestMapping(path= "/stocks" )
    String getStockByName(@RequestParam (value = "name" , defaultValue = "VOD" ,required = false) String name) throws IOException {
        URI url = URI.create(this.baseUrl+name);
        return this.resTemplate.getForObject(url, String.class);
    }
}
