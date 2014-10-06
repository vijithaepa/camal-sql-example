package org.apache.camel.examples.sqsclient;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;

public class MyAmazonSQSAsyncClient extends AmazonSQSAsyncClient{
	
	private String endpoint = "https://sqs.ap-southeast-2.amazonaws.com/<<endpoint>>";
	
	MyAmazonSQSAsyncClient(){
		super();
	}
	
	MyAmazonSQSAsyncClient(BasicAWSCredentials credentials){
		super(credentials);
	}
	
	MyAmazonSQSAsyncClient(String endPoint, BasicAWSCredentials credentials){
		super(credentials);
		setEndpoint(endPoint);
	}

	@Override
	public void setEndpoint(String endPoint) throws IllegalArgumentException {
		String endpoint = "https://sqs.ap-southeast-2.amazonaws.com";
		super.setEndpoint(endpoint);
		System.out.println("Set end point to : " + endPoint);
	}

	public String getEndpoint() {
		return endpoint;
	}
	
}
