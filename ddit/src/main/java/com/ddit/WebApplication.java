package com.ddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBootApplication = @SpringBootConfiguration + @ComponentScan + @EnableAutoConfiguration
 */
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {
    
    /**
     * Configuration File Setting
     * - BaseApplicationTests.java에도 동일하게 설정해야 합니다. jjh
     */
    static {
        System.setProperty("spring.config.location", "classpath:/config/application.yml");
    }
    
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(WebApplication.class);
    }
}
