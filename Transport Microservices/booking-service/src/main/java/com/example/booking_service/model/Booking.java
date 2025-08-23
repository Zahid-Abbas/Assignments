package com.example.booking_service.model;

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
public class Booking {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long bookingId;

	    private String customerName;
	    
	    private LocalDateTime bookingDate;
	    
	    @Enumerated(EnumType.STRING)
	    private BookingStatus status;  

	    private Long vehicleId; 
	    private Long routeId;   
	    private Long driverId;  

	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;
	    
	    

	    public Long getBookingId() {
			return bookingId;
		}

		public void setBookingId(Long bookingId) {
			this.bookingId = bookingId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public LocalDateTime getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(LocalDateTime bookingDate) {
			this.bookingDate = bookingDate;
		}

		public BookingStatus getStatus() {
			return status;
		}

		public void setStatus(BookingStatus status) {
			this.status = status;
		}

		public Long getVehicleId() {
			return vehicleId;
		}

		public void setVehicleId(Long vehicleId) {
			this.vehicleId = vehicleId;
		}

		public Long getRouteId() {
			return routeId;
		}

		public void setRouteId(Long routeId) {
			this.routeId = routeId;
		}

		public Long getDriverId() {
			return driverId;
		}

		public void setDriverId(Long driverId) {
			this.driverId = driverId;
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

		@PrePersist
	    public void onCreate() {
	        createdAt = LocalDateTime.now();
	        updatedAt = createdAt;
	    }

	    @PreUpdate
	    public void onUpdate() {
	        updatedAt = LocalDateTime.now();
	    }

}
