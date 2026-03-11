package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.domains.log.Log;
import com.kaizen.hospitalewertonpt2.dtos.LogDTO;
import com.kaizen.hospitalewertonpt2.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public ResponseEntity<Log> logPost (@RequestBody LogDTO logDTO) throws Exception {
        Log newLog = this.logService.logCall(logDTO);
        return new  ResponseEntity<> (newLog,HttpStatus.OK);
    }

}
