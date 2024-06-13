package com.example.demo.repository;

import com.example.demo.entity.ListOfHospitalDepartments;
import com.example.demo.entity.ListOfIll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IllRepository extends JpaRepository<ListOfIll, Long> {

    @Query("select hlo from ListOfIll hlo")
    List<ListOfIll> getAllIll();

    @Query("select hlo from ListOfIll hlo where hlo.isBenefit >= 2000 and hlo.year = 2022")
    List<ListOfIll> getIllByBenefitAndYear();

    @Query("select hlo from ListOfIll hlo where hlo.id =?1")
    ListOfIll getById(long Id);


}
