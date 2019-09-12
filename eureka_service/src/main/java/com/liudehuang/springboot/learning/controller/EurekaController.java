package com.liudehuang.springboot.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class EurekaController {

    private static final Logger LOG = Logger.getLogger(EurekaController.class.getName());

    @Value("${server.port}")
    private String port;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "liudehuang") String name) {
        LOG.log(Level.INFO, "calling trace eureka-service  ");
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "calling trace eureka-service ");
        return "i'm eureka-service";
    }

    @GetMapping("/call")
    public String call(){
        LOG.log(Level.INFO, "calling trace eureka-service ");
        return restTemplate.getForObject("http://ribbon-service/info",String.class);
    }
}
