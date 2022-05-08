package com.example.implementingcontroller.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/8 14:15
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", DispatcherServlet.class);
        registration.addMapping("/");
        registration.setLoadOnStartup(1);
    }
}
