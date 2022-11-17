package com.kingcode.quartz.simpleService.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Slf4j
@Configuration
@Profile("application-quartz")
class QuartzTrigger {

    @Bean("Trigger of Quartz")
    public Trigger trigger(@Qualifier("jobDetail of Quartz") JobDetail job) {
        log.info("Quartz Trigger");
        return TriggerBuilder
            .newTrigger()
            .forJob(job)
            .withIdentity("Quartz_Trigger")
            .withDescription("Sample Quartz_Trigger trigger")
            .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(3))
            .build();
    }
}
