package com.kingcode.quartz.simpleService.job;

import com.kingcode.quartz.simpleService.service.SimpleService;
import lombok.AllArgsConstructor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.quartz.Job;


@Component
@AllArgsConstructor
public class SampleJob implements Job {

    private final SimpleService simpleService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        simpleService.simpleMethod();
    }
}
