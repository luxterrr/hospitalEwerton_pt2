package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.log.Log;
import com.kaizen.hospitalewertonpt2.domains.log.LogType;
import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import com.kaizen.hospitalewertonpt2.repositories.LogRepository;
import com.kaizen.hospitalewertonpt2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private PatientRepository patientRepository;

    public String admittedReport(Long patientId) throws Exception {
        Patient patientFound = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("PATIENT DOESNT EXISTS"));

        if (!patientFound.isAdmitted()) {
            throw new RuntimeException("PATIENT ISNT ADMITTED");
        }

        Optional<Log> patientLog = logRepository.findLogByPatientId(patientId, LogType.ADMISSION).stream().findFirst();

        String report = "HOSPITAL NAME: " + patientFound.getBed().getRoom().getWard().getHospital().getName() +
                "\n SPECIALITY: " + patientFound.getBed().getRoom().getWard().getSpeciality() +
                "\n ROOM CODE: " + patientFound.getBed().getRoom().getRoomCode() +
                "\n PATIENT's NAME: " + patientFound.getPatientName() +
                "\n HOUR OF ADMISSION: " + patientLog.get().getTimeStamp();
        return report;
    }
}
