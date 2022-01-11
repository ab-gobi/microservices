package com.gobiab.departmentservice.service;

import com.gobiab.departmentservice.entity.Department;
import com.gobiab.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside Service Department Save");
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        log.info("Inside Service Department Get");
        return departmentRepository.findByDepartmentId(id);
    }
}
