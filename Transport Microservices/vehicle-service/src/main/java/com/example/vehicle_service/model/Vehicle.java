package com.example.vehicle_service.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.vehicle_service.util.VehicleStatus;
import com.example.vehicle_service.util.VehicleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicleId;
	
	@Column(unique=true, nullable=false)
	private String vehicleNumber;
	
	@Enumerated(EnumType.STRING)
	private VehicleType type;
	
	private int capacity;
	

	@Enumerated(EnumType.STRING)
	private VehicleStatus status; // AVAILABLE, ON_TRIP, MAINTENANCE

	 
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
	
	 
	
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public VehicleStatus getStatus() {
		return status;
	}
	public void setStatus(VehicleStatus status) {
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

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", type=" + type + ", capacity="
				+ capacity + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	

}
