package com.amdocs.engagewebgrabber.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
public class LoadResourcesAsString {

    ResourceLoader resourceLoader = new DefaultResourceLoader();
    Resource resource = resourceLoader.getResource("classpath:Stocknames.txt");

    public String getFileAsString() throws IOException {
        Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8);

        try
        {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e)
        {
            throw new UncheckedIOException(e);
        }
    }

}
