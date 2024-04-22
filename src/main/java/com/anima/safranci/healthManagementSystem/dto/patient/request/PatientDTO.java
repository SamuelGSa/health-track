package com.anima.safranci.healthManagementSystem.dto.patient.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    @JsonProperty("nome")
    private String firstName;

    @JsonProperty("sobrenome")
    private String lastName;

    @JsonProperty("contato")
    private String contactPhone;

    @JsonProperty("dataNascimento")
    private LocalDate birthDate;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("email")
    private String email;

    @JsonProperty("contatoEmergencia")
    private EmergencyContactDTO emergencyContact;

}
