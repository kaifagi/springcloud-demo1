package com.example.businessprovider.dao;

import com.example.businesscommons.pojo.Business;

import java.util.List;

public interface BusinessDao {
    List<Business> getBusinessList();

    Business getBusinessById(Integer id);

    void add(Business business);

    void deleteBusinessById(Integer id);

    void updata(Business business);
}
