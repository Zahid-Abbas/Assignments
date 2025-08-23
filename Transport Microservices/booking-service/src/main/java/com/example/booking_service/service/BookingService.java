package com.example.booking_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking_service.exception.ResourceNotFoundException;
import com.example.booking_service.model.Booking;
import com.example.booking_service.model.BookingStatus;
import com.example.booking_service.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
    	booking.setStatus(BookingStatus.CONFIRMED); 
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id));
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking booking = getBookingById(id);
        booking.setCustomerName(updatedBooking.getCustomerName());
        booking.setVehicleId(updatedBooking.getVehicleId());
        booking.setRouteId(updatedBooking.getRouteId());
        booking.setDriverId(updatedBooking.getDriverId());
        booking.setStatus(updatedBooking.getStatus());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

}
