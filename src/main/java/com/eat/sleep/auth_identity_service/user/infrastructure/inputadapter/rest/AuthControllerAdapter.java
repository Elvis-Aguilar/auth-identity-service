package com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.rest;

import com.eat.sleep.auth_identity_service.common.infrastructure.annotation.WebAdapter;
import com.eat.sleep.auth_identity_service.user.application.ports.input.AuthenticatingUserInputPort;
import com.eat.sleep.auth_identity_service.user.application.ports.input.ConfirmationCodeInputPort;
import com.eat.sleep.auth_identity_service.user.application.usecase.authentication.AuthUserDto;
import com.eat.sleep.auth_identity_service.user.application.usecase.confirmcode.ConfirmCodeUseDto;
import com.eat.sleep.auth_identity_service.user.domain.model.UserEntityDomain;
import com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto.ConfirmUserDto;
import com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto.TokenDto;
import com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto.UserResponseDto;
import com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.dto.UserSignIn;
import com.eat.sleep.auth_identity_service.user.infrastructure.inputadapter.mapper.UserEmployeeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/auth")
@WebAdapter
@RequiredArgsConstructor
public class AuthControllerAdapter {

    private final ConfirmationCodeInputPort confirmationCodeInputPort;
    private final UserEmployeeMapper userEmployeeMapper;
    private final AuthenticatingUserInputPort authenticatingUserInputPort;

    @PutMapping("/sign-up")
    @Transactional
    public ResponseEntity<TokenDto> confirmCodeUserSingUp(@RequestBody @Valid ConfirmUserDto confirmUserDto) {

        ConfirmCodeUseDto objectAdapter = confirmUserDto.toDomain();

        UserEntityDomain userEntityDomain = this.confirmationCodeInputPort.confirmCode(objectAdapter);

        UserResponseDto userResponseDto = this.userEmployeeMapper.toResponseDto(userEntityDomain);

        TokenDto tokenDto = TokenDto.builder().token(userEntityDomain.getToken()).user(userResponseDto).build();

        return ResponseEntity.status(HttpStatus.OK).body(tokenDto);
    }

    @PostMapping("/sign-in")
    @Transactional
    public ResponseEntity<TokenDto> signIn(@RequestBody @Valid UserSignIn userSignIn) {

        AuthUserDto objectAdapter = userSignIn.toDomain();

        UserEntityDomain userEntityDomain = authenticatingUserInputPort.authenticationUser(objectAdapter);

        UserResponseDto userResponseDto = this.userEmployeeMapper.toResponseDto(userEntityDomain);

        TokenDto tokenDto = TokenDto.builder().token(userEntityDomain.getToken()).user(userResponseDto).build();

        return ResponseEntity.status(HttpStatus.OK).body(tokenDto);

    }

}
