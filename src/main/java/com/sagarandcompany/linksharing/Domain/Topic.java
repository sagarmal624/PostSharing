package com.sagarandcompany.linksharing.Domain;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //    private User createdby;
    private Date datecreated;
    private Visibility visibility;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Resource> resources=new ArrayList<>();

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
