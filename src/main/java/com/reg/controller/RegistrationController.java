package com.reg.controller;


import com.reg.entity.Registration;
import com.reg.payload.RegistrationDto;
import com.reg.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    //http://localhost:8080/api/v1/registration
    @PostMapping
    public ResponseEntity<RegistrationDto> cerateRegistration(@RequestBody RegistrationDto registrationDto){
        RegistrationDto regDto = registrationService.cerateRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/registration?id=
    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(@RequestParam long id){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Record id is deleted...", HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/registration?id=
    @PutMapping
    public ResponseEntity<RegistrationDto> updateRegistration(
            @RequestBody RegistrationDto registrationDto,
            @RequestParam long id
    ){
        RegistrationDto registration = registrationService.updateRegistration(registrationDto, id);
        return new ResponseEntity<>(registration, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/registration
    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistration(){
        List<RegistrationDto> allRegistration = registrationService.getAllRegistration();
        return new ResponseEntity<>(allRegistration, HttpStatus.OK);
    }

}
