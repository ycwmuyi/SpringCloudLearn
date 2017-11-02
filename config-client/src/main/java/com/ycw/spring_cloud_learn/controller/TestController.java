package com.ycw.spring_cloud_learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: yangchengwei
 * Date: 2017/11/01 13:48
 * Description:
 * History:
 */
//that want to be re-initialized when configuration changes
@RefreshScope
@RestController
public class TestController {
    @Value("${document:#{null}}")
    private String from;

    @RequestMapping(value = "/from",method = RequestMethod.GET)
    public String from(){
        return this.from;
    }

}
