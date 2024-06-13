package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "list_of_all")
public class ListOfHospitalDepartments {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_department")
    private String name;

    @Column(name = "head")
    private String head;

    @Column(name = "num_of_places")
    private Integer count;

    @Column(name = "price")
    private Integer price;


    @OneToMany(mappedBy="hospital")
    @JsonIgnore
    private List<ListOfIll> items;



}
