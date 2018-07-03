package com.sagarandcompany.linksharing.Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("linkResource")
public class LinkResource extends Resource {
    @NotNull(message = "url cannot be null")
    @NotEmpty(message = "url cannot be empty")
    @Size(min = 5,max = 50)
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
