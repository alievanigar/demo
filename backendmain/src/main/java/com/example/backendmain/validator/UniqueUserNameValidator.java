package com.example.backendmain.validator;

import com.example.backendmain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public final class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName,String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String t, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByUsername(t);
    }
}
