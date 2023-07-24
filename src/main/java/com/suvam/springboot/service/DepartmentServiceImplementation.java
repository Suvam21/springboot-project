package com.suvam.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suvam.springboot.entity.Department;
import com.suvam.springboot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Adding data to database
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);                                                   // save() method is used to save the data to the database
    }

    // Fetching data from database
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();                                                          // findAll() method is used to fetch all the data from the database
    }

    // Fetching data from database by id
    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();                                       // findById() method is used to fetch data from the database by id
    }

    // Deleting data from database by id
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);                                                  // deleteById() method is used to delete data from the database by id
    }

    // Updating data in database by id
    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        // Checking for null values
        if (department.getDepartmentName() != null && !department.getDepartmentName().isEmpty()) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (department.getDepartmentCode() != null && !department.getDepartmentCode().isEmpty()) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (department.getDepartmentAddress() != null && !department.getDepartmentAddress().isEmpty()) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB); 
    }

    // Fetching data from database by name
    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName); // findByDepartmentNameIgnoreCase() method is used to fetch data from the database by name
    }

}
