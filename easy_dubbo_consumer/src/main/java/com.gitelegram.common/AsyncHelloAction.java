package com.gitelegram.common;

import com.alibaba.dubbo.rpc.RpcContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class AsyncHelloAction {

    public List<String> asyncSayHello(String name){
        List<String> results = new ArrayList<String>();
        System.out.println("do sync work");
        String syncResult = "syncResult";
        results.add(syncResult);
        Future<String> future = RpcContext.getContext().getFuture();
        try{
            String asyncResult = future.get();
            results.add(syncResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
}
