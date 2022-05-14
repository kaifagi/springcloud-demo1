package com.example.businessprovider.service;

import com.example.businesscommons.pojo.Business;
import com.example.businessprovider.dao.BusinessDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessProviderServiceImpl implements BusinessProviderService{

    @Resource
    private BusinessDao businessDao;

    @Override
    public List<Business> getBusinessList() {

        return businessDao.getBusinessList();
    }

    @Override
    public Business getBusinessById(Integer id) {
        return businessDao.getBusinessById(id);
    }

    @Override
    public void add(Business business) {
        businessDao.add(business);
    }

    @Override
    public void deleteBusinessById(Integer id) {
        businessDao.deleteBusinessById(id);
    }

    @Override
    public void updata(Business business) {
        businessDao.updata(business);
    }
}
