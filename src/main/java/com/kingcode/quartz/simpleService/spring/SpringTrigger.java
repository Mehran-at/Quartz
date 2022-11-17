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
class SpringTrigger {

    @Bean("Trigger of SimpleTriggerFactoryBean")
    public SimpleTriggerFactoryBean trigger(@Qualifier("jobDetailOfJobDetailFactoryBean") JobDetail job) {
        int frequencyInSec = 10;
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(job);
        log.info("Configuring trigger to fire every {} seconds", frequencyInSec);
        trigger.setRepeatInterval(frequencyInSec * 1000);
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        return trigger;
    }
}
