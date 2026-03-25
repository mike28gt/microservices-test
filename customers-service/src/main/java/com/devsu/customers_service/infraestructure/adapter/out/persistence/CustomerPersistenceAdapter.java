package com.devsu.customers_service.infraestructure.adapter.out.persistence;

import com.devsu.customers_service.domain.model.Customer;
import com.devsu.customers_service.application.port.out.CustomerPersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerPersistenceAdapter implements CustomerPersistencePort {

    private final CustomerJpaRepository customerJpaRepository;

    public CustomerPersistenceAdapter(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerJpaRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerJpaRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        return customerJpaRepository.findById(customerId);
    }

    @Override
    public void deleteById(Long customerId) {
        customerJpaRepository.deleteById(customerId);
    }
}
