package com.sso.controller;

import com.sso.model.AjaxMsg;
import com.sso.model.UserModel;
import com.sso.service.UserService;
import com.sso.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public AjaxMsg list(UserModel UserModel, HttpServletRequest request){
        List list = userService.getList(UserModel);
        return AjaxMsg.returnAjaxMsg(JsonUtil.changeList(list));

    }

    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxMsg save(UserModel UserModel){
        userService.save(UserModel);
        return AjaxMsg.returnAjaxMsg();
    }

    @RequestMapping(value="/update",method= RequestMethod.PUT)
    public AjaxMsg update(UserModel UserModel, HttpServletRequest request){
        return AjaxMsg.returnAjaxMsg();
    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public AjaxMsg delete(String id){
        return AjaxMsg.returnAjaxMsg();
    }

    @RequestMapping(value="/login")
    public AjaxMsg login(UserModel UserModel, HttpServletRequest request){
        return AjaxMsg.returnAjaxMsg(userService.login(UserModel,request));
    }
}
