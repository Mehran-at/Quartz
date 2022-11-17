package com.kingcode.quartz.simpleService.job;

import com.kingcode.quartz.simpleService.service.SimpleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SampleJob implements Job {

    private final SimpleService simpleService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info(
            "Job ** {} ** fired @ {}",
            jobExecutionContext.getJobDetail().getKey().getName(),
            jobExecutionContext.getFireTime()
        );
        simpleService.simpleMethod();
        log.info("Next job scheduled @ {}", jobExecutionContext.getNextFireTime());
    }
}
