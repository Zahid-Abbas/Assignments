package com.example.doctor_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Specialization is required")
    @Column(nullable = false)
    private String specialization;

    @Email(message = "Invalid email")
    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    /**
     * availability can be a free-form string like:
     * "Mon-Fri 09:00-17:00" or a JSON string if you prefer structured schedules.
     */
    @Size(max = 500)
    private String availability;

    // Constructors
    public Doctor() {}

    public Doctor(String name, String specialization, String email, String phone, String availability) {
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
        this.availability = availability;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
}
