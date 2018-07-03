package com.sagarandcompany.linksharing.Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("documentResource")
public class DocumentResource extends Resource {
    @NotNull(message = "filePath cannot be null")
    @NotEmpty(message = "filePath cannot be empty")
    @Size(min = 5,max = 50)
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
