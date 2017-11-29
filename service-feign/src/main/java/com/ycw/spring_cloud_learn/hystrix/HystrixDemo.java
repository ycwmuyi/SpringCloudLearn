package com.ycw.spring_cloud_learn.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * Author: yangchengwei
 * Date: 2017/11/28 16:28
 * Description:
 * History:
 */
public class HystrixDemo extends HystrixCommand {

    public HystrixDemo(String p1,String p2){
        super((Setter) null);
    }

    protected HystrixDemo(HystrixCommandGroupKey group) {
        super(group);
    }

    protected HystrixDemo(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool) {
        super(group, threadPool);
    }

    protected HystrixDemo(HystrixCommandGroupKey group, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected HystrixDemo(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, threadPool, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected HystrixDemo(Setter setter) {
        super(setter);
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }


}
