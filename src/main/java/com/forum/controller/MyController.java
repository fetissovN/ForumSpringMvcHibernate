package com.forum.controller;

import com.forum.model.ModelPost;
import com.forum.service.ModelPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class MyController {

    private ModelPostService modelPostService;

    @Autowired(required = true)
    @Qualifier(value = "modelPostService")
    public void setModelPostService(ModelPostService modelPostService) {
        this.modelPostService = modelPostService;
    }

    @RequestMapping(value = "/forum", method = RequestMethod.GET)
    public String posts(Model model){
        model.addAttribute("message", new ModelPost());
        model.addAttribute("posts", this.modelPostService.listMessages());
        return "forum";
    }

    @RequestMapping(value = "/forum/add", method = RequestMethod.POST)
    public String addMessage(@ModelAttribute("message") ModelPost modelPost){
        this.modelPostService.addMessage(modelPost);
        return "redirect:/forum";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeMessage (@PathVariable("id") int id){
        this.modelPostService.removeMessage(id);
        return "redirect:/forum";
    }

//    @RequestMapping(value = "edit/{id}")
//    public String edit(@PathVariable("id") int id, Model model){
//        this.modelPostService.updateMessage(model);
//    }




}
