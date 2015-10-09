package by.news.service.web.config;

import by.news.service.service.config.ServiceConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

public class Initializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        context.register(SecurityConfig.class);
        context.register(ServiceConfig.class);
        context.register(Beans.class);

        FilterRegistration.Dynamic encodingFilter =
                servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "");

        servletContext.setInitParameter("log4jConfigLocation", "classpath:log4j2.xml");

        servletContext.addListener(new Log4jConfigListener());
        servletContext.addListener(new ContextLoaderListener(context));

        context.setServletContext(servletContext);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(false);
        Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
