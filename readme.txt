This example demonstrates how to use Apache Camel's SWS-SQS support.

Contents :
==========
¦   .classpath
¦   .project
¦   pom.xml
¦   readme.md
¦
+---src
    +---main
        +---java
        ¦   +---org
        ¦       +---apache
        ¦           +---camel
        ¦               +---examples
        ¦                   +---builder
        ¦                   ¦       ConsBeanProcessor.java
        ¦                   ¦       ConsumerRouteBuilder.java
        ¦                   ¦       ProdBeanProcessor.java
        ¦                   ¦       ProducerRouteBuilder.java
        ¦                   ¦
        ¦                   +---model
        ¦                   ¦       Person.java
        ¦                   ¦
        ¦                   +---sqsclient
        ¦                   ¦       MyAmazonSQSAsyncClient.java
        ¦                   ¦
        ¦                   +---test
        ¦                           TestProcessors.java
        ¦
        +---resources
            ¦   default.properties
            ¦   log4j.properties
            ¦
            +---META-INF
                +---spring
                        camel-contex.xml
                        
Building the Project.
====================
     
Pre-requisites
--------------
JDK 1.5.x or higher
Maven 2 or higher
set java_home and m2_home.
eClipse 3.5 or higher   

Steps:
------
To use this example, you should first replace the access key and security key
in the src/main/resources/default.properties file with those that belong to your AWS
account.

Next, you should log into your AWS account, navigate to the SQS panels and create a new queue named 'Dev_HeaderTest'

Last, you can run the example with 'mvn camel:run'

You should see that one of the two routes produces JSON messages every 5 seconds to the 'Dev_HeaderTest' queue. You should also note that there are two types of messages:

The second camel route will consume the messages.

Alternatively You can run the main method in TestProcessors.java

Refer :
http://www.christianposta.com/blog/?p=340
http://java.dzone.com/articles/jms-style-selectors-amazon-sqs
http://weblog4j.com/2013/05/14/amazon-sqs-listening-to-sqs-using-apache-camel-the-spring-dsl-way/
