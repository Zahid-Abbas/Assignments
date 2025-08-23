package com.example.route_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.route_service.model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {

}
