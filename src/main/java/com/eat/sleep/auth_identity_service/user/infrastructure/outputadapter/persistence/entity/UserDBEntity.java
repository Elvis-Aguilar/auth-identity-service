package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.entity;

import com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.entity.CustomerDBEntity;
import com.eat.sleep.auth_identity_service.employee.infrastructure.outputadapter.persistence.entity.EmployeeDBEntity;
import com.eat.sleep.auth_identity_service.role.infrastructure.output.persistence.entity.RoleDBEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "user")
@Table(name = "user", schema = "auth")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class UserDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = true)
    @JoinColumn(name = "employee_id")
    private EmployeeDBEntity employee;

    @ManyToOne(optional = true)
    @JoinColumn(name = "customer_id")
    private CustomerDBEntity customer;

    private boolean active;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private RoleDBEntity role;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

}
