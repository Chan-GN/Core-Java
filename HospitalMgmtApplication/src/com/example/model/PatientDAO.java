package com.example.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PatientDAO {

    /**
     * 새로운 환자를 등록한다. 등록에 성공하면 true, 실패하면 false 를 반환한다.
     *
     * @param patient 생성할 환자 정보
     * @return 등록 성공 시 true, 실패 시 false
     */
    boolean createPatient(PatientDTO patient) throws SQLException;

    /**
     * 환자 등록 번호를 입력받아서 해당 번호의 환자 한명을 반환한다.
     *
     * @param number 환자의 등록 번호
     * @return 해당 환자의 정보
     */
    Optional<PatientDTO> readOnePatient(int number) throws SQLException;

    /**
     * 지금까지 등록된 모든 환자 리스트를 반환한다.
     *
     * @return 환자 정보 리스트
     */
    List<PatientDTO> readAllPatients() throws SQLException;

    /**
     * 수정할 환자 정보를 입력받아 수정 성공 시 true, 실패 시 false 를 반환한다.
     *
     * @param patientDTO 수정할 환자 정보
     * @return 수정 성공 시 true, 실패 시 false
     */
    boolean updatePatient(PatientDTO patientDTO) throws SQLException;

    /**
     * 환자 등록 번호를 입력받아서 해당 환자를 삭제한다.
     *
     * @param number 삭제할 환자 등록번호
     * @return 삭제 성공 시 true, 실패 시 false
     */
    boolean deletePatient(int number) throws SQLException;

}
