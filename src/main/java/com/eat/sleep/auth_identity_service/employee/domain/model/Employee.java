package com.eat.sleep.auth_identity_service.employee.domain.model;

import com.eat.sleep.auth_identity_service.common.application.exception.EntityConflictUserType;
import io.micrometer.core.instrument.config.InvalidConfigurationException;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Employee {

    private UUID id;
    private String fullName;
    private String cui;
    private String phone;
    private String email;
    private String jobPosition;
    private BigDecimal salary;
    private String address;
    private UUID hotelId;
    private UUID restaurantId;

    public Employee(UUID id, String fullName, String cui, String phone, String email, String jobPosition, BigDecimal salary, String address, UUID hotelId, UUID restaurantId) {
        this.id = id;
        this.fullName = fullName;
        this.cui = cui;
        this.phone = phone;
        this.email = email;
        this.jobPosition = jobPosition;
        this.salary = salary;
        this.address = address;
        this.hotelId = hotelId;
        this.restaurantId = restaurantId;
    }

    public Employee(String fullName, String cui, String phone, String email, String jobPosition, BigDecimal salary, String address, UUID hotelId, UUID restaurantId) {
        this.fullName = fullName;
        this.cui = cui;
        this.phone = phone;
        this.email = email;
        this.jobPosition = jobPosition;
        this.salary = salary;
        this.address = address;
        this.hotelId = hotelId;
        this.restaurantId = restaurantId;
    }

    private void validate() {
        Objects.requireNonNull(email, "Email no puede ser nulo");

        // TODO: mas validaciones de dominio.

        if (this.restaurantId == null && this.hotelId == null) {
            throw new EntityConflictUserType("El empleado debe estar asignado a un retaurante o un hotel");
        }

        if (this.restaurantId != null && this.hotelId != null) {
            throw new EntityConflictUserType("El empleado solo puede estar asignado a un hoter o aun restaurente, no los dos a la vez");
        }

        if (!(this.salary.compareTo(BigDecimal.ZERO)>0)){
            throw new InvalidConfigurationException("El salario no debe ser mayor a cero");
        }
    }
}
