package com.configuration;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by wangyong on 2016/7/3.
 */
public class CommonInitializer
 //       implements WebApplicationInitializer
{

    /**
     * 启动设置
     *
     * @param servletContext
     * @throws ServletException
     */
/*    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));


        //dispatcherServlet，默认会读取/WEB-INF/dispatcherServlet-servlet.xml配置文件
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet());
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
    }


    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //配置springmvc配置文件
        //context.setConfigLocation("com");
        return context;
    }*/
}
