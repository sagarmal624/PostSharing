package com.sagarandcompany.linksharing.Controller;

import com.sagarandcompany.linksharing.Domain.Topic;
import com.sagarandcompany.linksharing.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    public ModelAndView getTopicPage() {
        ModelAndView modelAndView = new ModelAndView("topic");
        modelAndView.addObject("topic", new Topic());
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveTopic(@Valid @ModelAttribute Topic topic, HttpSession httpSession, BindingResult bindingResult) {
        ModelAndView modelAndView = null;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("topic");
            modelAndView.addObject("topic", topic);
        } else {
            topicService.save(topic, httpSession);
            System.out.println(topic.toString());
            modelAndView = new ModelAndView("topictable");
            modelAndView.addObject("topics", topicService.getAll());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public ModelAndView ViewTopic(@ModelAttribute Topic topic) {
        System.out.println(topic.toString());
        ModelAndView modelAndView = new ModelAndView("topictable");
        modelAndView.addObject("topics", topicService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/topic/delete/{id}", method = RequestMethod.GET)
    public ModelAndView userdelete(@PathVariable Long id, HttpSession session) {
        topicService.delete(id, session);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/topic/edit/{id}", method = RequestMethod.GET)
    public ModelAndView userupdate(@PathVariable Long id, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("topic");
        modelAndView.addObject("topic", topicService.getId(id));
        return modelAndView;
    }




    /*@RequestMapping(value = "/topic", method = RequestMethod.GET)
    public ModelAndView crud() {
        ModelAndView modelAndView = new ModelAndView("manageaccounts");
        modelAndView.addObject("users", userService.getAll());

        return modelAndView;
    }*/
}

