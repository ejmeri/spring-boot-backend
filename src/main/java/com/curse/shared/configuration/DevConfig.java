package com.curse.shared.configuration;

import java.text.ParseException;

import com.curse.business.dbstart.control.DbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class DevConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Autowired
    private DbService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if (!strategy.equals("create")) {
            return false;
        }
        
        dbService.instantiateTestDatabase();
        return true;
    }
}