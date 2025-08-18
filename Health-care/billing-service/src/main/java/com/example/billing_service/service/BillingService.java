package com.example.billing_service.service;

import com.example.billing_service.model.Billing;
import com.example.billing_service.repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Billing create(Billing billing) {
        return billingRepository.save(billing);
    }

    public List<Billing> getAll() {
        return billingRepository.findAll();
    }

    public Optional<Billing> getById(Long id) {
        return billingRepository.findById(id);
    }

    public Billing update(Long id, Billing billing) {
        Billing existing = billingRepository.findById(id).orElseThrow();
        existing.setAmount(billing.getAmount());
        existing.setPaymentStatus(billing.getPaymentStatus());
        existing.setInsuranceProvider(billing.getInsuranceProvider());
        existing.setInvoiceNumber(billing.getInvoiceNumber());
        return billingRepository.save(existing);
    }

    public void delete(Long id) {
        billingRepository.deleteById(id);
    }
}
