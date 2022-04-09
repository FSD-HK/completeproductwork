package com.dao;

import com.model.entity.ProductEntity;

public class DelectDao extends BaseHibernateDAO{
    public DelectDao() {
    }
    public void delectproduct(ProductEntity product){
        try{
            ProductEntity pro=getSession().get(ProductEntity.class,product.getProductkey());
            getSession().delete(pro);
            System.out.println("DelectDAO:Delete product successful");
        }catch (Exception e){
            System.out.println("DelectDAO:Delete product update error:" + e);
            e.printStackTrace();
        }
    }
}
