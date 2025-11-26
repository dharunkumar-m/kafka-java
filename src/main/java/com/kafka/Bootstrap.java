package com.kafka;

import com.kafka.consumer.Consumer;
import com.kafka.producer.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bootstrap {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        EXECUTOR_SERVICE.execute(new Producer());
        EXECUTOR_SERVICE.execute(new Consumer());

    }

}
