package com.sagarandcompany.linksharing.Controller;

import com.sagarandcompany.linksharing.Service.TopicService;
import com.sagarandcompany.linksharing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("topics", topicService.gettentopic(httpSession));
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView contextPath(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("topics", topicService.gettentopic(httpSession));
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("status", true);
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginbutton() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(value = "/crud", method = RequestMethod.GET)
    public ModelAndView crud() {
        ModelAndView modelAndView = new ModelAndView("manageaccounts");
        modelAndView.addObject("users", userService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/crud", method = RequestMethod.POST)
    public ModelAndView crudbutton() {
        ModelAndView modelAndView = new ModelAndView("manageaccounts");
        return modelAndView;
    }


}
