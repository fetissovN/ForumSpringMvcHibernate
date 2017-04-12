package com.forum.service;

import com.forum.dao.ForumDao;
import com.forum.model.ModelPost;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModelPostServiceImpl implements ModelPostService{
    private ForumDao forumDao;

    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Transactional
    public void addMessage(ModelPost modelPost) {
        this.forumDao.addMessage(modelPost);
    }

    @Transactional
    public void updateMessage(ModelPost modelPost) {
        this.forumDao.updateMessage(modelPost);
    }

    @Transactional
    public void removeMessage(int id) {
        this.forumDao.removeMessage(id);
    }

    @Transactional
    public List<ModelPost> listMessages() {
        return this.forumDao.listMessages();
    }
}
