package com.kingcode.quartz.simpleService.spring;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;

@Slf4j
@Configuration
@ConditionalOnExpression("'${using.spring.schedulerFactory}'=='true'")
@Profile("application.properties")
class SpringScheduler {
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SchedulerFactoryBean scheduler(
        @Qualifier("Trigger of SimpleTriggerFactoryBean") Trigger trigger,
        @Qualifier("jobDetailOfJobDetailFactoryBean") JobDetail job,
        DataSource quartzDataSource
    ) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("application.properties"));
        log.debug("Setting the Scheduler up");
        schedulerFactoryBean.setJobFactory(springBeanJobFactory());
        schedulerFactoryBean.setJobDetails(job);
        schedulerFactoryBean.setTriggers(trigger);
        // Comment the following line to use the default Quartz job store.
        schedulerFactoryBean.setDataSource(quartzDataSource);
        log.info("Spring scheduler factory");
        return schedulerFactoryBean;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        log.debug("Configuring Job factory");
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }
}
