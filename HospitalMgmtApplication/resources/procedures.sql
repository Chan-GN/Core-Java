/*
 * PatientDaoImpl 클래스에서 사용되는 MySQL stored procedures
 */

-- 환자 목록을 반환하는 프로시저
DELIMITER //
CREATE PROCEDURE sp_read_all_patients()
BEGIN
    SELECT number, code, consultation_fee, hospitalization_fee, medical_fee
    FROM patient
    ORDER BY number;
END //
DELIMITER ;

-- 한 환자를 반환하는 프로시저
DELIMITER //
CREATE PROCEDURE sp_read_one_patient(
    IN p_number TINYINT
)
BEGIN
    SELECT *
    FROM patient
    WHERE number = p_number;
END //
DELIMITER ;

-- 환자의 정보를 갱신하는 프로시저
DELIMITER //
CREATE PROCEDURE sp_update_patient(
    IN p_number TINYINT,
    IN p_code CHAR(2),
    IN p_consultation_fee INT,
    IN p_hospitalization_fee INT,
    IN p_medical_fee INT,
    IN p_department VARCHAR(50),
    IN p_length_of_stay INT,
    IN p_age INT,
    OUT p_success BOOLEAN
)
BEGIN
    DECLARE row_count INT;

    -- 환자 정보 업데이트
    UPDATE patient
    SET code                = p_code,
        consultation_fee    = p_consultation_fee,
        hospitalization_fee = p_hospitalization_fee,
        medical_fee         = p_medical_fee,
        department          = p_department,
        length_of_stay      = p_length_of_stay,
        age                 = p_age
    WHERE number = p_number;

    -- 영향받은 행의 수 확인
    SET row_count = ROW_COUNT();

    -- 업데이트 성공 여부 설정
    IF row_count > 0 THEN
        SET p_success = TRUE;
    ELSE
        SET p_success = FALSE;
    END IF;
END //
DELIMITER ;