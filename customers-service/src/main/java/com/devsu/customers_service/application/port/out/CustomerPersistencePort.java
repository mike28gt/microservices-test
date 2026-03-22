package com.devsu.customers_service.application.port.out;

import com.devsu.customers_service.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerPersistencePort {
    Customer save(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(Long customerId);

    void deleteById(Long customerId);
}
