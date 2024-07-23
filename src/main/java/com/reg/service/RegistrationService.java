package com.reg.service;

import com.reg.payload.RegistrationDto;

import java.util.List;

public interface RegistrationService {
    RegistrationDto cerateRegistration(RegistrationDto registrationDto);

    void deleteRegistration(long id);

    RegistrationDto updateRegistration(RegistrationDto registrationDto, long id);

    List<RegistrationDto> getAllRegistration(int pageNo, int pageSize);
}
