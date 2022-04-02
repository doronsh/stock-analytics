package com.amdocs.engagewebgrabber.webgraber;

import com.amdocs.engagewebgrabber.componentes.InitLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Loader implements Runnable {

    private InitLoader stockStream = new InitLoader();
    private ExecutorService threadPool;
    @Autowired
    private RestTemplate resTemplate;

    public Loader() throws IOException {
    }

    @Override
    public void run() {

        try {
            this.loadStocks();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void loadStocks() throws InterruptedException {
       // boolean running=true;

        threadPool = Executors.newCachedThreadPool();
        /*while(running){*/

            List<Callable<Object>> calls = new ArrayList<>();
            stockStream.getStockArray().forEach(a -> calls.add(new StockGraber(a,resTemplate)));
            threadPool.invokeAll(calls);
            threadPool.shutdown();
         /*   if(threadPool.isShutdown())
                running=false;*/
       //}
    }
}
