package com.eddocg.kafka.sample;

import org.apache.camel.builder.RouteBuilder;

public class MyRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:C://inputFolder?noop=true").to("file:C://outputFolder");
    }
}
