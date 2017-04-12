package com.forum.service;

import com.forum.model.ModelPost;

import java.util.List;

public interface ModelPostService {
    public void addMessage(ModelPost modelPost);
    public void updateMessage(ModelPost modelPost);
    public void removeMessage(int id);
    public List<ModelPost> listMessages();
}
