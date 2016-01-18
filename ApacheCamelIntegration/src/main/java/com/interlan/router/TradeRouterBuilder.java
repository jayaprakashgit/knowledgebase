package com.interlan.router;

import org.apache.camel.builder.RouteBuilder;

public class TradeRouterBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("activemq:queue:test.queue")
		.to("bean:tradeEnricher?method=enrich")
		.to("stream:out");
	}
}
