package com.kingcode.quartz.simpleService.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Slf4j
@Configuration
@Profile("application-quartz")
@ConditionalOnExpression("'${using.spring.schedulerFactory}'=='false'")
class QuartzStdSchedulerFactory {

    @Bean
    public Scheduler scheduler(
        @Qualifier("Trigger of Quartz") Trigger trigger,
        @Qualifier("jobDetail of Quartz") JobDetail job,
        SchedulerFactoryBean factory
    ) throws SchedulerException {
        log.info("Quartz Scheduler");
        Scheduler scheduler = factory.getScheduler();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
        return scheduler;
    }
}
