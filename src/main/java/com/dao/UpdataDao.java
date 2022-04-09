package com.dao;

import com.model.entity.ProductEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UpdataDao extends BaseHibernateDAO{
    public void updataproduct(ProductEntity product){
        try{
            getSession().saveOrUpdate(product);
            System.out.println("ProductDAO:Update product successful");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
