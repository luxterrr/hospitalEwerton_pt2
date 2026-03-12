package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.log.LogType;
import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import com.kaizen.hospitalewertonpt2.dtos.*;
import com.kaizen.hospitalewertonpt2.repositories.BedRepository;
import com.kaizen.hospitalewertonpt2.repositories.LogRepository;
import com.kaizen.hospitalewertonpt2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BedRepository bedRepository;

    public AdmittedReportDTO admittedReport(Long patientId) throws Exception {
        Patient patientFound = patientRepository.findById(patientId).orElseThrow(() -> new ExpressionException("PATIENT DOESNT EXISTS"));

        if (!patientFound.isAdmitted()) {
            throw new RuntimeException("PATIENT ISNT ADMITTED");
        }

        return logRepository.findLogByPatientId(patientId, LogType.ADMISSION).getFirst();
    }

    public List<BedReportDTO> bedReport(Long bedId) throws Exception {

        Bed bedFound = bedRepository.findById(bedId).orElseThrow(() -> new RuntimeException("BED DOESNT EXISTS"));
        return logRepository.findLogByBedId(bedId);
    }

    public List<RoomReportDTO> freeRoomsReport() throws Exception {
        return logRepository.findFreeRooms();
    }

    public List<SpecialityReportDTO> freeSpecialitiesReport() {
        return logRepository.findFreeSpecialities();
    }

    public List<AllAdmittedReportDTO> allAdmittedReport() {
        List<AllAdmittedReportDTO> allAdmittedPatients = logRepository.findAllAdmittedPatients();
        allAdmittedPatients.forEach(dto -> dto.setDaysAdmitted((int) ChronoUnit.DAYS.between(dto.getAdmissionDate(), LocalDateTime.now())));
        return allAdmittedPatients;
    }

    public List<AllRoomsPerSpecialityDTO> findRoomsPerSpeciality() {
        return logRepository.findRoomsPerSpeciality();
    }

    public Page<PatientReportDTO> patientHistoric(Long patientId, Pageable pageable) throws Exception {
        Patient patientFound = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("PATIENT DOESNT EXISTS"));
        return logRepository.findHistoricById(patientId, pageable);
    }
}
