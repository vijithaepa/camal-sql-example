package org.apache.camel.examples.builder;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.examples.model.Person;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ProducerRouteBuilder extends RouteBuilder {

	Random randomGenerator = new Random();
	private static final int MAX = 10;
	private static int index = 0;

	private String getLoginMessage() {
		return "{" + "\"id\": " + ++index + "," + "\"type\": \"login\"," + "\"payload\" : {"
				+ "\"name\": \"vijitha\", " + "\"city\": \"carnegie\"" + "}" + "}";
	}

	private String getLogoutMessage() {
		return "{" + "\"id\": " + ++index + "," + "\"type\": \"login\"," + "\"payload\" : {"
				+ "\"name\": \"vijitha\", " + "\"city\": \"carnegie\"" + "}" + "}";
	}

	// @Override
	// public void configure() throws Exception {
	//
	// // every two seconds, send a message to the "demo" queue in SQS
	//
	// from("timer:kickoff?period=60000")
	// .setBody().method(this, "generateJsonString")
	// .to("bean:sqsProdBeanProcessor?method=processSQSMessage")
	// .to("aws-sqs://Demo?amazonSQSClient=#sqsClient&defaultVisibilityTimeout=2&amazonSQSEndpoint=https://sqs.ap-southeast-2.amazonaws.com");
	//
	// }

	@Override
	public void configure() throws Exception {

		String toSqs = "aws-sqs://Dev_HeaderTest?amazonSQSClient=#sqsClient";
		from("timer:kickoff?period=5000")
			.setHeader("some_Header", simple("Some_Value"))
			.setHeader(Exchange.HTTP_METHOD, constant("POST"))
			.setBody()
			.method(this, "generateJsonString")
			.setHeader("anotherHed", simple("Another Val"))
			.setProperty("p2", simple("property 2"))
			.to("bean:sqsProdBeanProcessor?method=processSQSMessage")
			.to(toSqs);

	}

	public Object generateJsonString() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Index : " + index);
		ObjectMapper mapper = new ObjectMapper();
		Writer strWriter = new StringWriter();
		mapper.writeValue(strWriter, new Person(++index, "AA", "aaaaaaaaaa"));
		int rand = randomGenerator.nextInt(MAX);
		// if ((rand % 2) == 0) {

//		 return getLoginMessage();
		// } else {
		// return LOGOUT_MESSAGE;
		// }

		
		return strWriter.toString();
	}
}
