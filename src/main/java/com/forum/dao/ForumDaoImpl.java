package com.forum.dao;


import com.forum.model.ModelPost;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ForumDaoImpl implements ForumDao{
//    private static final Logger LOGGER = LoggerFactory.c
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addMessage(ModelPost modelPost) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(modelPost);
    }

    public void updateMessage(ModelPost modelPost) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(modelPost);
    }

    public void removeMessage(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ModelPost modelPost = (ModelPost) session.load(ModelPost.class, new Integer(id));

        if (modelPost!=null){
            session.delete(modelPost);
        }
    }
    @SuppressWarnings("unchecked")
    public List<ModelPost> listMessages() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ModelPost> posts = session.createQuery("from ModelPost").list();
        return posts;
    }
}
