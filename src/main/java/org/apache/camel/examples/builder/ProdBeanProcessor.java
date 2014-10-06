package org.apache.camel.examples.builder;

import java.util.Map;

import org.apache.camel.Exchange;

public class ProdBeanProcessor {

	public void processSQSMessage(Exchange exchange) {
		Map<String, Object> headers = exchange.getIn().getHeaders();
		headers.put("hi", "HeaderType");
		exchange.getIn().setHeader("CamelAwsSqsAttributes", headers);
		exchange.getIn().setHeader("CamelAwsSqsMD5OfBody", "RRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		
		exchange.setProperty("p1", "Property 1");
		exchange.getOut().setBody("Hello Message " + exchange.getIn().toString());
		
		headers.put("CamelAwsSqsAttributes", "GGGGGGGGGGGG");
		exchange.getOut().setHeaders(headers);
		
		System.out.println("prod In MSG : " + exchange.getIn().toString());
		System.out.println("prod In Header : " + exchange.getIn().getHeaders());
		System.out.println("Prod out Header : " + exchange.getOut().getHeaders());
		System.out.println("Prod out Header After: " + exchange.getOut().getHeaders());
//		exchange.getOut().setHeader("Another Header", "Another _Value");
	}

}
