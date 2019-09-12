package com.liudehuang.springcloud.learning.controller;

import com.liudehuang.springcloud.learning.feign.EurekaServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2019-09-12
 * @UpdateUser: liudehuang
 * @UpdateDate: 2019-09-12
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
public class FeignController {
    @Autowired
    private EurekaServiceFeign eurekaServiceFeign;
    @GetMapping("/sayHi")
    public String sayHi(@RequestParam String name){
        return eurekaServiceFeign.hi(name);
    }
}
