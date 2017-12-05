package com.ycw.spring_cloud_learn.feign_service;

import com.ycw.spring_cloud_learn.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ycw on 2017/10/16.
 */
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hi2",method = RequestMethod.GET)
    String hi(@RequestBody User user);

    @RequestMapping(value = "/hi3",method = RequestMethod.GET)
    User hi(@RequestHeader("name") String name, @RequestHeader("id") Integer id, @RequestHeader("phoneNumber") String phoneNumber);

}
