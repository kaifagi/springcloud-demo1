package com.example.businessprovider.controller;

import com.example.businesscommons.pojo.Business;
import com.example.businessprovider.service.BusinessProviderService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;
import vo.ResultVo;

import javax.annotation.Resource;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class BusinessProviderController {

    @Resource
    private BusinessProviderService businessProviderService;

    /*返回所有商家信息*/
    @RequestMapping("/list")
    public List<Business> list(){
        List<Business> businessList = businessProviderService.getBusinessList();
        return businessList;
    }
    /*根据id查询商家信息*/
    @GetMapping("/{id}")
    public Business getBusiness(@PathVariable("id")Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Business business = businessProviderService.getBusinessById(id);
        return business;
    }
    /*添加商家信息*/
    @PostMapping()
    public ResultVo addBusiness(@RequestBody Business business){
        businessProviderService.add(business);
        return ResultVo.ok();
    }
    /*删除商家信息*/
    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable("id")Integer id){
        businessProviderService.deleteBusinessById(id);
    }
    /*修改商家信息*/
    @PutMapping()
    public void updataBusiness(@RequestBody Business business){
        businessProviderService.updata(business);
    }

    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//开启熔断器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")//服务错误率
    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num")Integer num){
        int n = (int)Math.floor(Math.random()*100);
        int result = n/num;
        return "服务正常返回结果："+n+"/"+num+"="+result;
    }
    public String fallBack(@RequestParam("num")Integer num){
        return "服务降级响应：num为0";
    }
}
