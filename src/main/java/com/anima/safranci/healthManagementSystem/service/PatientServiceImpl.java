package com.anima.safranci.healthManagementSystem.service;

import com.anima.safranci.healthManagementSystem.dto.patient.request.PatientDTO;
import com.anima.safranci.healthManagementSystem.dto.patient.response.PatientResponseDTO;
import com.anima.safranci.healthManagementSystem.persistence.entity.Patient;
import com.anima.safranci.healthManagementSystem.persistence.mapper.PatientMapper;
import com.anima.safranci.healthManagementSystem.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.anima.safranci.healthManagementSystem.utils.DataUtils.formataData;


@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;


    public List<PatientResponseDTO> getAllPatients() {
        log.info("Buscando todos os usuários");

        List<Patient> usuariosList = patientRepository.findAll();

        log.info(usuariosList.size() + " Usuarios Encontrados");

        // Usando o UsuarioMapper para converter a lista
        var listaUsuarios = usuariosList.stream()
                .map(patientMapper::mapModelToDTO)
                .collect(Collectors.toList());

        for (PatientResponseDTO patient : listaUsuarios) {
            patient.setBirthDate(String.valueOf(formataData(LocalDate.parse(patient.getBirthDate()))));
        }
        return listaUsuarios;
    }

    public PatientResponseDTO savePatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.mapDTOToModel(patientDTO);

        log.info("Salvando paciente");
        patientRepository.save(patient);
        var patientResponse = patientMapper.mapModelToDTO(patient);
        patientResponse.setBirthDate(formataData(patient.getBirthDate()));

        return patientResponse;
    }

    public void detelePatientById(Long id) {
        patientRepository.deleteById(id);
    }

}
