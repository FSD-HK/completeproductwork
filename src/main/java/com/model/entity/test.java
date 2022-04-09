package com.model.entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import java.util.List;

public class test {
    public static void test7(){
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria crt=session.createCriteria(ProductEntity.class);
        List<ProductEntity> channel=crt.list();
        for(ProductEntity item:channel){
            System.out.println("11111="+item.getProductname());
        }
        session.close();
    }
    public static void test8(){
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria crt=session.createCriteria(TypeEntity.class);
        List<TypeEntity> channel=crt.list();
        for(TypeEntity item:channel){
            System.out.println("type="+item.getTypename());
        }
        session.close();
    }
    public static void test9(){
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria crt=session.createCriteria(StatusEntity.class);
        List<StatusEntity> channel=crt.list();
        for(StatusEntity item:channel){
            System.out.println("type="+item.getStatusname());
        }
        session.close();
    }
    public static void main(String[] args) {
        test7();
    }
}
