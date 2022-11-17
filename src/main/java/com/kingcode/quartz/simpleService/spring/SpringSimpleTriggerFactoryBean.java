package com.kingcode.quartz.simpleService.spring;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Slf4j
@Configuration
@Profile("application.properties")
class SpringSimpleTriggerFactoryBean {

    @Bean("Trigger of SimpleTriggerFactoryBean")
    public SimpleTriggerFactoryBean trigger(@Qualifier("jobDetailOfJobDetailFactoryBean") JobDetail job) {
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(job);
        trigger.setRepeatInterval(3600000);
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        log.info("Spring trigger");
        return trigger;
    }
}
