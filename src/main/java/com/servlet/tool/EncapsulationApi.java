package com.servlet.tool;

import com.alibaba.fastjson.JSONObject;

public class EncapsulationApi {
    public JSONObject ResponseAPI(String msg, Integer code, Object object){
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("msgCode", code);
        json.put("data", object);
        return json;
    }
}
