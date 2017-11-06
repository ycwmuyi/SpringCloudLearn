package com.ycw.spring_cloud_learn.controller;

import com.ycw.spring_cloud_learn.bean.User;
import com.ycw.spring_cloud_learn.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: yangchengwei
 * Date: 2017/10/16 22:24
 * Description:
 * History:
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "/hi2",method = RequestMethod.GET)
    public String hi(@RequestBody User user){
        return schedualServiceHi.hi(user);
    }

    @RequestMapping(value = "/hi3",method = RequestMethod.GET)
    public  User hi(@RequestHeader("name") String name, @RequestHeader("id") Integer id, @RequestHeader("phoneNumber") String phoneNumber){
        return schedualServiceHi.hi(name,id,phoneNumber);
    }

}
