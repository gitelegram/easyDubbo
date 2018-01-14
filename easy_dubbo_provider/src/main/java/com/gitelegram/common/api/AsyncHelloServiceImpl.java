package com.gitelegram.common.api;

import com.alibaba.dubbo.rpc.RpcContext;

import java.util.concurrent.*;

public class AsyncHelloServiceImpl implements AsyncHelloService {

    private ExecutorService executorService = new ThreadPoolExecutor(10, 10, 2000, TimeUnit.SECONDS,
        new ArrayBlockingQueue<Runnable>(5000));

    public String asyncSayHello(String name) {
        RpcContext rpcContext = RpcContext.getContext();

        Future<String> future = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return "async";
            }
        });

        rpcContext.setFuture(future);
        return null;
    }
}
