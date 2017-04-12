package com.forum.dao;


import com.forum.model.ModelPost;

import java.util.List;

public interface ForumDao {
    public void addMessage(ModelPost modelPost);
    public void updateMessage(ModelPost modelPost);
    public void removeMessage(int id);
    public List<ModelPost> listMessages();

}
