package com.ycw.spring_cloud_learn.service;

import com.ycw.spring_cloud_learn.hystrix.HystrixDemo;
import org.springframework.stereotype.Service;

/**
 * Author: yangchengwei
 * Date: 2017/11/28 16:25
 * Description:
 * History:
 */
@Service
public class HystrixService {


    private void commandTest(){
        HystrixDemo command = new HystrixDemo("111","2332");

    }



}
