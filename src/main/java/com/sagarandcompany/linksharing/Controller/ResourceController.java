package com.sagarandcompany.linksharing.Controller;

import com.sagarandcompany.linksharing.Domain.LinkResource;
import com.sagarandcompany.linksharing.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @RequestMapping(value="/linkResource", method = RequestMethod.GET)
    public ModelAndView getLinkResource(){
        ModelAndView modelAndView=new ModelAndView("linkresource");
        return modelAndView;
    }
    @RequestMapping(value="/savebtn",method = RequestMethod.POST)
    public ModelAndView saveLinkResource(@ModelAttribute LinkResource linkResource){
        resourceService.save(linkResource);
        ModelAndView modelAndView=new ModelAndView("linkresource");
        return modelAndView;
    }
    @RequestMapping(value="/documentResource", method = RequestMethod.GET)
    public ModelAndView getDocumentResoucre(){
        ModelAndView modelAndView=new ModelAndView("documentresource");
        return modelAndView;
    }
}
