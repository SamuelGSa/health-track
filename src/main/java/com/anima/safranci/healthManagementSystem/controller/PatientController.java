package com.anima.safranci.healthManagementSystem.controller;

import com.anima.safranci.healthManagementSystem.dto.patient.request.PatientRequest;
import com.anima.safranci.healthManagementSystem.dto.patient.response.PatientSaveResponse;
import com.anima.safranci.healthManagementSystem.persistence.entity.Patient;
import com.anima.safranci.healthManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequestMapping("healthmanagement/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;


    @GetMapping
    public ResponseEntity<List<PatientRequest>> getAllPatients() {
        var listaUsuarios = patientService.getAllPatients();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PatientRequest>> getUserById(@PathVariable Long id) {

        var usuarioSolicitado = patientService.getPatientById(id);
        return new ResponseEntity<>(usuarioSolicitado, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientSaveResponse> savePatient(@RequestBody PatientRequest patientDTO) {

        var usuarioSalvo = patientService.savePatient(patientDTO);
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Patient>> deleteUserById(@PathVariable Long id) {

        try {
            patientService.detelePatientById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updateUserById(@PathVariable Long id, @RequestBody PatientRequest patientDTO) {

        try {
            patientService.atualizaUsuarioPorId(id, patientDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}