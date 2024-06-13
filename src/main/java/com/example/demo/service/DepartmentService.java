package com.example.demo.service;


import com.example.demo.entity.ListOfHospitalDepartments;
import com.example.demo.entity.ListOfIll;
import com.example.demo.repository.HospitalDepartmentRepository;
import com.example.demo.repository.IllRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    HospitalDepartmentRepository  hospitalDepartmentRepository;
    IllRepository illRepository;

    public DepartmentService(HospitalDepartmentRepository hospitalDepartmentRepository, IllRepository illRepository) {
        this.illRepository = illRepository;
        this.hospitalDepartmentRepository = hospitalDepartmentRepository;

    }

    public List<ListOfHospitalDepartments> getDepartment() {
        return hospitalDepartmentRepository.getAllHospitalDepartments();
    }

    public List<ListOfHospitalDepartments> getRichDepartment() { //XD
        return hospitalDepartmentRepository.getExpenciveDepartment();
    }

    public List<ListOfIll> getDepartmentsIll(Long id){
        ListOfHospitalDepartments listOfHospitalDepartments = hospitalDepartmentRepository.getById(id);
        return  listOfHospitalDepartments.getItems();
    }

    public List<ListOfHospitalDepartments> getBigDepartments() {
        List<ListOfHospitalDepartments> departments = hospitalDepartmentRepository.getAllHospitalDepartments();
        List<ListOfHospitalDepartments> bigDepartments = new ArrayList<ListOfHospitalDepartments>();
        for (ListOfHospitalDepartments department : departments) {
            if (department.getItems().size() > 10) {
                bigDepartments.add(department);
            }
        }
        return bigDepartments;
    }









}
