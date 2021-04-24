package com.sso.controller;

import com.sso.model.AjaxMsg;
import com.sso.model.SsoModel;
import com.sso.service.SsoModelService;
import com.sso.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/sso")
public class SsoController {
    @Autowired
    private SsoModelService ssoModelService;

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public AjaxMsg list(SsoModel ssoModel, HttpServletRequest request){
        List list = ssoModelService.getList(ssoModel);
        return AjaxMsg.returnAjaxMsg(JsonUtil.changeList(list));

    }

    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxMsg save(SsoModel ssoModel){
        ssoModelService.save(ssoModel);
        return AjaxMsg.returnAjaxMsg();
    }

    @RequestMapping(value="/update",method= RequestMethod.PUT)
    public AjaxMsg update(SsoModel ssoModel, HttpServletRequest request){
        return AjaxMsg.returnAjaxMsg();
    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public AjaxMsg delete(String id){
        return AjaxMsg.returnAjaxMsg();
    }

    @RequestMapping(value="/other")
    public AjaxMsg other(HttpServletResponse response, HttpServletRequest request){
        return AjaxMsg.returnAjaxMsg();
    }
}
