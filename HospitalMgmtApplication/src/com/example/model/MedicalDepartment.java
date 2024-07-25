package com.example.model;

public enum MedicalDepartment {
    MI("외과"),
    NI("내과"),
    SI("피부과"),
    TI("소아과"),
    VI("산부인과"),
    WI("비뇨기과");

    private final String medicalDepartmentName;

    MedicalDepartment(String medicalDepartmentName) {
        this.medicalDepartmentName = medicalDepartmentName;
    }

    public String getMedicalDepartmentName() {
        return medicalDepartmentName;
    }
}
