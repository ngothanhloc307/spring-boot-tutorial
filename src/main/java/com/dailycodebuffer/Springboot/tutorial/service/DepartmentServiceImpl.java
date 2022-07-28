package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.entity.ResponseObject;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundExceptiom;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentID) throws DepartmentNotFoundExceptiom {
        Optional<Department> foundDepartment = departmentRepository.findById(departmentID);
        if(!foundDepartment.isPresent()){
            throw new DepartmentNotFoundExceptiom("Department not Available");
        }
        return foundDepartment.get();
    }

    @Override
    public ResponseEntity<ResponseObject> deleteDepartmentById(Long departmentID) {
        boolean exists = departmentRepository.existsById(departmentID);
        if(exists) {
            departmentRepository.deleteById(departmentID);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Department successfully", "")
            );

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Can't find Department to delete", "")
        );

    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) {
        Department depDB = departmentRepository.findById(departmentID).get();
        if(depDB.getDepartmentId() == departmentID){
            if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
                depDB.setDepartmentName(department.getDepartmentName());
            }

            if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
                depDB.setDepartmentCode(department.getDepartmentCode());
            }

            if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
                depDB.setDepartmentAddress(department.getDepartmentAddress());
            }
        }else{
            System.out.println("Not found Department ID" + departmentID);
        }


        return departmentRepository.save(depDB);
    }

    @Override
    public boolean existsById(Long departmentID) {
        return departmentRepository.existsById(departmentID);
    }

//    @Override
//    public List<Department> findByDepartmentName(String departmentName) {
//        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
//    }

    @Override
    public Department findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
