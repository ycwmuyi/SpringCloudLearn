package com.ycw.spring_cloud_learn.controller;

import com.ycw.spring_cloud_learn.Service.ErurekaClientService;
import com.ycw.spring_cloud_learn.bean.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Author: yangchengwei
 * Date: 2017/11/06 22:28
 * Description:
 * History:
 */
@RestController
@Api(description = "hi")
public class HiController {
    @Value("${server.port}")
    String port;

    @Autowired
    private ErurekaClientService erurekaClientService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String hi(@RequestParam String name){
        return "hi "+name+",i am from port:" +port;
    }

    @RequestMapping(value = "/hi2",method = RequestMethod.GET)
    public String hi(@RequestBody User user){
        return user.toString();
    }

    @RequestMapping(value = "/hi3",method = RequestMethod.GET)
    public User hi(@RequestHeader("name") String name, @RequestHeader("id") Integer id, @RequestHeader("phoneNumber") String phoneNumber){
        return new User(name,id,phoneNumber);
    }

    @RequestMapping(value = "/client1",method = RequestMethod.GET)
    public String client1(){
        return erurekaClientService.serviceUrl();
    }

    @RequestMapping(value = "/client2",method = RequestMethod.GET)
    public String client2(){
        return erurekaClientService.serviceUrlB();
    }

    @RequestMapping(value = "/intances",method = RequestMethod.GET)
    public String intances(){
        return "";
    }


}
