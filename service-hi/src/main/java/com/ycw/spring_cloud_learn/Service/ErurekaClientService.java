package com.ycw.spring_cloud_learn.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.xiaoleilu.hutool.http.HttpRequest;
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

        //获得对应服务名下所有的服务实力信息列表，服务如果有做集群，则返回的是该服务集群下的所有实力的列表
        List<ServiceInstance> list = discoveryClient.getInstances("service-hi");
        if (list != null && list.size() > 0 ) {
            String aa = list.get(0).getUri().getAuthority();
        }

        //获得微服下所有的服务名
        List<String> servicesNames = discoveryClient.getServices();
        StringBuilder sb = new StringBuilder();
        for (String s:servicesNames) {
            sb.append(s+"\t");
        }
        return sb.toString();
    }

}
