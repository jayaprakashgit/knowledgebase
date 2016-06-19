package com.interlan;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.jaxrs.client.WebClient;

public class RestWebClient {

	public static void main(String[] args) {
		
		String  authorizationHeader = "Basic "+Base64Utility.encode("jp:jp123".getBytes());
		// TODO Auto-generated method stub
		String baseAddress = "http://localhost:8081/RestfulServer/rest/customer";
		String detailUrl = "/getdetails/";
		String username="jp";
		
		String postPath = "/addcustomer";
		
		WebClient client = WebClient.create(baseAddress);
		client.header("Authorization", authorizationHeader);
		WebClient getClient = client.path(detailUrl).path(username).accept(MediaType.APPLICATION_JSON);
		String userDetailsJson = getClient.get(String.class);
		System.out.println(userDetailsJson);
		
		client.reset();
		client.header("Authorization", authorizationHeader);
		WebClient postClient = client.path(postPath).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
		String postResponse = postClient.post(userDetailsJson, String.class);
		System.out.println(postResponse);
		
/*		getClient.reset();
		client.header("Authorization", authorizationHeader);
		String inputData = "<customer><address>Bedok</address><age>19</age><name>JP-2a03d02a-437c-488f-9b02-1a32fb35f921</name></customer>";
		WebClient postClient = client.path(postPath).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML);
		String postResponse = postClient.post(inputData, String.class);
		System.out.println(postResponse);
*/		
	}

}
