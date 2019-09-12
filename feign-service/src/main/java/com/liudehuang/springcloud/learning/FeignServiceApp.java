package com.liudehuang.springcloud.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2019-09-12
 * @UpdateUser: liudehuang
 * @UpdateDate: 2019-09-12
 * @UpdateRemark:
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class FeignServiceApp {
    public static void main(String[] args) {
        SpringApplication.run( FeignServiceApp.class, args );
    }
}
