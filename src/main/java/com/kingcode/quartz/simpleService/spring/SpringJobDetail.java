package com.kingcode.quartz.simpleService.spring;

import com.kingcode.quartz.simpleService.job.SampleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Slf4j
@Configuration
@Profile("application.properties")
class SpringJobDetail {

    @Bean("jobDetailOfJobDetailFactoryBean")
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(SampleJob.class);
        jobDetailFactoryBean.setDescription("Invoke Sample Job service from JobDetailFactoryBean ...");
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }
}