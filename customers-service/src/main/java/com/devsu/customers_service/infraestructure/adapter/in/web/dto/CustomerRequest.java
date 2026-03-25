package com.devsu.customers_service.infraestructure.adapter.in.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotNull
    @Min(0)
    private Integer age;

    @NotBlank
    private String identification;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;

    @NotBlank
    private String password;

    @NotNull
    private Boolean status;
}
