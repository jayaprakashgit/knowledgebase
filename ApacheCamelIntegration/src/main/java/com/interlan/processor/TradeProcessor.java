package com.interlan.processor;

import java.time.Clock;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TradeProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		exchange.getIn().setBody("TradeProcessor :: process - HearBeat "+Clock.systemDefaultZone());
	}
}
