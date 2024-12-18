package com.example.demo.service;

import com.example.demo.model.EmpsModel;
import com.example.demo.repo.EmpsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmpsService {
     @Autowired
    private  EmpsRepo empsRepo;
     public List<EmpsModel> getAllEmps()
     {
         return empsRepo.findAll();
     }
     public Optional<EmpsModel> getEmployeeById(int id)
     {
         return empsRepo.findById(id);
//        EmpsModel employee = empsRepo.findById(id).get();
//        if(employee == null)throw new RuntimeException("No employee found with id "+id);
//         return employee;
     }
     public EmpsModel createEmpsRecord(EmpsModel employee)
     {
         return empsRepo.save(employee);
     }
     public EmpsModel updateEmpsRecord(int id,EmpsModel employee)
     {
         if(empsRepo.existsById(id))
         {
             employee.setEmp_id(id);
             return empsRepo.save(employee);
         }
         else throw new IllegalArgumentException("Employee with id "+id+" not found");
     }
     public String deleteEmpsRecord(int id)
     {
         if(empsRepo.existsById(id))
         {
             empsRepo.deleteById(id);
             return "Deleted employee with id "+id;
         }
         return "Employee with id "+id+" not found";


     }



}
