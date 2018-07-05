package com.sagarandcompany.linksharing.Repository;


import com.sagarandcompany.linksharing.Domain.Subscription;
import com.sagarandcompany.linksharing.Domain.Topic;
import com.sagarandcompany.linksharing.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    public Subscription findByUserAndTopic(User user, Topic topic);
}
