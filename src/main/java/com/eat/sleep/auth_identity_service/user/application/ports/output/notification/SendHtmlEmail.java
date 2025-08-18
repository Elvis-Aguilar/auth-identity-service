package com.eat.sleep.auth_identity_service.user.application.ports.output.notification;

import jakarta.mail.MessagingException;

import java.io.File;

public interface SendHtmlEmail {
    void sendHtmlEmail(String companyName, String toEmail, String subject, String htmlContent, File... attachments)
            throws MessagingException;
}
