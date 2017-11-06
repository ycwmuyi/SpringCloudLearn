package com.ycw.spring_cloud_learn.bean;

/**
 * Author: yangchengwei
 * Date: 2017/11/06 22:35
 * Description:
 * History:
 */
public class User {

    public User() {
    }

    public User(String name, Integer id, String phoneNumber) {
        this.name = name;
        Id = id;
        this.phoneNumber = phoneNumber;
    }

    private String name;

    private Integer Id;

    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
