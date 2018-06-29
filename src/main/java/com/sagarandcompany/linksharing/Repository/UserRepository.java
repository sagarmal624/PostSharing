package com.sagarandcompany.linksharing.Repository;


import com.sagarandcompany.linksharing.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByUsernameLike(String username);

    public User findByUsernameAndPassword(String username, String password);
}
