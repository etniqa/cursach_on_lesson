package edu.stev.cursach.model.cmnInterfaces;

import java.time.LocalDateTime;

public interface ICommonFields { //for making prototyping in IDataSet
    void setId(String id);
    String getId();
    void setName(String name);
    String getName();
    void setDescription(String description);
    String getDescription();
    LocalDateTime getCreationDate();
    void setCreationDate(LocalDateTime creationDate);
    LocalDateTime getDateModified();
    void setDateModified(LocalDateTime dateModified);

}
