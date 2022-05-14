package com.example.customerui.controller;

import com.example.businesscommons.pojo.Customer;
import com.example.customerui.feign.CustomerUIFeign;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ResultVo;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerUIController {

    @Resource
    private CustomerUIFeign customerUIFeign;

    /*查询所有顾客信息*/
    @RequestMapping("/list")
    public List<Customer> list(){
        List<Customer> customers = customerUIFeign.getCustomerList();
        return customers;
    }

    /*根据id查询顾客*/
    @RequestMapping("/detail/{id}")
    public ResultVo detail(@PathVariable("id")Integer id){
        return customerUIFeign.getCustomerDetail(id);
    }
}
