package com.example.demo.com.config;

import com.example.demo.com.server.MyFirstJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName : QuartzConfig
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-14
 */
/*@Configuration
@EnableSwagger2*/
public class QuartzConfig {
    /*@Bean
    public JobDetail jobDetail1(){
        //这里传入MyFirstJob业务类。
        return JobBuilder.newJob(MyFirstJob.class).storeDurably().build();
    }
    //定时调用
    @Bean
    public Trigger trigger1(){
        return TriggerBuilder.newTrigger()
                .withIdentity("任务1","1组")
                //每2秒执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?*"))
                .forJob(jobDetail1()) //这个定时任务要执行的是哪个调度器
                .build();
    }
    @Bean
    public Trigger trigger2(){
        return TriggerBuilder.newTrigger()
                .withIdentity("任务2","2组")
                //每5秒执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?*"))
                .forJob(jobDetail1())
                .build();
    }*/
}
