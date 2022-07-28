package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.entity.ResponseObject;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundExceptiom;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    ResponseEntity<ResponseObject>  saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
//        Department foundDepartment = departmentService.findByDepartmentName(department.getDepartmentName());
//        if(foundDepartment.getDepartmentName().equalsIgnoreCase(department.getDepartmentName())) {
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//              new ResponseObject("failed", "Department name already taken", "")
//            );
//        }
        return ResponseEntity.status(HttpStatus.OK).body(
          new ResponseObject("ok",  "Insert Department Successfully",departmentService.saveDepartment(department))
        );
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    Department fetchDepartmentById(@PathVariable("id") Long departmentID) throws DepartmentNotFoundExceptiom {
        return departmentService.fetchDepartmentById(departmentID);
    }
    @DeleteMapping("/departments/{id}")
    ResponseEntity<ResponseObject>  deleteDepartmentById(@PathVariable("id") Long departmentID){
        return departmentService.deleteDepartmentById(departmentID);
    }

    @PutMapping("/departments/{id}")
    ResponseEntity<ResponseObject> updateDepartment(@PathVariable("id") Long departmentID, @RequestBody Department department){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update Department successfully", departmentService.updateDepartment(departmentID, department))
        );
    }

//    @GetMapping("/departments/name/{name}")
//    ResponseEntity<ResponseObject> findByDepartmentName(@PathVariable("name") String departmentName){
//        List<Department> foundDepartment = departmentService.findByDepartmentName(departmentName);
//        if(foundDepartment.size() > 0) {
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("ok", "Find Department Name = "+ departmentName, foundDepartment)
//            );
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                new ResponseObject("failed", "Not found Department Name = "+ departmentName, "")
//        );
//    }

    @GetMapping("/departments/name/{name}")
    Department findByDepartmentName(@PathVariable("name") String departmentName){
        return departmentService.findByDepartmentName(departmentName);
    }
}
