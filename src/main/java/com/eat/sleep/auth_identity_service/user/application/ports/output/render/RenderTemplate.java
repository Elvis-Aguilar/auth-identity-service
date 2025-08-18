package com.eat.sleep.auth_identity_service.user.application.ports.output.render;

import java.util.Map;

public interface RenderTemplate {
    String renderTemplate(String templateName, Map<String, Object> variables);
}
