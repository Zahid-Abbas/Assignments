package com.example.route_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.route_service.exception.ResourceNotFoundException;
import com.example.route_service.model.Route;
import com.example.route_service.repository.RouteRepository;

@Service
public class RouteService {
	
	@Autowired
	private RouteRepository routeRepository;
	
	public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    public Route getRouteById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route updateRoute(Long id, Route route) {
        Route r = routeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));

        r.setSource(route.getSource());
        r.setDestination(route.getDestination());
        r.setDistance(route.getDistance());
        r.setEstimatedTime(route.getEstimatedTime());

        return routeRepository.save(r);
    }

    public void deleteRoute(Long id) {
        Route r = routeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));
        routeRepository.delete(r);
    }

}
