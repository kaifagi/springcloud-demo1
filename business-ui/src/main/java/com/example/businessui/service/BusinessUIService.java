package com.example.businessui.service;

import com.example.businesscommons.pojo.Business;
import vo.ResultVo;

import java.util.List;

public interface BusinessUIService {
    List<Business> getBusinessList();

    ResultVo getBusinessById(Integer id);

    ResultVo add(Business business);

    ResultVo deleteBusinessById(Integer id);

    ResultVo update(Business business);
}
