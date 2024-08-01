package com.example.controller;

import com.example.service.PatientService;

import java.sql.SQLException;

public class DeleteController {

    private final PatientService patientService;

    public DeleteController(PatientService patientService) {
        this.patientService = patientService;
    }

    public boolean deletePatient(int number) {
        try {
            return patientService.deletePatient(number);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

}
