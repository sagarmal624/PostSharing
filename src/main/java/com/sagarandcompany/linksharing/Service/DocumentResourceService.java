package com.sagarandcompany.linksharing.Service;

import com.sagarandcompany.linksharing.Domain.DocumentResource;
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

@Service
public class DocumentResourceService {
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    UserRepository userRepository;

    public DocumentResource savedocument(DocumentResource documentResource) {
        Date date = new Date();
        Topic topic = topicRepository.getOne(documentResource.getTopic().getId());
        List<Resource> resourceList = topic.getResources();
        documentResource.setDatecreated(date);
        if (documentResource.getId() == null) {
            documentResource.setDatecreated(date);
            documentResource.setLastupdated(date);
        } else {
            DocumentResource resource = (DocumentResource) resourceRepository.findById(documentResource.getId()).get();
            resource.setDatecreated(documentResource.getDatecreated());
            resource.setLastupdated(date);
        }
        resourceList.add(documentResource);
        topic.setResources(resourceList);
        topicRepository.save(topic);
        return documentResource;
    }

    public DocumentResource getById(Long id) {
        DocumentResource documentResource = (DocumentResource) resourceRepository.findById(id).get();
        return documentResource;
    }

    public void delete(Long id, HttpSession httpSession) {
        User sessionuser = (User) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionuser.getId()).get();
        DocumentResource documentResource = (DocumentResource) resourceRepository.findById(id).get();
        Topic topic = documentResource.getTopic();
        List<Resource> resources = topic.getResources();
        resources.remove(documentResource);
        topicRepository.save(topic);
        resourceRepository.delete(documentResource);
    }
}
