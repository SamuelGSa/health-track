package com.anima.safranci.healthManagementSystem.persistence.mapper;

import com.anima.safranci.healthManagementSystem.dto.patient.request.PatientDTO;
import com.anima.safranci.healthManagementSystem.dto.patient.response.PatientResponseDTO;
import com.anima.safranci.healthManagementSystem.persistence.entity.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public Patient mapDTOToModel(PatientDTO patientDTO) {
        return modelMapper.map(patientDTO, Patient.class);
    }

    // Método para mapear de Usuario para UsuarioResponseDTO
    public PatientResponseDTO mapModelToDTO(Patient patient) {
        return modelMapper.map(patient, PatientResponseDTO.class);
    }


}
