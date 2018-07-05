package com.sagarandcompany.linksharing.Controller;

import com.sagarandcompany.linksharing.Domain.User;
import com.sagarandcompany.linksharing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginContoller {
    @Autowired
    UserService userService;

    @RequestMapping("/checklogin")
    public ModelAndView login(String username, String password, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        User user = userService.isValid(username, password);
        if (user != null) {
            httpSession.setAttribute("user", user);
            return modelAndView;
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("status", false);
            modelAndView.addObject("message", "Invalid Usernamme and password");
            return modelAndView;
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        httpSession.invalidate();
        return "redirecr:/home";
    }
}
