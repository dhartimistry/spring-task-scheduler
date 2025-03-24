#Spring Task Scheduler Project

##Overview

A Spring Boot project demonstrating task scheduling using Java 17 and Maven. It features:
- Task Scheduler - Runs a task every 5 seconds.
- Resilient Task Scheduler - Implements retry logic for failures.

##Technologies Used
- Java 17
- Spring Boot
- Maven

##Setup & Run
- Clone the repository: https://github.com/dhartimistry/spring-task-scheduler.git
- In application.properties:
  - `logging.file.name=task-scheduler.log`
  - `logging.level.com.example.spring_task_scheduler=INFO`
- Build and run: `mvn spring-boot:run`


##Task Scheduler (Simple Scheduling)
- Runs a periodic task every 5 seconds.
- Uses ThreadPoolTaskScheduler.
- Best for simple, fixed-rate tasks like logging or notifications.

##Resilient Task Scheduler (Retry Logic)
- Handles failures with up to 4 retries.
- Suitable for tasks prone to intermittent failures (e.g., API calls).

##Summary
- Task Scheduler → Simple periodic execution.
- Resilient Task Scheduler → Failure handling with retries.

