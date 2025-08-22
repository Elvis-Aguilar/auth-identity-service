package com.eat.sleep.auth_identity_service.user.application.ports.input;

import com.eat.sleep.auth_identity_service.user.application.usecase.confirmcode.ConfirmCodeUseDto;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;

public interface ConfirmationCodeInputPort {
    UserEntityDomain confirmCode(ConfirmCodeUseDto confirmCodeUseDto);

}
