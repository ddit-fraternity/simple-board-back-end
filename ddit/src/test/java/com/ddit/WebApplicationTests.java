package com.ddit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WebApplicationTests {
    
    static{
        System.setProperty("spring.config.location", "classpath://config/application.yml,classpath://config/project.yml");
    }

    @Test
    void contextLoads(){
        
    }
}
