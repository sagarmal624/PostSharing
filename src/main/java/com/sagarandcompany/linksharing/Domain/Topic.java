package com.sagarandcompany.linksharing.Domain;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name Can't be null")
    @NotEmpty(message = "Name Can't be Empty")
    @Size(min = 5, max = 30)
    private String name;
    @OneToOne
    private User createdby;
    private Date datecreated;
    private Date lastupdated;
    private Visibility visibility;
    private Boolean isSubscribed;

    public Boolean getSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Resource> resources = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Subscription> subscriptions = new ArrayList<>();

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public User getCreatedby() {
//        return createdby;
//    }
//
//    public void setCreatedby(User createdby) {
//        this.createdby = createdby;
//    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", datecreated='" + datecreated + '\'' +
                ", visibility='" + visibility + '\'' +
                '}';
    }
}
