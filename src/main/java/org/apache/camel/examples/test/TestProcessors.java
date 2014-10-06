package org.apache.camel.examples.test;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestProcessors {

	
	public void startCamelServer() {
		try {
			ApplicationContext springcontext = new FileSystemXmlApplicationContext(
					"D:/WS_Dialog_1/camel-sqs-example/src/main/resources/META-INF/spring/camel-contex.xml");
			CamelContext context = springcontext.getBean("sqsContext", CamelContext.class);
			context.start();
			Thread.sleep(5000);
			context.stop();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static void main(String[] args) {
		TestProcessors processors = new TestProcessors();
		processors.startCamelServer();
	}
}
