package com.anima.safranci.healthManagementSystem.service.impl;

import com.anima.safranci.healthManagementSystem.dto.patient.request.PatientRequest;
import com.anima.safranci.healthManagementSystem.dto.patient.response.PatientSaveResponse;
import com.anima.safranci.healthManagementSystem.persistence.entity.Patient;
import com.anima.safranci.healthManagementSystem.persistence.mapper.PatientMapper;
import com.anima.safranci.healthManagementSystem.persistence.repository.PatientRepository;
import com.anima.safranci.healthManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;


    public List<PatientRequest> getAllPatients() {
        log.info("Buscando todos os usuários");

        List<Patient> usuariosList = patientRepository.findAll();

        log.info(usuariosList.size() + " Usuarios Encontrados");

        // Usando o UsuarioMapper para converter a lista
        var listaUsuarios = usuariosList.stream()
                .map(patientMapper::mapModelToDTO)
                .collect(Collectors.toList());

        return listaUsuarios;
    }

    public PatientSaveResponse savePatient(PatientRequest patientDTO) {
        Patient patient = patientMapper.mapDTOToModel(patientDTO);

        log.info("Salvando paciente");
        patientRepository.save(patient);
        var patientResponse = patientMapper.mapModelToSaveDTO(patient);
        return patientResponse;
    }

    @Override
    public Optional<PatientRequest> getPatientById(Long id) {

        var usuarioSolicitado = patientRepository.findById(id);
        var patientResponse = patientMapper.mapModelToDTOOptional(usuarioSolicitado);

        return patientResponse;
    }


    public void detelePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public void atualizaUsuarioPorId(Long id, PatientRequest novoUsuario) {
        Patient pacienteAtualizado = patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(novoUsuario.getFirstName());
                    patient.setLastName(novoUsuario.getLastName());
                    patient.setContactPhone(novoUsuario.getContactPhone());
                    patient.setBirthDate(novoUsuario.getBirthDate());
                    patient.setEmail(novoUsuario.getEmail());
                    return patient;
                })
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + id));

        patientRepository.save(pacienteAtualizado);
    }
}
