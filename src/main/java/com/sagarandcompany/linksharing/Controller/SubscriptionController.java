package com.sagarandcompany.linksharing.Controller;

import com.sagarandcompany.linksharing.Domain.Subscription;
import com.sagarandcompany.linksharing.Domain.User;
import com.sagarandcompany.linksharing.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @RequestMapping(value = "/subscription", method = RequestMethod.GET)
    public ModelAndView getSubscription(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("subscription");
        modelAndView.addObject("subscription", new Subscription());
        modelAndView.addObject("users",subscriptionService.subscriptionuser());
        modelAndView.addObject("topics",subscriptionService.subscriptionTopics(httpSession));

        return modelAndView;
    }

    @RequestMapping(value = "/savesubscription",method = RequestMethod.POST)
    public ModelAndView saveSubscription(@ModelAttribute Subscription subscription){
        ModelAndView modelAndView=new ModelAndView("/subscription");
        subscriptionService.saveSubscription(subscription);
        return modelAndView;
    }

    @RequestMapping(value = "/subscription/delete/{id}",method = RequestMethod.GET)
    public ModelAndView deleteSubscription(@PathVariable Long id,HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView("/subscription");
        subscriptionService.deleteSubscription(id,httpSession);
        return modelAndView;
    }

    @RequestMapping(value ="/subscription/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editSubcription(@PathVariable Long id,HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView("/subscription");
        modelAndView.addObject("subscription",subscriptionService.searchById(id));
        return modelAndView;
    }
}
