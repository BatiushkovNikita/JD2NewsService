package by.news.service.web.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan( {"by.news.service.web"} )
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource createReloadableResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("classpath:content", "classpath:ValidationMessages");
        return messageSource;
    }

    @Bean
    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {

        Logger Log = LogManager.getLogger(SimpleMappingExceptionResolver.class.getName());

        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties errorMaps = new Properties();

        errorMaps.setProperty(NullPointerException.class.getName(), "error");

        Log.error("NullPointerException");

        resolver.addStatusCode("error", 404);
        resolver.setDefaultErrorView("exception");
        resolver.setExceptionMappings(errorMaps);
        resolver.setExceptionAttribute("openException");
        resolver.setWarnLogCategory("warn");


        //errorMaps.setProperty(HttpStatus.NOT_FOUND.getClass().getName(), "error");
        return resolver;
    }
}

