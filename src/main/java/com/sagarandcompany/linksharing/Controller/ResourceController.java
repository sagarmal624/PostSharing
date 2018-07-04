package com.sagarandcompany.linksharing.Controller;

import com.sagarandcompany.linksharing.Domain.DocumentResource;
import com.sagarandcompany.linksharing.Domain.LinkResource;
import com.sagarandcompany.linksharing.Service.DocumentResourceService;
import com.sagarandcompany.linksharing.Service.LinkResourceService;
import com.sagarandcompany.linksharing.Service.ResourceService;
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
public class ResourceController {
    @Autowired
    LinkResourceService linkResourceService;

    @Autowired
    ResourceService resourceService;
    @Autowired
    DocumentResourceService documentResourceService;

    @RequestMapping(value = "/linkResource", method = RequestMethod.GET)
    public ModelAndView getLinkResource(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("linkresource");
        modelAndView.addObject("linkResource", new LinkResource());
        modelAndView.addObject("topics", resourceService.topics(httpSession));

        return modelAndView;
    }

    @RequestMapping(value = "/savelink", method = RequestMethod.POST)
    public ModelAndView saveLinkResource(@Valid @ModelAttribute LinkResource linkResource, BindingResult bindingResult) {
        ModelAndView modelAndView = null;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("linkresource");
            modelAndView.addObject("linkResource", linkResource);
        } else {
            linkResourceService.saveLink(linkResource);
            modelAndView = new ModelAndView("linkresource");
            modelAndView.addObject("linkResource", new LinkResource());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/linkresource/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editLinkResource(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("linkresource");
        modelAndView.addObject("linkResource", linkResourceService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/linkresource/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteLinkResource(@PathVariable Long id, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        linkResourceService.delete(id, httpSession);
        return modelAndView;
    }


    @RequestMapping(value = "/documentResource", method = RequestMethod.GET)
    public ModelAndView getDocumentResoucre(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("documentresource");
        modelAndView.addObject("documentResource", new DocumentResource());
        modelAndView.addObject("topics", resourceService.topics(httpSession));
        return modelAndView;
    }

    @RequestMapping(value = "/savedocument", method = RequestMethod.POST)
    public ModelAndView saveDocumentResource(@Valid @ModelAttribute DocumentResource documentResource, BindingResult bindingResult) {
        ModelAndView modelAndView = null;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("documentresource");
            modelAndView.addObject("documentResource", documentResource);
        } else {
            documentResourceService.savedocument(documentResource);
            modelAndView = new ModelAndView("documentresource");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/documentresource/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDocumentResource(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("documentresource");
        modelAndView.addObject("documentResource", documentResourceService.getById(id));
        return modelAndView;

    }

    @RequestMapping(value = "/documentresource/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDocumentResource(@PathVariable long id, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        documentResourceService.delete(id, httpSession);
        return modelAndView;
    }
}
