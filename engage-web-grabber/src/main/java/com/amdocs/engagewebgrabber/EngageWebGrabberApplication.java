package com.amdocs.engagewebgrabber;

import com.amdocs.engagewebgrabber.webgraber.Loader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class EngageWebGrabberApplication {

    public static void main(String[] args) throws IOException {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(EngageWebGrabberApplication.class, args)) {

            final Loader loader = ctx.getBean(Loader.class);

            Thread mainThread = new Thread(loader);
            mainThread.start();
        }
    }
}

