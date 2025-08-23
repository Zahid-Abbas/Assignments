package com.example.driver_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Driver {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String name;

    private String licenseNumber;

    private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private DriverStatus status;

	private LocalDateTime createdAt;
	
	
	private LocalDateTime updatedAt;
	 
	 @PrePersist
	 protected void onCreate() {
	     this.createdAt = LocalDateTime.now();
	     this.updatedAt = LocalDateTime.now();
	 }

	 @PreUpdate
	 protected void onUpdate() {
	     this.updatedAt = LocalDateTime.now();
	 }

	 public Long getDriverId() {
		 return driverId;
	 }

	 public void setDriverId(Long driverId) {
		 this.driverId = driverId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getLicenseNumber() {
		 return licenseNumber;
	 }

	 public void setLicenseNumber(String licenseNumber) {
		 this.licenseNumber = licenseNumber;
	 }

	 public String getPhoneNumber() {
		 return phoneNumber;
	 }

	 public void setPhoneNumber(String phoneNumber) {
		 this.phoneNumber = phoneNumber;
	 }

	 public DriverStatus getStatus() {
		 return status;
	 }

	 public void setStatus(DriverStatus status) {
		 this.status = status;
	 }

	 public LocalDateTime getCreatedAt() {
		 return createdAt;
	 }

	 public void setCreatedAt(LocalDateTime createdAt) {
		 this.createdAt = createdAt;
	 }

	 public LocalDateTime getUpdatedAt() {
		 return updatedAt;
	 }

	 public void setUpdatedAt(LocalDateTime updatedAt) {
		 this.updatedAt = updatedAt;
	 }
    
}
