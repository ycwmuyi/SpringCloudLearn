package com.ycw.spring_cloud_learn.service.impl;

import com.ycw.spring_cloud_learn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Author: yangchengwei
 * Date: 2017/10/15 14:55
 * Description:
 * History:
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public String hiService(String name) {
        return restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);
    }

}
