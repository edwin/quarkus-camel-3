package com.edw.route;

import org.apache.camel.builder.RouteBuilder;
import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.timer;


/**
 * <pre>
 *     com.edw.route.TimerRoute
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 09 Nov 2023 13:58
 */
public class TimerRoute  extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(timer("foo").period(1000))
                .log("Hello World");
    }
}