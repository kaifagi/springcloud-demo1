package com.example.customerprovider.dao;

import com.example.businesscommons.pojo.Customer;
import vo.ResultVo;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomerList();

    Customer getCustomerById(Integer id);
}
