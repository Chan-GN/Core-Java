package com.example.controller;

import com.example.model.PatientDTO;
import com.example.service.PatientService;

import java.sql.SQLException;

public class InsertController {

    private final PatientService patientService;

    public InsertController(PatientService patientService) {
        this.patientService = patientService;
    }

    public boolean insert(PatientDTO patientDTO) {
        try {
            return patientService.createPatient(patientDTO);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

}
