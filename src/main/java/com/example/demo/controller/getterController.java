package com.example.demo.controller;

import com.example.demo.entity.ListOfHospitalDepartments;
import com.example.demo.entity.ListOfIll;
import com.example.demo.repository.HospitalDepartmentRepository;
import com.example.demo.repository.IllRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.IllService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class getterController {
    DepartmentService departmentService;
    IllService illService;

    public getterController(DepartmentService departmentService, IllService illService) {
        this.departmentService = departmentService;
        this.illService = illService;
    }

    @GetMapping("/departments/all")
    public ResponseEntity<List<ListOfHospitalDepartments>> getAllDepartments() {
        List<ListOfHospitalDepartments> departments = departmentService.getDepartment();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/ills/all")
    public ResponseEntity<List<ListOfIll>> getAllIlls() {
        List<ListOfIll> ills = illService.getIll();
        return  ResponseEntity.ok(ills);
    }

    @GetMapping("/ills/names")
    public ResponseEntity<List<String>> getAllIllsNames() {
        List<String> ills = illService.getAllClientNames();
        return ResponseEntity.ok(ills);
    }

    @GetMapping("/departments/bigDepartments")
    public ResponseEntity<List<ListOfHospitalDepartments>> getRichDepartment() {
        List<ListOfHospitalDepartments> bigDepartments = departmentService.getRichDepartment();
        return ResponseEntity.ok(bigDepartments);
    }

    @GetMapping("/ills/benefit")
    public ResponseEntity<List<ListOfIll>> getByBenefitAndYear() {
        List<ListOfIll> ills = illService.getByBenefitAndYear();
        return ResponseEntity.ok(ills);
    }

    @GetMapping("/ills/illsByDepartmentsId/{id}")
    public ResponseEntity<List<ListOfIll>> illsByIdDepartments(@PathVariable Long id) {
        List<ListOfIll> ills = departmentService.getDepartmentsIll(id);
        return  ResponseEntity.ok(ills);
    }

    @GetMapping("/departments/departmentsByIllsId/{id}")
    public ResponseEntity<ListOfHospitalDepartments> getDepartmentsByIllsId(@PathVariable Long id) {
        ListOfHospitalDepartments departments = illService.getDepartmentByIllId(id);
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/departments/big")
    public ResponseEntity<List<ListOfHospitalDepartments>> getBigDepartments() {
        List<ListOfHospitalDepartments> bigDepartments = departmentService.getBigDepartments();
        return ResponseEntity.ok(bigDepartments);
    }

        @GetMapping("ills/richIlls")
    public ResponseEntity<List<ListOfIll>> getRichIlls() {
        List<ListOfIll> ills = illService.getRichIlls();
        return ResponseEntity.ok(ills);
    }
}
