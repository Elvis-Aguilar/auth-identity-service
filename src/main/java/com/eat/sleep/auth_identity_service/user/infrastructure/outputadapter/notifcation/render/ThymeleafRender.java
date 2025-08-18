package com.eat.sleep.auth_identity_service.user.infrastructure.outputadapter.notifcation.render;

import com.eat.sleep.auth_identity_service.user.application.ports.output.render.RenderTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ThymeleafRender implements RenderTemplate {

    private final SpringTemplateEngine templateEngine;

    @Override
    public String renderTemplate(String templateName, Map<String, Object> variables) {
        Context context = new Context();
        context.setVariables(variables);

        return templateEngine.process(templateName, context);
    }
}
