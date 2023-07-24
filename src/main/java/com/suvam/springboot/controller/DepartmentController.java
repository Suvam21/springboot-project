package com.suvam.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.suvam.springboot.entity.Department;
import com.suvam.springboot.service.DepartmentService;


@RestController
public class DepartmentController {

    @Autowired                                                                      // Injecting the DepartmentService, we dont have to create a new obj since spring handles that for us
    private DepartmentService departmentService;

    // Creating loggers
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    
    @PostMapping("/departments")                                                    // For adding data to the database
    public Department saveDepartment(@Valid @RequestBody Department department) {   //@RequestBody annotation is used to bind the request body with a method parameter.
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")                                                     // For fetching data from the database
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")                                                // For fetching data from the database by id using the curly braces since th value is dynamic
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){   //@PathVariable annotation is used to bind the URI template variables to the method arguments in Spring.
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")                                             // DeleteMapping is used to delete data from the database by id.
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){      //@PathVariable annotation is used to bind the URI template variables to the method arguments in Spring.
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")                                                // For updating data in the database by id
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, 
                                           @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId, department);
    }


    @GetMapping("/departments/name/{name}")                                         // For fetching data from the database by name using the curly braces since th value is dynamic
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    } 
}
