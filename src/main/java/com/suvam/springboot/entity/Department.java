package com.suvam.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Department {

    public Department() {
        // Default Constructor
    }

    @Id                                                                                                               // @Id annotation is used to define the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)                                                                   // @GeneratedValue annotation is used to define the primary key generation strategy
    private int departmentId;

    @NotBlank(message = "Department name is mandatory")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    //Constructor
    public Department(int departmentId, String departmentName, String departmentCode, String departmentAddress) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.departmentAddress = departmentAddress;
    }

    //Getters and Setters
    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentCode() {
        return departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public String getDepartmentAddress() {
        return departmentAddress;
    }
    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    //toString
    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentCode="
                + departmentCode + ", departmentAddress=" + departmentAddress + "]";
    }
}
