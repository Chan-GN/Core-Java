package com.example.model;

import com.example.db.DBClose;
import com.example.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDaoImpl implements PatientDAO {

    public PatientDaoImpl() {

    }

    @Override
    public boolean createPatient(PatientDTO patient) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql =
                "INSERT INTO patient (number, department, length_of_stay, age, " +
                        "consultation_fee, hospitalization_fee, medical_fee, code) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, patient.getNumber());
        pstmt.setString(2, patient.getTreatmentCode().getMedicalDepartmentName());
        pstmt.setInt(3, patient.getLengthOfStay());
        pstmt.setInt(4, patient.getAge());
        pstmt.setInt(5, patient.getConsultationFee());
        pstmt.setInt(6, patient.getHospitalizationFee());
        pstmt.setInt(7, patient.getMedicalFee());
        pstmt.setString(8, patient.getTreatmentCode().toString());

        int affectedRows = pstmt.executeUpdate();

        DBClose.dbClose(conn, pstmt);

        return affectedRows == 1;
    }

    @Override
    public Optional<PatientDTO> readOnePatient(int number) throws SQLException {
        Connection conn;
        CallableStatement cstmt;

        conn = DBConnection.getConnection();
        cstmt = conn.prepareCall("{ call sp_read_one_patient(?) }");
        cstmt.setInt(1, number);
        ResultSet rs = cstmt.executeQuery();

        if (rs.next()) {
            return Optional.of(
                    new PatientDTO(
                            rs.getInt("number"),
                            MedicalDepartment.valueOf(rs.getString("code")),
                            rs.getInt("length_of_stay"),
                            rs.getInt("age"),
                            rs.getInt("consultation_fee"),
                            rs.getInt("hospitalization_fee"),
                            rs.getInt("medical_fee"))
            );
        }

        DBClose.dbClose(conn, cstmt, rs);

        return Optional.empty();
    }

/*
    // V1
    @Override
    public List<PatientDTO> readAllPatient() throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT number, code, consultation_fee, hospitalization_fee, medical_fee " +
                "FROM patient ORDER BY number";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<PatientDTO> patients = new ArrayList<>();
        while (rs.next()) {
            patients.add(new PatientDTO(
                    rs.getInt("number"),
                    MedicalDepartment.valueOf(rs.getString("code")),
                    rs.getInt("consultation_fee"),
                    rs.getInt("hospitalization_fee"),
                    rs.getInt("medical_fee")
            ));
        }

        return patients;
    }
*/

    // V2 : Use Stored Procedure
    @Override
    public List<PatientDTO> readAllPatients() throws SQLException {
        List<PatientDTO> patients = new ArrayList<>();
        Connection connection;
        CallableStatement cstmt;
        ResultSet rs;

        connection = DBConnection.getConnection();
        cstmt = connection.prepareCall("{ call sp_read_all_patients() }");
        rs = cstmt.executeQuery();

        while (rs.next()) {
            patients.add(new PatientDTO(
                    rs.getInt("number"),
                    MedicalDepartment.valueOf(rs.getString("code")),
                    rs.getInt("consultation_fee"),
                    rs.getInt("hospitalization_fee"),
                    rs.getInt("medical_fee")
            ));
        }

        DBClose.dbClose(connection, cstmt, rs);

        return patients;
    }

    @Override
    public boolean
    updatePatient(PatientDTO patientDTO) throws SQLException {
        Connection connection = null;
        CallableStatement cstmt = null;
        boolean success;

        try {
            connection = DBConnection.getConnection();
            cstmt = connection.prepareCall("{ call sp_update_patient(?, ?, ?, ?, ?, ?, ?, ?, ?) }");

            cstmt.setInt(1, patientDTO.getNumber());
            cstmt.setString(2, patientDTO.getTreatmentCode().name());
            cstmt.setInt(3, patientDTO.getConsultationFee());
            cstmt.setInt(4, patientDTO.getHospitalizationFee());
            cstmt.setInt(5, patientDTO.getMedicalFee());
            cstmt.setString(6, patientDTO.getTreatmentCode().getMedicalDepartmentName());
            cstmt.setInt(7, patientDTO.getLengthOfStay());
            cstmt.setInt(8, patientDTO.getAge());
            cstmt.registerOutParameter(9, Types.BOOLEAN);

            cstmt.execute();

            success = cstmt.getBoolean(9);
        } finally {
            DBClose.dbClose(connection, cstmt, null);
        }

        return success;
    }

    @Override
    public boolean deletePatient(int number) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM patient WHERE number = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, number);
        int affectedRows = pstmt.executeUpdate();
        DBClose.dbClose(conn, pstmt);

        return affectedRows == 1;
    }

}
