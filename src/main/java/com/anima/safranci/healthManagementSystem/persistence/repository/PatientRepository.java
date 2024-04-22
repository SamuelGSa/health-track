package com.anima.safranci.healthManagementSystem.persistence.repository;

import com.anima.safranci.healthManagementSystem.persistence.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Long> {

}
