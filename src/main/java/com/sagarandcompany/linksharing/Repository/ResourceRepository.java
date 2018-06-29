package com.sagarandcompany.linksharing.Repository;


import com.sagarandcompany.linksharing.Domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
