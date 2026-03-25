package com.devsu.customers_service.infraestructure.adapter.in.web;

import com.devsu.customers_service.application.port.in.CustomerUseCase;
import com.devsu.customers_service.domain.model.Customer;
import com.devsu.customers_service.infraestructure.adapter.in.web.dto.CustomerRequest;
import com.devsu.customers_service.infraestructure.adapter.in.web.dto.CustomerResponse;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    public CustomerController(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest request) {
        Customer customer = mapToCustomer(request);
        Customer savedCustomer = customerUseCase.createCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToResponse(savedCustomer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> response = customerUseCase.getAllCustomers()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long customerId) {
        Optional<Customer> customerOptional = customerUseCase.getCustomerById(customerId);

        return customerOptional
                .map(customer -> ResponseEntity.ok(mapToResponse(customer)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long customerId,
                                                           @Valid @RequestBody CustomerRequest request) {
        Customer customer = mapToCustomer(request);
        Customer updatedCustomer = customerUseCase.updateCustomer(customerId, customer);

        return ResponseEntity.ok(mapToResponse(updatedCustomer));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerUseCase.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    private Customer mapToCustomer(CustomerRequest request) {
       return Customer.builder()
               .name(request.getName())
               .gender(request.getGender())
               .age(request.getAge())
               .identification(request.getIdentification())
               .address(request.getAddress())
               .phone(request.getPhone())
               .password(request.getPassword())
               .status(request.getStatus())
               .build();
    }

    private CustomerResponse mapToResponse(Customer customer) {
        return CustomerResponse.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .gender(customer.getGender())
                .age(customer.getAge())
                .identification(customer.getIdentification())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .status(customer.getStatus())
                .build();
    }


}
