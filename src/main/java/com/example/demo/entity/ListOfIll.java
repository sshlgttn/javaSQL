package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "list_of_ill")
public class ListOfIll {

@Id
    @Column(name = "vados_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "policy_num")
    private Integer num;

    @Column(name = "department_name")
    private String department_name;

    @Column(name = "day")
    private Integer day;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;

    @Column(name = "patient_info")
    private String patienName;

    @Column(name = "benefit")
    private Integer isBenefit;


    @ManyToOne
    @JoinColumn(name="department_id")
    @JsonIgnore
    private ListOfHospitalDepartments hospital;

}



