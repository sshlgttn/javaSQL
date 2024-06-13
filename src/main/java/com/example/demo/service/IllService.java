package com.example.demo.service;


import com.example.demo.entity.ListOfHospitalDepartments;
import com.example.demo.entity.ListOfIll;
import com.example.demo.repository.HospitalDepartmentRepository;
import com.example.demo.repository.IllRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class IllService {

    HospitalDepartmentRepository hprepo;
    IllRepository illRepository;

    public IllService(IllRepository illRepository, HospitalDepartmentRepository hprepo) {
        this.illRepository = illRepository;
        this.hprepo = hprepo;
    }

    public List<ListOfIll> getIll() {
        return illRepository.getAllIll();
    }


    public List<String> getAllClientNames() {
        List<String> illNames = new ArrayList<>();
        for (ListOfIll ill : getIll()) {
            illNames.add(ill.getPatienName());
        }
        return illNames;
    }

    public List<ListOfIll> getByBenefitAndYear(){
        return illRepository.getIllByBenefitAndYear();
    }

    public ListOfHospitalDepartments getDepartmentByIllId(long id) {
        ListOfIll listOfIll = illRepository.getById(id);
        return listOfIll.getHospital();
    }

    public List<ListOfIll> getRichIlls() {
        List<ListOfHospitalDepartments> departments = hprepo.getAllHospitalDepartments();
        List<ListOfHospitalDepartments> richDepartments = new ArrayList<ListOfHospitalDepartments>();
        List<ListOfIll> richIlls =  new ArrayList<ListOfIll>();
        for (ListOfHospitalDepartments department : departments) {
            if (department.getPrice() > 5000) {
                richDepartments.add(department);
            }
        }
        for (ListOfHospitalDepartments department: richDepartments) {
            richIlls.addAll(department.getItems());
        }
        return richIlls;

    }
}


