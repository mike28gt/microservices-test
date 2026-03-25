package com.devsu.customers_service.application.service;

import com.devsu.customers_service.application.port.in.CustomerUseCase;
import com.devsu.customers_service.application.port.out.CustomerPersistencePort;
import com.devsu.customers_service.domain.model.Customer;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerUseCase {

    private final CustomerPersistencePort customerPersistencePort;

    public CustomerService(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerPersistencePort.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerPersistencePort.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerPersistencePort.findById(customerId);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Optional<Customer> existingCustomerOptional = customerPersistencePort.findById(customerId);

        if (existingCustomerOptional.isEmpty()) {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }

        Customer existingCustomer = existingCustomerOptional.get();
        existingCustomer.setName(customer.getName());
        existingCustomer.setGender(customer.getGender());
        existingCustomer.setAge(customer.getAge());
        existingCustomer.setIdentification(customer.getIdentification());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setStatus(customer.getStatus());

        return customerPersistencePort.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional <Customer> existingCustomerOptional = customerPersistencePort.findById(customerId);

        if (existingCustomerOptional.isEmpty()) {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }

        customerPersistencePort.deleteById(customerId);
    }
}
