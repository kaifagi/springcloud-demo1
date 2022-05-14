package com.example.customerprovider.controller;

import com.example.businesscommons.pojo.Customer;
import com.example.customerprovider.dao.CustomerDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vo.ResultVo;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerDao customerDao;

    @RequestMapping("/list")
    public List<Customer> list(){
        return customerDao.getCustomerList();
    }

    @RequestMapping("/detail")
    public ResultVo detail(@RequestParam("id") Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Customer customer = customerDao.getCustomerById(id);
        return ResultVo.ok(customer);
    }

}
