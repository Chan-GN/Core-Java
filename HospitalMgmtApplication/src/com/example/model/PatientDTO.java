package com.example.model;

public class PatientDTO {

    private final int number; // 번호
    private final MedicalDepartment treatmentCode; // 진료코드
    private final int lengthOfStay; // 입원일수
    private final int age; // 나이
    private int consultationFee; // 진찰비
    private int hospitalizationFee; // 입원비
    private int medicalFee; // 진료비

    public PatientDTO(int number, MedicalDepartment treatmentCode, int lengthOfStay, int age) {
        this.number = number;
        this.treatmentCode = treatmentCode;
        this.lengthOfStay = lengthOfStay;
        this.age = age;
    }

    public MedicalDepartment getTreatmentCode() {
        return treatmentCode;
    }

    public int getConsultationFee() {
        return consultationFee;
    }

    public int getHospitalizationFee() {
        return hospitalizationFee;
    }

    public int getMedicalFee() {
        return medicalFee;
    }

    public int getNumber() {
        return number;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%-9d %-10s %-12d %-11d %-10d",
                number, treatmentCode,
                consultationFee, hospitalizationFee, medicalFee);
    }

    public void updateFees(int consultationFee, int hospitalizationFee, int medicalFee) {
        this.consultationFee = consultationFee;
        this.hospitalizationFee = hospitalizationFee;
        this.medicalFee = medicalFee;
    }

}
