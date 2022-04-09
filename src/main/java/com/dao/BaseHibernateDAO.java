package com.dao;

import com.db.HibernateSessionFactory;
import org.hibernate.Session;

public class BaseHibernateDAO implements IBaseHibernateDAO {
    public Session getSession() {
        return HibernateSessionFactory.getSession();
    }
}
