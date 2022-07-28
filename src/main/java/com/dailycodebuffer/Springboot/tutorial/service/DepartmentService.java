package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.entity.ResponseObject;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundExceptiom;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentID) throws DepartmentNotFoundExceptiom;

    public  ResponseEntity<ResponseObject> deleteDepartmentById(Long departmentID);

    public Department updateDepartment(Long departmentID, Department department);

    boolean existsById(Long departmentID);


    Department findByDepartmentName(String departmentName);
}
