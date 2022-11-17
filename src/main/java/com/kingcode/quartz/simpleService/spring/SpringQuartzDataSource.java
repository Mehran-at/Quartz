package com.kingcode.quartz.simpleService.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableAutoConfiguration
@Profile("application.properties")
class SpringQuartzDataSource {

    @Bean
    @QuartzDataSource
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource quartzDataSource() {
        log.info("creating quartz dataSource...");
        return DataSourceBuilder.create().build();
    }
}
