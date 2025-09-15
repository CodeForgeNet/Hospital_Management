package com.cfn.main.services;

import com.cfn.main.entities.Patient;
import com.cfn.main.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatientDetails(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientDetailById(Long id) {
        return patientRepository.findById(id);
    }


    @Override
    public Patient updatePatientDetails(Long id, Patient newPatient) {
        Patient patient1 = patientRepository.findById(id).orElse(null);
        if(patient1 != null){
            return patientRepository.save(newPatient);
        }else{
            throw new RuntimeException("Use not found with id:"+id);
        }
    }

    @Override
    public Patient getPatientByName(String name) {
        return patientRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("Patient not found with name:"+name));
    }


}
