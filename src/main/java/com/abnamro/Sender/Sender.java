package com.abnamro.Sender;



import org.apache.activemq.command.ActiveMQDestination;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;






public class Sender {

	public static void main(String[] args) 
{
		ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
		
		JmsTemplate template= (JmsTemplate) context.getBean("jmsTemplate");
		
		ActiveMQDestination destination=(ActiveMQDestination)context.getBean("myAppInboundQueue");
		
		System.out.println("Connection acheived. Pushing Message sequentially");
		
		template.convertAndSend(destination,"Hello.kakka");
		template.convertAndSend(destination,"Hello.varun");
		template.convertAndSend(destination,"Hello.amit");
		
		

	}

}



//Spring BOOT: JmsTemplate and DefaultJmsListenerContainerFactory
