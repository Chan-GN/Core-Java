package com.example.config;

import com.example.controller.DeleteController;
import com.example.controller.InsertController;
import com.example.controller.SelectController;
import com.example.controller.UpdateController;
import com.example.model.PatientDAO;
import com.example.model.PatientDaoImpl;
import com.example.service.PatientService;
import com.example.view.PatientView;

public class ApplicationFactory {

    public static PatientView createPatientView() {
        PatientDAO patientDAO = new PatientDaoImpl();
        PatientService patientService = new PatientService(patientDAO);
        InsertController insertController = new InsertController(patientService);
        DeleteController deleteController = new DeleteController(patientService);
        SelectController selectController = new SelectController(patientService);
        UpdateController updateController = new UpdateController(patientService);

        return new PatientView(insertController, deleteController, selectController, updateController);
    }

}