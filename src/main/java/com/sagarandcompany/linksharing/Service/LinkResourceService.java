package com.sagarandcompany.linksharing.Service;

import com.sagarandcompany.linksharing.Controller.RecordNotFoundException;
import com.sagarandcompany.linksharing.Domain.LinkResource;
import com.sagarandcompany.linksharing.Domain.Resource;
import com.sagarandcompany.linksharing.Domain.Topic;
import com.sagarandcompany.linksharing.Domain.User;
import com.sagarandcompany.linksharing.Repository.ResourceRepository;
import com.sagarandcompany.linksharing.Repository.TopicRepository;
import com.sagarandcompany.linksharing.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LinkResourceService {
    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    UserRepository userRepository;

    public LinkResource saveLink(LinkResource linkResource) {
        Date date = new Date();
        Topic topic = topicRepository.getOne(linkResource.getTopic().getId());
        List<Resource> resourceList = topic.getResources();
        if (linkResource.getId() == null) {
            linkResource.setDatecreated(date);
            linkResource.setLastupdated(date);
        } else {
            LinkResource resource = (LinkResource) resourceRepository.findById(linkResource.getId()).get();
            linkResource.setDatecreated(resource.getDatecreated());
            linkResource.setLastupdated(date);
        }
        resourceList.add(linkResource);
        topic.setResources(resourceList);
        topicRepository.save(topic);
        return linkResource;
    }

    public LinkResource getById(Long id) {
        LinkResource linkResource = (LinkResource) resourceRepository.findById(id).get();
        return linkResource;
    }

    public void delete(Long id, HttpSession httpSession) {
        User sessionuser = (User) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionuser.getId()).get();
        Optional<Resource> optional = resourceRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RecordNotFoundException("linkResource Not Found");
        }
        LinkResource linkResource = (LinkResource) optional.get();
        Topic topic = linkResource.getTopic();
        List<Resource> resources = topic.getResources();
        resources.remove(linkResource);
        topicRepository.save(topic);
        resourceRepository.delete(linkResource);
    }


}
