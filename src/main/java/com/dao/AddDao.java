package com.dao;

import com.model.entity.ProductEntity;

public class AddDao extends BaseHibernateDAO{
    public AddDao() {
    }
    public void addproduct(ProductEntity product){
        try {
            getSession().saveOrUpdate(product);
            System.out.println("ProductDAO:Save Successful");
        } catch (RuntimeException e){
            System.out.println("ProductDAO:Save product error:"+e);
            throw e;
        }
    }
}
