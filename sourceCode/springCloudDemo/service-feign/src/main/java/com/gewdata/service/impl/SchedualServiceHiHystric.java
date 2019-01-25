package com.gewdata.service.impl;

import com.gewdata.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * SchedualServiceHiHystric需要实现SchedualServiceHi 接口注入到OC容器中
 * @author: JunYaoWang
 * @create: 2018-12-11 09:19
 **/
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,error!" + name;
    }
}
