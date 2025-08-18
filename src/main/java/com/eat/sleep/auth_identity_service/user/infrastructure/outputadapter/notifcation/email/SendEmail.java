package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.notifcation.email;

import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.SendHtmlEmail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.File;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import java.util.stream.Stream;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;

@Component
@RequiredArgsConstructor
public class SendEmail  implements SendHtmlEmail {

    private final JavaMailSender mailSender;

    @Override
    public void sendHtmlEmail(String companyName, String toEmail, String subject, String htmlContent,
                              File... attachments) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        if (!isEmpty(attachments)) {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            Stream.of(attachments)
                    .map(FileSystemResource::new)
                    .forEach(file -> {
                        try {
                            messageHelper.addAttachment(file.getFilename(), file);
                        } catch (MessagingException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

        message.setFrom(companyName);
        message.setRecipients(MimeMessage.RecipientType.TO, toEmail);
        message.setSubject(subject);
        message.setContent(htmlContent, "text/html; charset=utf-8");

        mailSender.send(message);
    }
}
