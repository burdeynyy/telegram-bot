package com.vistar;

import com.vistar.config.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.telegram.telegrambots.ApiContextInitializer;


/**
 * Application entry point.
 */
@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories
public class Application {

    public static void main(final String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(Application.class, args);
    }

}
