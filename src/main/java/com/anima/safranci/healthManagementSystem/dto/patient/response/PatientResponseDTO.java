package com.anima.safranci.healthManagementSystem.dto.patient.response;

import com.anima.safranci.healthManagementSystem.dto.patient.request.EmergencyContactDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDTO {

    @JsonProperty("nome")
    private String firstName;

    @JsonProperty("sobrenome")
    private String lastName;

    @JsonProperty("dataNascimento")
    private String birthDate;

    @JsonProperty("contatoEmergencia")
    private EmergencyContactDTO emergencyContact;

}

