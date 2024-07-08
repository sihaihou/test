package com.reyco.core;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class MyApplicaton {

	public static void main(String[] args) throws ServletException, LifecycleException, InterruptedException {
		
		Connector connector = new Connector();
		connector.setPort(80);
		
		Tomcat tomcat = new Tomcat();
		tomcat.addWebapp("/", "D:\\application\\workspace\\myspringboot");
		tomcat.setConnector(connector);
		tomcat.start();
		
		tomcat.getServer().await();
		
	}
}
