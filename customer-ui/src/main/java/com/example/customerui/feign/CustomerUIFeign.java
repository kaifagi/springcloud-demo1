package com.example.customerui.feign;

import com.example.businesscommons.pojo.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vo.ResultVo;

import java.util.List;

@FeignClient(value = "customer-provider",fallback = CustomerUIFeignImpl.class)
public interface CustomerUIFeign {

    @GetMapping("/customer/list")
    List<Customer> getCustomerList();

    @GetMapping("/customer/detail")
    ResultVo getCustomerDetail(@RequestParam("id") Integer id);
}
