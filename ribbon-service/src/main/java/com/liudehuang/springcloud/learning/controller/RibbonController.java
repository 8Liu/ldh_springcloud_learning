package com.liudehuang.springcloud.learning.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

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
public class RibbonController {

    private static final Logger LOG = Logger.getLogger(RibbonController.class.getName());

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiFallbackMethod")
    public String hi(@RequestParam String name){
        return restTemplate.getForObject("http://eureka-service/hi?name="+name,String.class);
    }

    public String hiFallbackMethod(String name){
        return "hi,"+name+",sorry,error!";
    }


    @GetMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "calling trace ribbon-service ");
        return "i'm ribbon-service";

    }
}
