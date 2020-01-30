package com.example.sortBubble.dao;

import com.example.sortBubble.daoIml.StoredArraysDaoImpl;
import com.example.sortBubble.models.StoredArrays;
import com.example.sortBubble.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StoredArraysDao implements StoredArraysDaoImpl {

    public StoredArrays findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(StoredArrays.class, id);
    }

    public void save(StoredArrays storedArray) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(storedArray);
        tx1.commit();
        session.close();
    }

    public void update(StoredArrays storedArray) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(storedArray);
        tx1.commit();
        session.close();
    }

    public void delete(StoredArrays storedArray) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(storedArray);
        tx1.commit();
        session.close();
    }

    public  List<StoredArrays> findAll() {
        return  (List<StoredArrays>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From StoredArrays").list();
    }
}
