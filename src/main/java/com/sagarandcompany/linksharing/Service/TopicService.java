package com.sagarandcompany.linksharing.Service;

import com.sagarandcompany.linksharing.Controller.RecordNotFoundException;
import com.sagarandcompany.linksharing.Domain.Topic;
import com.sagarandcompany.linksharing.Domain.User;
import com.sagarandcompany.linksharing.Domain.Visibility;
import com.sagarandcompany.linksharing.Repository.TopicRepository;
import com.sagarandcompany.linksharing.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    @Autowired
    UserRepository userRepository;

    public Topic save(Topic topic, HttpSession httpSession) {
        Date date = new Date();
        User sessionUser = (User) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId()).get();
        topic.setDatecreated(date);
        List<Topic> topics = user.getTopics();
        topics.add(topic);
        userRepository.save(user);
        return topic;
    }

    public Topic getById(Long id) {
        return topicRepository.findById(id).get();
    }

    public List<Topic> getAll() {
        return topicRepository.findAll();
    }

    public void delete(Long id, HttpSession httpSession) {
        User sessionUser = (User) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId()).get();
        Topic topic = topicRepository.findById(id).get();
        if (topic == null) {
            throw new RecordNotFoundException("Topic Not Found");
        }
        List<Topic> topics = user.getTopics();
        topics.remove(topic);
        userRepository.save(user);
        topicRepository.delete(topic);
    }

    public Topic getId(Long id) {
        Topic topic = topicRepository.findById(id).get();
        return topic;
    }

    public List<Topic> gettentopic() {
        List<Topic> topics = topicRepository.findAll();
//        List<Topic> displayTopicList = topics.stream().filter(topic -> topic.getVisibility() == Visibility.PUBLIC).collect(Collectors.toList());
        List<Topic> copiedList = new ArrayList<>();
        for (Topic topic : topics) {
            if (topic.getVisibility() == Visibility.PUBLIC) {
                copiedList.add(topic);
            }
        }
        return copiedList;

    }
}

