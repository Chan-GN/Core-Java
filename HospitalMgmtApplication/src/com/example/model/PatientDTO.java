package com.example.model;

public class PatientDTO {

    private int number; // 번호
    private MedicalDepartment treatmentCode; // 진료코드
    private int lengthOfStay; // 입원일수
    private int age; // 나이
    private int consultationFee; // 진찰비
    private int hospitalizationFee; // 입원비
    private int medicalFee; // 진료비

    public PatientDTO(int number, MedicalDepartment treatmentCode, int lengthOfStay, int age, int consultationFee, int hospitalizationFee, int medicalFee) {
        this.number = number;
        this.treatmentCode = treatmentCode;
        this.lengthOfStay = lengthOfStay;
        this.age = age;
        this.consultationFee = consultationFee;
        this.hospitalizationFee = hospitalizationFee;
        this.medicalFee = medicalFee;
    }

    public PatientDTO(int number, MedicalDepartment treatmentCode, int lengthOfStay, int age) {
        this.number = number;
        this.treatmentCode = treatmentCode;
        this.lengthOfStay = lengthOfStay;
        this.age = age;
    }

    public PatientDTO(int number, MedicalDepartment treatmentCode, int consultationFee, int hospitalizationFee, int medicalFee) {
        this.number = number;
        this.treatmentCode = treatmentCode;
        this.consultationFee = consultationFee;
        this.hospitalizationFee = hospitalizationFee;
        this.medicalFee = medicalFee;
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

    public void setAge(int newAge) {
        this.age = newAge;
    }

    @Override
    public String toString() {
        return String.format("%-9d %-10s %-12d %-11d %-10d",
                number, treatmentCode.getMedicalDepartmentName(),
                consultationFee, hospitalizationFee, medicalFee);
    }

    public void updateFees(int consultationFee, int hospitalizationFee, int medicalFee) {
        this.consultationFee = consultationFee;
        this.hospitalizationFee = hospitalizationFee;
        this.medicalFee = medicalFee;
    }

    public void updateTreatmentCode(MedicalDepartment newDepartment) {
        this.treatmentCode = newDepartment;
    }

    public void updateLengthOfStay(int newDays) {
        this.lengthOfStay = newDays;
    }

}
