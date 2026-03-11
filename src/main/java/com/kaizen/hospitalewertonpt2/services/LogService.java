package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.bed.StatusBed;
import com.kaizen.hospitalewertonpt2.domains.log.Log;
import com.kaizen.hospitalewertonpt2.domains.log.LogType;
import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import com.kaizen.hospitalewertonpt2.dtos.LogDTO;
import com.kaizen.hospitalewertonpt2.repositories.BedRepository;
import com.kaizen.hospitalewertonpt2.repositories.LogRepository;
import com.kaizen.hospitalewertonpt2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private BedService bedService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private LogRepository logRepository;

    public Log logCall (LogDTO logDTO) throws Exception {
        Patient sickPatient = this.patientService.findPatientById(logDTO.getPatientId());
        Bed useBed = this.bedService.findBedById(logDTO.getBedId());
        //validar patient e bed

        if (logDTO.getLogType() == LogType.ADMISSION) {
            this.admissionLog(logDTO, useBed, sickPatient);
        } else this.dischargeLog(logDTO, useBed, sickPatient);

        return null;
    }

    public Log admissionLog (LogDTO logDTO, Bed useBed, Patient sickPatient) {

        if (!patientService.validatePatient(sickPatient) || !bedService.validateBed(useBed)) {
            throw new RuntimeException("IMPOSSIBLE TO ADMITE, REASON: PATIENT ALREADY ADMITTED OR BED UNABLE TO USE");
        }
        Log newLog = new Log();
        newLog.setPatient(sickPatient);
        newLog.setBed(useBed);
        newLog.setTimeStamp(LocalDateTime.now());
        newLog.setLogType(logDTO.getLogType());

        sickPatient.setAdmitted(true);
        useBed.setStatusBed(StatusBed.OCCUPIED);
        useBed.setPatient(sickPatient);

        this.logRepository.save(newLog);
        this.patientRepository.save(sickPatient);
        this.bedRepository.save(useBed);

        return newLog;
    }

    public Log dischargeLog (LogDTO logDTO, Bed useBed, Patient sickPatient) throws Exception {

        this.validateLog(useBed, sickPatient);

        Log newLog = new Log();
        newLog.setPatient(sickPatient);
        newLog.setBed(useBed);
        newLog.setTimeStamp(LocalDateTime.now());
        newLog.setLogType(logDTO.getLogType());

        sickPatient.setAdmitted(false);
        useBed.setStatusBed(StatusBed.PREPARATION);

        this.logRepository.save(newLog);
        this.patientRepository.save(sickPatient);
        this.bedRepository.save(useBed);

        return newLog;
    }

    public boolean validateLog (Bed useBed, Patient sickPatient) throws Exception {
        if (sickPatient.isAdmitted() && useBed.getStatusBed() == StatusBed.OCCUPIED && useBed.getPatient() == sickPatient) {
            return true;
        } else throw new RuntimeException("LOG DOESNT EXIST");
    }
}
