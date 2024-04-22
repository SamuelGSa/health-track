package com.anima.safranci.healthManagementSystem.controller;

import com.anima.safranci.healthManagementSystem.dto.patient.request.PatientDTO;
import com.anima.safranci.healthManagementSystem.dto.patient.response.PatientResponseDTO;
import com.anima.safranci.healthManagementSystem.persistence.entity.Patient;
import com.anima.safranci.healthManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequestMapping("healthmanagement/patient")
@RequiredArgsConstructor
public class PatientController {

    @Autowired
    private final PatientService patientService;


    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        var listaUsuarios = patientService.getAllPatients();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> savePatient( @RequestBody PatientDTO patientDTO) {

        var usuarioSalvo = patientService.savePatient(patientDTO);
        return new ResponseEntity<>(usuarioSalvo,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Patient>> deleteUserById(@PathVariable Long id) {

        try {
            patientService.detelePatientById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Usuario> updateUserById(@PathVariable Long id, @RequestBody UsuarioDTO novoUsuario) {
//
//        try {
//            usuarioService.atualizaUsuarioPorId(id,novoUsuario) ;
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (NoSuchElementException nsee){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//
//    }

}