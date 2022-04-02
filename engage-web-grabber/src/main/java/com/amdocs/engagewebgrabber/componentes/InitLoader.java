package com.amdocs.engagewebgrabber.componentes;

import com.amdocs.engagewebgrabber.utils.LoadResourcesAsString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class InitLoader {


    @Autowired
    private RestTemplate resTemplate;
    @Value("${engage.base.url}")
    private String baseUrl;
    private LoadResourcesAsString resAsStream = new LoadResourcesAsString();
    private List<String> stockArray = new ArrayList<>();

    public String getBaseUrl() {
        return baseUrl;
    }

    public InitLoader() throws IOException {
        Init();
    }

    public List<String> getStockArray() {
        return stockArray;
    }

    private void Init() throws IOException {

        Scanner sc = new Scanner(this.resAsStream.getFileAsString());
        while (sc.hasNextLine())
        {
            stockArray.add(sc.nextLine());
        }

       // this.grabStocks();
    }

    private void grabStocks() {
        stockArray.forEach(a -> {
            URI url = URI.create(this.baseUrl + a);
            System.out.printf(this.resTemplate.getForObject(url, String.class));
        });
    }

}
