package com.example.model;

import com.example.db.DBClose;
import com.example.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PatientDaoImpl implements PatientDAO {

    public PatientDaoImpl() {

    }

    @Override
    public boolean createPatient(PatientDTO patient) throws SQLException {
        Connection conn = new DBConnection().getConnection();
        String sql =
                "INSERT INTO patient (number, department, length_of_stay, age, " +
                        "consultation_fee, hospitalization_fee, medical_fee) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, patient.getNumber());
        pstmt.setString(2, patient.getTreatmentCode().getMedicalDepartmentName());
        pstmt.setInt(3, patient.getLengthOfStay());
        pstmt.setInt(4, patient.getAge());
        pstmt.setInt(5, patient.getConsultationFee());
        pstmt.setInt(6, patient.getHospitalizationFee());
        pstmt.setInt(7, patient.getMedicalFee());

        int affectedRows = pstmt.executeUpdate();

        DBClose.dbClose(conn, pstmt);

        return affectedRows == 1;
    }

    @Override
    public PatientDTO readPatient(int number) {
        return null;
    }

    @Override
    public List<PatientDTO> readAllPatient() {
        return List.of();
    }

    @Override
    public boolean updatePatient(PatientDTO patient) {
        return false;
    }

    @Override
    public boolean deletePatient(int number) {
        return false;
    }

}
