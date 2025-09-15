package com.cfn.main.controllers;

import com.cfn.main.entities.Patient;
import com.cfn.main.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/patient")
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.addPatientDetails(patient);
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    @GetMapping("/patient/id/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Patient patient= patientService.getPatientDetailById(id).orElse(null);
        if(patient != null){
            return ResponseEntity.ok().body(patient);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/patient/{id}")
    public ResponseEntity<Patient> updatePatientDetails(@PathVariable Long id, @RequestBody Patient patient){
        Patient updatedPatient = patientService.updatePatientDetails(id,patient);
        if(updatedPatient != null){
            return ResponseEntity.ok().body(updatedPatient);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/patient/name/{name}")
    public ResponseEntity<Patient> getPatientByName(@PathVariable String name){
        try {
            Patient patient = patientService.getPatientByName(name);
            return ResponseEntity.ok(patient);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
