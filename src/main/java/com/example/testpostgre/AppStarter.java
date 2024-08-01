package com.example.testpostgre;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.testpostgre.utils.AutoBaseInitializer;
import com.example.testpostgre.utils.startAutobaseWork;

@Log4j2
@Configuration
public class AppStarter {

    @Autowired
    private AutoBaseInitializer autobaseInitializer;
    @Autowired
    private startAutobaseWork  startAutobase;

    @Bean
    public ApplicationRunner init() {
        log.info("ApplicationRunner has started");
        return args -> {
            autobaseInitializer.autobaseInitialize();
            startAutobase.start();
        };
    }

}
