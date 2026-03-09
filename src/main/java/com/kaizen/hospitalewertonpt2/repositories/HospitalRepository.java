package com.kaizen.hospitalewertonpt2.repositories;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.dtos.HospitalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
