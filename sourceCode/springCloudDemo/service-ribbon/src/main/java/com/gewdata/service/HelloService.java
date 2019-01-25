package com.gewdata.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: JunYaoWang
 * @create: 2018-12-05 11:21
 **/
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @HystrixCommand 断路器，出现错误时调用hiError方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        // 直接用的程序名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
        return restTemplate.getForObject("http://eureka-client1/hi?name="+name,String.class);
    }

    /**
     * eureka-client1服务调用失败时调用此方法
     * @param name
     * @return
     */
    public String hiError(String name){
        return "hi," + name + ",sorry,error!";
    }
}
