package com.example.billing_service.controller;

import com.example.billing_service.model.Billing;
import com.example.billing_service.service.BillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billings")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping
    public Billing create(@RequestBody Billing billing) {
        return billingService.create(billing);
    }

    @GetMapping
    public List<Billing> getAll() {
        return billingService.getAll();
    }

    @GetMapping("/{id}")
    public Billing getById(@PathVariable Long id) {
        return billingService.getById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Billing update(@PathVariable Long id, @RequestBody Billing billing) {
        return billingService.update(id, billing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        billingService.delete(id);
    }
}
