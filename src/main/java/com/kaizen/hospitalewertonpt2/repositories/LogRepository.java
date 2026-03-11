package com.kaizen.hospitalewertonpt2.repositories;

import com.kaizen.hospitalewertonpt2.domains.log.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
