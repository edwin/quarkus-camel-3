package com.edw.route;

import org.apache.camel.builder.RouteBuilder;

import java.util.HashMap;

/**
 * <pre>
 *     com.edw.route.HelloWorldApiRoute
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 09 Nov 2023 14:49
 */
public class HelloWorldApiRoute  extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration().port(8080);

        rest("/api")
                .get("/hello-world").produces("application/json")
                    .to("direct:hello-world")
                .get("/hello-world-hashmap").produces("application/json")
                    .to("direct:hello-world-hashmap");

        from("direct:hello-world")
                .routeId("hello-world-api")
                .log("calling getHelloWorld")
                .setBody(constant("{\"hello\":\"world\"}"));

        from("direct:hello-world-hashmap")
                .routeId("hello-world-hashmap-api")
                .log("calling getHelloWorld-hashmap")
                .process(exchange -> {
                    exchange.getMessage().setBody(new HashMap(){{
                        put("hello", "world");
                    }});
                }).marshal().json();
    }
}