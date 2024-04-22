package com.anima.safranci.healthManagementSystem.service;


import com.anima.safranci.healthManagementSystem.dto.patient.request.PatientDTO;
import com.anima.safranci.healthManagementSystem.dto.patient.response.PatientResponseDTO;
import com.anima.safranci.healthManagementSystem.persistence.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO savePatient(PatientDTO patientDTO);

    void detelePatientById(Long id);

}
