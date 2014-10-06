package org.apache.camel.examples.builder;

import org.apache.camel.builder.RouteBuilder;

public class ConsumerRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//    	RouteDefinition
        from("aws-sqs://Dev_HeaderTest?amazonSQSClient=#sqsClient&deleteAfterRead=true")
//                .setHeader("identity").jsonpath("$['type']")
//                .filter(simple("${header.identity} == 'login'"))
                .log("We have a message! ${body}")
                .to("file:target/output?fileName=login-message-${date:now:MMDDyy-HHmmss}.json")
        		.to("bean:sqsConsBeanProcessor?method=processSQSMessage");
    }
}
