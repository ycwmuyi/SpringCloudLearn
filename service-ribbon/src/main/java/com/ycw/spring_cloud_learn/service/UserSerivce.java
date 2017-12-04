package com.ycw.spring_cloud_learn.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.ycw.spring_cloud_learn.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * Author: yangchengwei
 * Date: 2017/11/29 23:11
 * Description:
 * History:
 */
@Service
public class UserSerivce {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand
    public User getUserByName(String name){
        return restTemplate.getForObject("http://service-hi/hi?name="+name,User.class,name);
    }

    @HystrixCommand
    public Future<User> getUserByNameAsync(String name){
        return new AsyncResult<User>(){
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://service-hi/hi?name="+name,User.class,name);
            }
        };
    }



}
