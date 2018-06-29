package com.sagarandcompany.linksharing.Service;

import com.sagarandcompany.linksharing.Domain.LinkResource;
import com.sagarandcompany.linksharing.Repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
@Autowired
ResourceRepository resourceRepository;

public LinkResource save(LinkResource linkResource){
    return resourceRepository.save(linkResource);
}
}
