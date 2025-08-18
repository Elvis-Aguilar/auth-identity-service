package com.eat.sleep.auth_identity_service.config.infrastructure.property;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("security.rsa")
public record RsaProperty(
        RSAPublicKey publicKey,
        RSAPrivateKey privateKey) {
}
