package com.chl.springdemo.controller;

import com.chl.springdemo.utils.RedisIdWorker;
import jakarta.annotation.Resource;

import java.util.concurrent.*;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/12/26 17:34
 * @注释
 */
public class HmDianPing {

    @Resource
    private RedisIdWorker redisIdWorker;

//    private ExecutorService es = Executors.newFixedThreadPool(500);
private ExecutorService es = new ThreadPoolExecutor(
        500,
        5,
        //最大可以工作的线程个数
        10,
        //线程释放时间
        TimeUnit.MICROSECONDS,
        //线程释放时间单位
        new LinkedBlockingDeque<>(3),
        //超过3个线程等待则出发最大线程
        Executors.defaultThreadFactory(),
        //
        new ThreadPoolExecutor.DiscardOldestPolicy());

    public String redisId(){
        CountDownLatch latch = new CountDownLatch(300);

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                long id = redisIdWorker.nextId("order");
                System.out.println("id = " + id);
            }
            latch.countDown();
        };
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 300; i++) {
            es.submit(task);
        }
        try {
            latch.await(); //等待上面的结束
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - begin));
        return "";
    }


}
