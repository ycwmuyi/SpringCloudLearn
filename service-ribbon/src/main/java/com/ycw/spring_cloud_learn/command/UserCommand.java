package com.ycw.spring_cloud_learn.command;

import com.netflix.hystrix.HystrixCommand;
import com.ycw.spring_cloud_learn.bean.User;
import org.springframework.web.client.RestTemplate;

/**
 * Author: yangchengwei
 * Date: 2017/11/29 22:48
 * Description:
 * History:
 */
public class UserCommand extends HystrixCommand<User> {
    private RestTemplate restTemplate;
    private String name;


    protected UserCommand(Setter setter,RestTemplate restTemplate,String name) {
        super(setter);
        this.restTemplate = restTemplate;
        this.name = name;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://service-hi/user?name="+name,User.class);
    }


}
