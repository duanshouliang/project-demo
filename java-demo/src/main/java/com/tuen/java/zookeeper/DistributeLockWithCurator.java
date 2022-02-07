package com.tuen.java.zookeeper;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.server.watch.WatcherCleaner;
import sun.misc.Cleaner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DistributeLockWithCurator {
    private InterProcessMutex interProcessMutex;
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public boolean tryLock(long timeout, TimeUnit unit) throws Exception {
        try {
            return interProcessMutex.acquire(timeout, unit);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean unlock(){
        try {
            interProcessMutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //zookeeper节点清理
//            executorService.schedule(new Cleaner(null,null), 1L);
//
////            executorService.schedule(new ))
        }
        return false;
    }
}
