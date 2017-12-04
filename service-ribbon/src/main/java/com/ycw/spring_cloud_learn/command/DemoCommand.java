package com.ycw.spring_cloud_learn.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Author: yangchengwei
 * Date: 2017/11/30 14:52
 * Description: Hystrix相关测试代码
 * History:
 */
public class DemoCommand extends HystrixCommand<String> {
    private String name;

    protected DemoCommand(String name) {
        super (Setter.withGroupKey((HystrixCommandGroupKey.Factory.asKey("DemoGroup")))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(100)));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1000);
        return "name:"+name+"所在线程"+Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "name:"+name+"  出错了";
    }

    public static void main(String[] args)throws Exception{
        DemoCommand demoCommand = new DemoCommand("同步调用");
        String result = demoCommand.execute();
        System.out.println("result:"+result);

        demoCommand = new DemoCommand("异步调用");
        Future<String> future = demoCommand.queue();
        result = future.get(2000, TimeUnit.MILLISECONDS);
        System.out.println("result:"+result);

        System.out.println("主线程=" + Thread.currentThread().getName());


        demoCommand = new DemoCommand("obserable调用");
        //注册观察者事件拦截
        Observable<String> fs = demoCommand.observe();
        //注册结果回调事件
        fs.subscribe(new Action1<String>() {
            @Override
            public void call(String result) {
                //执行结果处理,result 为HelloWorldCommand返回的结果
                //用户对结果做二次处理.
                System.out.println("result:"+result);
                System.out.println("主线程=" + Thread.currentThread().getName());
            }
        });


        //注册完整执行生命周期事件
        fs.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                // onNext/onError完成之后最后回调
                System.out.println("execute onCompleted");
                System.out.println("主线程=" + Thread.currentThread().getName());
            }
            @Override
            public void onError(Throwable e) {
                // 当产生异常时回调
                System.out.println("onError " + e.getMessage());
                System.out.println("主线程=" + Thread.currentThread().getName());
                e.printStackTrace();
            }
            @Override
            public void onNext(String v) {
                // 获取结果后回调
                System.out.println("onNext: " + v);
                System.out.println("主线程=" + Thread.currentThread().getName());
            }
        });


        Thread.sleep(10*1000);

    }


}
