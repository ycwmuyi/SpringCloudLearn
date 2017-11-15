package com.ycw.spring_cloud_learn.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import java.util.List;

/**
 * Author: yangchengwei
 * Date: 2017/11/14 14:23
 * Description:
 * History:
 */
@Service
public class ErurekaClientService {

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    public String  serviceUrl(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("service-hi", false);
        return instance.getHomePageUrl();
    }


    @Autowired
    private DiscoveryClient discoveryClient;

    public String serviceUrlB() {
        List<ServiceInstance> list = discoveryClient.getInstances("service-hi");
        if (list != null && list.size() > 0 ) {
            String aa = list.get(0).getUri().getAuthority();
        }
        List<String> servicesNames = discoveryClient.getServices();
        StringBuilder sb = new StringBuilder();
        for (String s:servicesNames) {
            sb.append(s+"\t");
        }
        return sb.toString();
    }


    public String getInstances(){

    }





}
