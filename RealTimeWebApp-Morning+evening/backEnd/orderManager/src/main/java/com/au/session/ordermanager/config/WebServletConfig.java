package com.au.session.ordermanager.config;

// mvn install:install-file -Dfile=servlet-api.jar -DgroupId=servlet -DartifactId=servlet-api -Dversion=10.0.2 -Dpackaging=jar -DlocalRepositoryPath=lib -DcreateChecksum=true
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.au.session.ordermanager.controller.SampleController;

public class WebServletConfig implements WebApplicationInitializer{
	public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(SpringConfig.class);
        webCtx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
	}
}
