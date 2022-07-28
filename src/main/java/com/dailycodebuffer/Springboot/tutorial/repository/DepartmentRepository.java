package com.dailycodebuffer.Springboot.tutorial.repository;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByDepartmentName(String departmentName);

//    List<Department> findByDepartmentNameIgnoreCase(String departmentName);

    Department findByDepartmentNameIgnoreCase(String departmentName);
}
