package edu.stev.cursach.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Student {
    //necessary field in every class
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private Group group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Student() {
    }
}
