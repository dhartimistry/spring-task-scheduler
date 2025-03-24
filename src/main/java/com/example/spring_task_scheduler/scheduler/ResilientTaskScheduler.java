package com.example.spring_task_scheduler.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ResilientTaskScheduler {
    private static final int MAX_RETRIES = 4;
    private static final Logger logger = LoggerFactory.getLogger(ResilientTaskScheduler.class);

    /**
     * This method is scheduled to run every 5 seconds. It executes a task and retries in case of failure.
     * The retries stop after the maximum number of attempts.
     */
    @Scheduled(fixedRate = 5000)
    public void executeWithRetry() {
        int attempt = 0;
        while(attempt < MAX_RETRIES) {
            try {
                logger.info("Task executed at: {}", LocalTime.now());
                System.out.println("Executing task at: " + LocalTime.now());
                riskyOperation();
                break;
            } catch (Exception e) {
                attempt++;
                System.out.println("Retrying... Attempt " + attempt);
                // Log failure if max retries are reached
                if(attempt == MAX_RETRIES){
                    logger.info("Task failed after max retries.");
                }
            }

        }
    }

    /**
     * This method simulates a risky operation that has a 30% chance of failing.
     * It throws a RuntimeException if it "fails".
     */
    public void riskyOperation() {
        //create a 30% chance of failure.
        if(Math.random() > 0.7) {
            throw new RuntimeException("Simulated task failure!");
        }
    }

}
