package com.example.businessui.controller;

import com.example.businesscommons.pojo.Business;
import com.example.businessui.service.BusinessUIService;
import vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

@RestController
@RequestMapping("/ui")
public class BusinessUIController {
    @Resource
    private BusinessUIService businessUIService;

/*//    查询所有商家信息*/
    @RequestMapping("/list")
    public List<Business> list(){
        List<Business> businessList = businessUIService.getBusinessList();
        return businessList;
    }
    /*根据id查询商家信息*/
    @GetMapping("/{id}")
    public ResultVo getBusiness(@PathVariable("id")Integer id){
        ResultVo business = businessUIService.getBusinessById(id);
        return business;
    }
    /*添加商家信息*/
    @PostMapping()
    public ResultVo addBusiness(@RequestBody Business business){
        return businessUIService.add(business);
    }
    /*删除商家*/
    @DeleteMapping("/{id}")
    public ResultVo deleteBusiness(@PathVariable("id")Integer id){
        ResultVo business = businessUIService.deleteBusinessById(id);
         return business;
    }
    /*修改商家信息*/
    @PutMapping()
    public ResultVo updataBusiness(@RequestBody Business business){
       return businessUIService.update(business);

    }

}
