package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Student {
    //necessary field in every class
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private Group group;
}
