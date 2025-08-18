package com.eat.sleep.auth_identity_service.user.domain.model;

import com.eat.sleep.auth_identity_service.role.infrastructure.output.persistence.entity.RoleDBEntity;
import lombok.Getter;

@Getter
public class Role {
    String name;
    long id;

    public Role(RoleDBEntity roleDBEntity){
        this.name = roleDBEntity.getName();
        this.id = roleDBEntity.getId();
    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }
}
