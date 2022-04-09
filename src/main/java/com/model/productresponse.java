package com.model;

import com.model.entity.ProductEntity;

import java.util.ArrayList;

public class productresponse {
    private String code;
    private String msg;
    private ArrayList<ProductEntity> data;
    public productresponse(String code, String msg, ArrayList<ProductEntity> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<ProductEntity> getData() {
        return data;
    }

    public void setData(ArrayList<ProductEntity> data) {
        this.data = data;
    }
}
