package com.example.customerui.feign;

import com.example.businesscommons.pojo.Customer;
import org.springframework.stereotype.Component;
import vo.ResultVo;

import java.util.List;

@Component
public class CustomerUIFeignImpl implements CustomerUIFeign{
    @Override
    public List<Customer> getCustomerList() {
        return null;
    }

    @Override
    public ResultVo getCustomerDetail(Integer id) {
        return ResultVo.error("fegin的服务降级响应");
    }
}
