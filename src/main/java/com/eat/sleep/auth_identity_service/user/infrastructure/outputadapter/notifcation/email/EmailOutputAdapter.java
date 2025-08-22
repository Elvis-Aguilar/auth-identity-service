package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.notifcation.email;

import com.eat.sleep.auth_identity_service.common.infrastructure.exception.RequestConflictException;
import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.ConfirmCode;
import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.ConfirmationRegisterUseNotificationPort;
import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.ExistsCode;
import com.eat.sleep.auth_identity_service.user.application.ports.output.notification.GenerateCodeConfirm;
import com.eat.sleep.auth_identity_service.user.application.ports.output.render.RenderTemplate;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEmployeeEntityDomain;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class EmailOutputAdapter implements ConfirmationRegisterUseNotificationPort {

    private final GenerateCodeConfirm generateConfirmCode;
    private final ExistsCode existsCode;
    private final ConfirmCode confirmCode;
    private final RenderTemplate renderTemplate;
    private final SendEmail sendEmail;

    @Override
    public void notifyConfirmRegister(UserEmployeeEntityDomain userEmployee) {
        String code = generateConfirmCode.generateConfirmCode(userEmployee.getEmail());
        Map<String, Object> templateVariables = Map.of("code", code.toCharArray(), "user", userEmployee);
        String confirmationHtml = renderTemplate.renderTemplate("sign-up-confirmation", templateVariables);
        try {
            sendEmail.sendHtmlEmail("E-Health", userEmployee.getEmail(),
                    "Confirmacion de usuario en ComerYDormir", confirmationHtml);
        } catch (MessagingException e) {
            throw new RequestConflictException("No se pudo enviar el correo de confirmacion");
        }
    }
}
