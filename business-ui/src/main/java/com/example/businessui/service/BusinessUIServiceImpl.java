package com.example.businessui.service;

import com.example.businesscommons.pojo.Business;
import vo.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class BusinessUIServiceImpl  implements BusinessUIService{

    @Resource
    private RestTemplate restTemplate;

    @Override
    public List<Business> getBusinessList() {
        Business[] businessList = restTemplate.getForObject("http://business-provider/provider/list", Business[].class);
        return Arrays.asList(businessList);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackBusinessById",commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    }//降级响应设置的时间
    )
    public ResultVo getBusinessById(Integer id) {
        Business business = restTemplate.getForObject("http://business-provider/provider/" + id, Business.class);
        return ResultVo.ok(business);
    }
    public ResultVo fallBackBusinessById(Integer id) {
        return ResultVo.error("服务降级返回的响应内容");
    }

    @Override
    public ResultVo add(Business business) {
        ResultVo resultVo = restTemplate.postForObject("http://business-provider/provider", business, ResultVo.class);
        return resultVo;
    }

    @Override
    public ResultVo deleteBusinessById(Integer id) {
        restTemplate.delete("http://business-provider/provider/"+id);
        return ResultVo.ok();
    }

    @Override
    public ResultVo update(Business business) {
        restTemplate.put("http://business-provider/provider",business);
        return ResultVo.ok();
    }
}
