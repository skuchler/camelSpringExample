package com.javacodegeeks.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {
	public void configure() {
		from("timer:foo?period=1s")
		.transform()
		.simple("Heartbeat ${date:now:yyyy-MM-dd HH:mm:ss}")
		.to("stream:out");
	}
}
