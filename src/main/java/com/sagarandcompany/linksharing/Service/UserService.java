package com.sagarandcompany.linksharing.Service;

import com.sagarandcompany.linksharing.Domain.User;
import com.sagarandcompany.linksharing.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> getByUsername(String text) {
        return userRepository.findAllByUsernameLike(text);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User search(Long id) {
        return userRepository.findById(id).get();
    }

    public User isValid(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);

    }


    /*public void update(User user) {

        userRepository.save(user);
    }*/
}

