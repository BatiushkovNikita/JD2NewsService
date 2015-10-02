package by.news.service.web.config;

import by.news.service.web.service.DefaultRolesPrefixPostProcessor;
import by.news.service.web.validator.CustomUserValidator;
import by.news.service.web.validator.NewsValidator;
import by.news.service.web.validator.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

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

    @Bean
    public Validator userValidator() {
        return new UserValidator();
    }

    @Bean
    public Validator newsValidator() {
        return new NewsValidator();
    }

    @Bean
    public CustomUserValidator customUserValidator() {
        return new CustomUserValidator();
    }

/*    @Bean
    public InternalResourceViewResolver*/

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:content");
        return messageSource;
    }

    @Bean
    public DefaultRolesPrefixPostProcessor defaultRolesPrefixPostProcessor() {
        return new DefaultRolesPrefixPostProcessor();
    }
}

