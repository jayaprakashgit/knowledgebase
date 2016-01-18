package com.interlan;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FacebookIntegrationTest extends CamelSpringTestSupport{
	
	@Override
	protected AbstractApplicationContext createApplicationContext(){
		return new ClassPathXmlApplicationContext("facebookIntegration.xml");
	}
	
	@Test
	public void testFacebookRoute() throws UnsupportedEncodingException, InterruptedException{
		String token = "ABC-Generated-From-Facebook";
		token = URLEncoder.encode(token, "UTF-8");
		MockEndpoint end = getMockEndpoint("mock:finish");
		end.setExpectedMessageCount(1);
		Map<String, Object> headers = new HashMap<>();
		headers.put("AccessToken", token);
		sendBody("direct:start", null, headers);
		end.assertIsSatisfied();
	}

}
