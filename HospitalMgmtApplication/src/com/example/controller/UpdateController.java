package com.example.controller;

import com.example.exception.ApplicationException;
import com.example.model.PatientDTO;
import com.example.service.PatientService;

import java.sql.SQLException;
import java.util.Map;

public class UpdateController {

    private final PatientService patientService;

    public UpdateController(PatientService patientService) {
        this.patientService = patientService;
    }

    public boolean updatePatient(PatientDTO patientDTO, Map<String, Object> updates) throws ApplicationException {
        try {
            return patientService.updatePatient(patientDTO, updates);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ApplicationException("환자 갱신을 실패하였습니다. (데이터베이스 오류)");
        }
    }

}
