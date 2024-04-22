package com.anima.safranci.healthManagementSystem.dto.patient.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyContactDTO {

    @JsonProperty("nome")
    private String firstName;

    @JsonProperty("sobrenome")
    private String lastName;


    @JsonProperty("telefoneContato")
    private String contactPhone;

    @JsonProperty("grauParentesco")
    private String degreeOfKinship;
}
