package com.example.demo.repository;


import com.example.demo.entity.ListOfHospitalDepartments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalDepartmentRepository extends JpaRepository<ListOfHospitalDepartments, Long> {

    @Query("select hlo from ListOfHospitalDepartments hlo")
    List<ListOfHospitalDepartments> getAllHospitalDepartments();

    @Query("select hlo from ListOfHospitalDepartments hlo where hlo.price > 3000")
    List<ListOfHospitalDepartments> getExpenciveDepartment();

    @Query("select hlo from ListOfHospitalDepartments hlo where hlo.id =?1")
    ListOfHospitalDepartments getById(long Id);



}
