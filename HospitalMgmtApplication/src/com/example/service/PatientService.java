package com.example.service;

import com.example.model.PatientDAO;
import com.example.model.PatientDTO;

import java.sql.SQLException;

public class PatientService {

    private final PatientDAO patientDAO;

    public PatientService(PatientDAO patientDao) {
        this.patientDAO = patientDao;
    }

    public boolean createPatient(PatientDTO patientDTO) throws SQLException {
        PatientDTO updated = calculateFee(patientDTO);

        return patientDAO.createPatient(updated);
    }

    private PatientDTO calculateFee(PatientDTO patientDTO) {
        int consultationFee = calculateConsultationFee(patientDTO.getAge());
        int hospitalizationFee = calculateTotalHospitalizationFee(patientDTO.getLengthOfStay());
        int medicalFee = consultationFee + hospitalizationFee;

        patientDTO.updateFees(consultationFee, hospitalizationFee, medicalFee);

        return patientDTO;
    }

    private int calculateConsultationFee(int age) {
        return switch (age / 10) {
            case 0, 3 -> 7_000;
            case 1 -> 5_000;
            case 2 -> 8_000;
            case 4 -> 4_500;
            default -> 2_300;
        };
    }

    private int calculateTotalHospitalizationFee(int lengthOfStay) {
        if (lengthOfStay <= 3) {
            return (int) (lengthOfStay * 30_000 * getHospitalizationFeeDiscountRate(lengthOfStay));
        } else {
            return (int) (lengthOfStay * 25_000 * getHospitalizationFeeDiscountRate(lengthOfStay));
        }
    }

    private double getHospitalizationFeeDiscountRate(int lengthOfStay) {
        if (lengthOfStay < 10) {
            return 1.00;
        } else if (lengthOfStay < 15) {
            return 0.85;
        } else if (lengthOfStay < 20) {
            return 0.8;
        } else if (lengthOfStay < 30) {
            return 0.77;
        } else if (lengthOfStay < 100) {
            return 0.72;
        } else {
            return 0.68;
        }
    }

}