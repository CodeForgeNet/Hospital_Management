package com.cfn.main.services;

import com.cfn.main.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    public Patient addPatientDetails(Patient patient);
    public List<Patient> getAllPatient();
    public Optional<Patient> getPatientDetailById(Long id);
    public Patient updatePatientDetails(Long id, Patient patient);
    Patient getPatientByName(String name);

}
