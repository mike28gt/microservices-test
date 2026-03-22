package com.devsu.customers_service.infraestructure.adapter.out.persistence;

import com.devsu.customers_service.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {

}
