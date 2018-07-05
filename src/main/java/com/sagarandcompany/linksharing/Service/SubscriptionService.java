package com.sagarandcompany.linksharing.Service;

import com.sagarandcompany.linksharing.Domain.Seriousness;
import com.sagarandcompany.linksharing.Domain.Subscription;
import com.sagarandcompany.linksharing.Domain.Topic;
import com.sagarandcompany.linksharing.Domain.User;
import com.sagarandcompany.linksharing.Repository.SubscriptionRepository;
import com.sagarandcompany.linksharing.Repository.TopicRepository;
import com.sagarandcompany.linksharing.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TopicRepository topicRepository;

    public List<User> subscriptionuser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public List<Topic> subscriptionTopics(HttpSession httpSession) {
        User sessionuser = (User) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionuser.getId()).get();
        return user.getTopics();

    }

    public Subscription saveSubscription(Long topicId, HttpSession httpSession) {
        Date date = new Date();
        Topic topic = topicRepository.getOne(topicId);
        User sessionuser = (User) httpSession.getAttribute("user");
        User dbuser = userRepository.getOne(sessionuser.getId());
        Subscription subscription = new Subscription();
        subscription.setSeriousness(Seriousness.VerySerious);
        subscription.setTopic(topic);
        subscription.setUser(dbuser);
        subscription.setDateCreated(date);
        List<Subscription> subscriptions = topic.getSubscriptions();
        subscriptions.add(subscription);
        topic.setSubscriptions(subscriptions);
        topicRepository.save(topic);
        return subscription;
    }

    public void deleteSubscription(Long id, HttpSession httpSession) {
        User sessionuser = (User) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionuser.getId()).get();
        Subscription subscription = subscriptionRepository.findById(id).get();
        Topic topic = subscription.getTopic();
        List<Subscription> subscriptions = topic.getSubscriptions();
        subscriptions.remove(subscription);
        topicRepository.save(topic);
        subscriptionRepository.delete(subscription);
    }

    public Subscription searchById(Long id) {
        return subscriptionRepository.findById(id).get();
    }

}
