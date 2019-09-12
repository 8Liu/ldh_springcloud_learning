package com.liudehuang.springcloud.learning.hystric;

import com.liudehuang.springcloud.learning.feign.EurekaServiceFeign;
import org.springframework.stereotype.Component;

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
public class EurekaServiceHystric implements EurekaServiceFeign {
    @Override
    public String hi(String name) {
        return "sorry "+name;
    }
}
