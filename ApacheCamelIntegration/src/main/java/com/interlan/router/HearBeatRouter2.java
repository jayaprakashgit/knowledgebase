package com.interlan.router;

import org.apache.camel.builder.RouteBuilder;

public class HearBeatRouter2 extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:foo?period=1s")
		.transform()
		.simple("HeartBeatRouter2 rounting at ${date:now:yyyy-MM-dd HH:MM:SS}")
		.to("stream:out");
	}
	
	
}
