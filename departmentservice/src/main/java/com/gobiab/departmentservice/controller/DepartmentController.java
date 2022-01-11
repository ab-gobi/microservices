package com.gobiab.departmentservice.controller;

import com.gobiab.departmentservice.entity.Department;
import com.gobiab.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/")
    public Department save(@RequestBody Department department){
        log.info("Inside controller Department Save");
        return departmentService.saveDepartment(department);
    }

    @RequestMapping("/{id}")
    public Department getDepartment(@PathVariable Long id){
        log.info("Inside controller Department Get");
        return departmentService.getDepartment(id);
    }
}
