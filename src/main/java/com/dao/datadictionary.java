package com.dao;

import com.db.HibernateSessionFactory;
import com.model.entity.StatusEntity;
import com.model.entity.TypeEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class datadictionary {
    public static HashMap<String, HashMap<String,String>> hashMap=new HashMap<String,HashMap<String,String>>();
    public void loaddictionary(){
        HibernateSessionFactory.getSession();//可以不写
        try{
            QueryDao dao =new QueryDao();
            ArrayList<StatusEntity> list=dao.querystatus();
            HashMap<String,String> p=new HashMap<String,String>();
            for(StatusEntity item:list){
                p.put(item.getStatusid(), item.getStatusname());
            }
            hashMap.put("StatusEntity", p);
            ArrayList<TypeEntity> list2=dao.querytype();
            HashMap<String,String> p2=new HashMap<String,String>();
            for(TypeEntity item:list2){
                p2.put(item.getTypeid(), item.getTypename());
            }
            hashMap.put("TypeEntity", p2);
        }catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();//可以不写
    }
}
