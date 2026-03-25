package com.devsu.customers_service.application.port.in;

import com.devsu.customers_service.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerUseCase {

    Customer createCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long customerId);

    Customer updateCustomer(Long customerId, Customer customer);

    void deleteCustomer(Long customerId);
}
