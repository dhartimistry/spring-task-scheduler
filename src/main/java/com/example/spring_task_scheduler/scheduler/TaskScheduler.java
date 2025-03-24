package com.example.spring_task_scheduler.scheduler;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@Service
public class TaskScheduler {
    private static final Logger logger = LoggerFactory.getLogger(TaskScheduler.class);

    private final ThreadPoolTaskScheduler scheduler; //ThreadPoolTaskScheduler for managing the scheduled tasks

    public TaskScheduler(ThreadPoolTaskScheduler scheduler) {
        this.scheduler = scheduler;
    }
    @PostConstruct
    public void startScheduler() {
        executeTask(); // Start the scheduler when the service is initialized
    }

    /**
     * This method schedules the task to run every 5 seconds.
     * It logs the execution time to demonstrate task execution.
     */
    public void executeTask() {
        ScheduledFuture<?> future = scheduler.schedule(
                () -> logger.info("Task executed at: {}", LocalTime.now()),
                triggerContext -> {
                    return new Date(System.currentTimeMillis() + 5000).toInstant(); // Runs every 5 sec
                }
        );
    }

}
