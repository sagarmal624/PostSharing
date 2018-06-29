package com.sagarandcompany.linksharing.Repository;


import com.sagarandcompany.linksharing.Domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
