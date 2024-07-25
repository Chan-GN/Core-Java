package com.example.main;

import com.example.config.ApplicationFactory;
import com.example.view.PatientView;

public class HospitalMgmtApplication {

    public static void main(String[] args) {
        PatientView patientView = ApplicationFactory.createPatientView();
        patientView.render();
    }

}
