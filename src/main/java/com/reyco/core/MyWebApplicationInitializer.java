package com.reyco.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		
		ServletRegistration.Dynamic dispatcher = container.addServlet("app",new DispatcherServlet(applicationContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
