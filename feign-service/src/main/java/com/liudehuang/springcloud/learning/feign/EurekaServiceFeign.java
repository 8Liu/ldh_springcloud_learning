package com.liudehuang.springcloud.learning.feign;

import com.liudehuang.springcloud.learning.hystric.EurekaServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2019-09-12
 * @UpdateUser: liudehuang
 * @UpdateDate: 2019-09-12
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
@FeignClient(value = "eureka-service",fallback = EurekaServiceHystric.class)
public interface EurekaServiceFeign {
    @GetMapping("/hi")
    String hi(@RequestParam("name")String name);
}
