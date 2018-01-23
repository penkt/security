package com.pengkey.security.config;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Component
public class MyAdditionListeners extends SpringBootServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext rootAppContext = createRootApplicationContext(servletContext);
        if (rootAppContext != null) {
            servletContext.addListener(new RequestContextListener());
        }
        else {
            this.logger.debug("No ContextLoaderListener registered, as "
                    + "createRootApplicationContext() did not "
                    + "return an application context");
        }
    }
}
