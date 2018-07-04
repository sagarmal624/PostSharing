package com.sagarandcompany.linksharing.Repository;


import com.sagarandcompany.linksharing.Domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
