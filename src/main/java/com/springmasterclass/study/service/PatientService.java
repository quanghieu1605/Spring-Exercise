package com.springmasterclass.study.service;

import java.util.List;
import com.springmasterclass.study.dto.record.PatientResponseDTO;
public interface PatientService {
   List<PatientResponseDTO> getPatientsWithNPlusOne(); 
}   
