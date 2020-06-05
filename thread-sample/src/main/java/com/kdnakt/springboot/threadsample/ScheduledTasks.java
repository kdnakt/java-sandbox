package com.kdnakt.springboot.threadsample;

import java.util.concurrent.Executor;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
 
    private static Logger LOG = LogManager.getLogger(ScheduledTasks.class);

    @Scheduled(cron = "0/10 * * * * *")
    public void taskA() {
        LOG.info("Task A called.");
    }

    @Scheduled(fixedDelay = 1000 * 3)
    public void taskB() {
        LOG.info("Task B started.");
        try {
            Thread.sleep(1000 * 15);
        } catch (Exception e) {
            LOG.error(e);
        }
        LOG.info("Task B finished.");
    }
}