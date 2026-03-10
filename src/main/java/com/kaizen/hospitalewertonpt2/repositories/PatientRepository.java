package com.kaizen.hospitalewertonpt2.repositories;

import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long> {
}
