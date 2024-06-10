package com.lu.template.service.impl;

import com.lu.template.service.AbstractMerchantService;
import org.springframework.stereotype.Component;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/10 15:48
 **/
@Component
public class CompanyAServiceImpl extends AbstractMerchantService {

    @Override
    public boolean isRequestByProxy() {
        return false;
    }
}
