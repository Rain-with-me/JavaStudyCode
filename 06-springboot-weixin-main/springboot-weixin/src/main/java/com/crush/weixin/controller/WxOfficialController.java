package com.crush.weixin.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/10/15 12:17
 **/

@Slf4j
@RestController
public class WxOfficialController {
    @Autowired
    private WxMaService wxService;
    @GetMapping("/official")
    public String getOfficialId(@RequestParam String code){
        WxMaJscode2SessionResult info = null;
        String openid=null;
        String sessionKey=null;
        try {
            info =this.wxService.getUserService().getSessionInfo(code);
            openid = info.getOpenid();
            sessionKey = info.getSessionKey();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return openid;
    }
}
