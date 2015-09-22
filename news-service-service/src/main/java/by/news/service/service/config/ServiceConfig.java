package by.news.service.service.config;

import by.news.service.daojpa.config.DataConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "by.news.service.service" })
@Import(DataConfig.class)
public class ServiceConfig {

/*    @Bean
    public SecurityService securityService() {
        return new SecurityServiceImpl();
    }*/
}
