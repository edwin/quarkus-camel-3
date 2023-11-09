package com.edw.route;

import org.apache.camel.builder.RouteBuilder;

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
                .to("direct:hello-world");

        from("direct:hello-world")
                .routeId("hello-world-api")
                .log("calling getHelloWorld")
                .setBody(constant("{\"hello\":\"world\"}"));
    }
}