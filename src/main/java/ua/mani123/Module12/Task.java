package ua.mani123.Module12;

import ua.mani123.EnableLogger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task extends EnableLogger {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

    long startTime;

    public Task() {
        this.startTime = System.currentTimeMillis();
    }

    public void runEverySecondTask() {
        executorService.scheduleAtFixedRate(() -> logger.info(System.currentTimeMillis() - startTime / 1000 + " seconds elapsed"), 0, 1, TimeUnit.SECONDS);
    }

    public void runEveryFiveSecondsTask() {
        executorService.scheduleAtFixedRate(() -> logger.info("5 seconds have passed"), 0, 5, TimeUnit.SECONDS);
    }

}
