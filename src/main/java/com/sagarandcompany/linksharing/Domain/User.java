package com.sagarandcompany.linksharing.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Email Can't be null")
    @NotEmpty(message = "Email Can't be Empty")
    @Size(min = 5, max = 30)
    private String email;
    @Column(unique = true)
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String firstname;
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Topic> topics = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private  List<Subscription> subscriptions=new ArrayList<>();

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
