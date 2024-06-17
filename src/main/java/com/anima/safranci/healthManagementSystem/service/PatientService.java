package com.anima.safranci.healthManagementSystem.service;


import com.anima.safranci.healthManagementSystem.dto.patient.request.PatientRequest;
import com.anima.safranci.healthManagementSystem.dto.patient.response.PatientSaveResponse;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<PatientRequest> getAllPatients();

    PatientSaveResponse savePatient(PatientRequest patientDTO);

    Optional<PatientRequest> getPatientById(Long id);


    void detelePatientById(Long id);

    void atualizaUsuarioPorId(Long id, PatientRequest patientDTO);
}
