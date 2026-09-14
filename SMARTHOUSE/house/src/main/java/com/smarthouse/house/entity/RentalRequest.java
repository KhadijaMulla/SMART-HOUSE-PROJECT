package com.smarthouse.house.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RentalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String status;

    private LocalDateTime requestDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;


    public User getStudent() {
    return student;
}

public void setStudent(User student) {
    this.student = student;
}

public Property getProperty() {
    return property;
}

public void setProperty(Property property) {
    this.property = property;
}
    // Getters and Setters
}