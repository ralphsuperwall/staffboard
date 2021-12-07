package com.test.staffcomtrue.email;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SendQuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String name = jobExecutionContext.getMergedJobDataMap().getString("name");
        System.out.println("staff administration system : " + name);
    }
}
