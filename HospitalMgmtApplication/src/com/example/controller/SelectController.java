package com.example.controller;

import com.example.exception.ApplicationException;
import com.example.model.PatientDTO;
import com.example.service.PatientService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SelectController {

    private final PatientService patientService;

    public SelectController(PatientService patientService) {
        this.patientService = patientService;
    }

    public List<PatientDTO> readAllPatients() throws ApplicationException {
        try {
            return patientService.readAllPatients();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ApplicationException("환자 목록을 불러올 수 없습니다. (데이터베이스 오류)");
        }


    }

    public PatientDTO readOnePatient(int number) throws ApplicationException {
        try {
            Optional<PatientDTO> patientDTO = patientService.readOnePatient(number);

            if (patientDTO.isEmpty()) throw new ApplicationException("해당 번호의 환자가 존재하지 않습니다.");

            return patientDTO.get();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ApplicationException("환자 정보를 불러올 수 없습니다. (데이터베이스 오류)");
        }
    }

}
