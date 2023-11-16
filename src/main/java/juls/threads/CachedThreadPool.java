package juls.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    private static volatile ExecutorService executorService; // volatile is needed for security reasons

    private CachedThreadPool() {
        executorService = Executors.newCachedThreadPool();
    }

    public static ExecutorService getInstance() {

        if(executorService == null) {
            synchronized (CachedThreadPool.class) {
                if (executorService == null) {
                    executorService = Executors.newCachedThreadPool();
                }
            }
        }

        return executorService;
    }
}
