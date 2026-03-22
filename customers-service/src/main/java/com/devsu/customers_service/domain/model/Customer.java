package com.devsu.customers_service.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private Boolean status;
}
