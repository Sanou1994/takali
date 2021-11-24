package com.connecsen.oterrain.jobs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.connecsen.oterrain.service.AccountService;
import com.connecsen.oterrain.service.IAccountService;

@Configuration
@ComponentScan(
  basePackages="com.connecsen.oterrain",
  basePackageClasses={JobRunner.class,IAccountService.class,AccountService.class})
public class ThreadPoolTaskSchedulerConfig {

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler
          = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix(
          "ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
    }
}