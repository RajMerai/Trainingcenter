package com.trainingcenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

@Entity
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name is mandatory and cannot be blank")
    @Column(length = 40)
    private String centerName;

    @NotBlank(message = "Center code is mandatory and cannot be blank")
    @Column(length = 12)
    private String centerCode;

    @NotBlank(message = "Address details are mandatory")
    @Embedded
    private Address address;

    @NotBlank(message = "Student capacity is mandatory")
    private int studentCapacity;

    @NotEmpty(message = "Courses offered list cannot be empty")
    @ElementCollection
    private List<String> coursesOffered;

    private Instant createdOn; // Use Instant for timestamps

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact phone number is mandatory")
    private String contactPhone;

    // Getters and setters

    @JsonProperty("createdOn")
    public Long getCreatedOnAsEpoch() {
        return createdOn.toEpochMilli();
    }
}
