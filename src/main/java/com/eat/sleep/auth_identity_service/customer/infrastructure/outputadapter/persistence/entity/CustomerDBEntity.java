package com.eat.sleep.auth_identity_service.customer.infrastructure.outputadapter.persistence.entity;

import com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.persistence.entity.UserDBEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "customer")
@Table(name = "customer", schema = "identity")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class CustomerDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private String fullName;

    @NonNull
    @Column(nullable = false)
    private String cui;

    @NonNull
    @Column(nullable = false)
    private String phone;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String address;

    @Builder.Default
    private Integer loyaltyPoints = 0;

    @OneToMany(mappedBy = "customer")
    private Set<UserDBEntity> users;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

}

