package com.kingcode.quartz.simpleService.quartz;

import com.kingcode.quartz.simpleService.job.SampleJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
@Profile("application-quartz")
class QuartzJobDetail {

    @Bean("jobDetail of Quartz")
    public JobDetail jobDetail() {
        log.info("Quartz Job Detail");
        return JobBuilder
            .newJob()
            .ofType(SampleJob.class)
            .storeDurably()
            .withIdentity("Quartz_Job_Detail")
            .withDescription("Invoke Sample Job service from JobDetail...")
            .build();
    }
}