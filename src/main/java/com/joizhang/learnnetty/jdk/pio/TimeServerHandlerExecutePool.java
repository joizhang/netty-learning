package com.joizhang.learnnetty.jdk.pio;

import java.util.concurrent.*;

public class TimeServerHandlerExecutePool {

    private final ExecutorService executor;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize),
                Executors.defaultThreadFactory());
    }

    public void execute(java.lang.Runnable task) {
        executor.execute(task);
    }

}
