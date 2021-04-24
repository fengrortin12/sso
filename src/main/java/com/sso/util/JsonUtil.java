package com.sso.util;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtil {
    /**当hibernate注解使用one to many 时候 json 特殊处理 为jsonArray*/
    public static JSONArray changeList(List list){
        JSONArray jsonArray = new JSONArray();
        try{
            String s = new ObjectMapper().writeValueAsString(list);
            jsonArray = JSONArray.parseArray(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }
}
