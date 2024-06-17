package com.anima.safranci.healthManagementSystem.persistence.mapper;

import com.anima.safranci.healthManagementSystem.dto.patient.request.PatientRequest;
import com.anima.safranci.healthManagementSystem.dto.patient.response.PatientSaveResponse;
import com.anima.safranci.healthManagementSystem.persistence.entity.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PatientMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public Patient mapDTOToModel(PatientRequest patientDTO) {
        return modelMapper.map(patientDTO, Patient.class);
    }

    // Método para mapear de Usuario para UsuarioResponseDTO
    public PatientRequest mapModelToDTO(Patient patient) {
        return modelMapper.map(patient, PatientRequest.class);
    }

    public PatientSaveResponse mapModelToSaveDTO(Patient patient) {
        return modelMapper.map(patient, PatientSaveResponse.class);
    }

    public Optional<PatientRequest> mapModelToDTOOptional(Optional<Patient> patient) {
        return Optional.ofNullable(modelMapper.map(patient, PatientRequest.class));
    }

}
