package org.apache.camel.examples.builder;

import org.apache.camel.Exchange;
import org.apache.camel.examples.model.Person;

public class ConsBeanProcessor {

	public void processSQSMessage(Exchange exchange) {
		System.out.println("Consumer Properties : " + exchange.getProperty("p1") + " : " + exchange.getProperty("p2"));
		System.out.println("Consumer In Body : " + exchange.getIn().toString());
		System.out.println("Consumer In Headers : " + exchange.getIn().getHeaders());
		System.out.println("Consumer Out Body : " + exchange.getOut().toString());
		System.out.println("Consumer Out Headers : " + exchange.getOut().getHeaders());
	}
}
