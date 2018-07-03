package com.sagarandcompany.linksharing.Service;

import com.sagarandcompany.linksharing.Domain.Topic;
import com.sagarandcompany.linksharing.Domain.User;
import com.sagarandcompany.linksharing.Repository.ResourceRepository;
import com.sagarandcompany.linksharing.Repository.TopicRepository;
import com.sagarandcompany.linksharing.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ResourceService {
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TopicRepository topicRepository;

    public List<Topic> topics(HttpSession httpSession) {
        User sessionuser = (User) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionuser.getId()).get();
        return user.getTopics();

    }
}
