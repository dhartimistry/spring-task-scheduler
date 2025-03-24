package com.example.spring_task_scheduler.scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class SchedulerConfig {

    /**
     * This method creates a ThreadPoolTaskScheduler bean.
     * The ThreadPoolTaskScheduler is responsible for scheduling tasks in a thread pool.
     * It allows concurrent task execution with a configurable number of threads.
     *
     * @return a ThreadPoolTaskScheduler configured with a pool size of 5.
     */
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5); // 5 tasks can be executed concurrently
        scheduler.setThreadNamePrefix("SchedulerThread-");
        scheduler.initialize();
        return scheduler;
    }

}
