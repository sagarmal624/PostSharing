package com.sagarandcompany.linksharing.Controller;

import com.sagarandcompany.linksharing.Domain.User;
import com.sagarandcompany.linksharing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView usersignup(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView modelAndView = null;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("signup");
            modelAndView.addObject("user", user);
        } else {
            userService.save(user);
            System.out.println(user.toString());
            modelAndView = new ModelAndView("manageaccounts");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView userdelete(@PathVariable Long id) {
        userService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("user", userService.getById(id));

        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView getsearchPage(String username) {
        ModelAndView modelAndView = new ModelAndView("manageaccounts");
        modelAndView.addObject("users", userService.getByUsername(username));
        return modelAndView;

    }
}
