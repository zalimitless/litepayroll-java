package com.payroll.e.litepayroll.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeBasicDTO {
    private @Id Long employeeNumber;
    private String firstNames;
    private String lastName;
    private int salutation;
    private int profileColour;

    public EmployeeBasicDTO(){}

    public EmployeeBasicDTO(Long employeeNumber, String firstNames, String lastName, int salutation, int profileColour) {
        this.employeeNumber = employeeNumber;
        this.firstNames = firstNames;
        this.lastName = lastName;
        this.salutation = salutation;
        this.profileColour = profileColour;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalutation() {
        return salutation;
    }

    public void setSalutation(int salutation) {
        this.salutation = salutation;
    }

    public int getProfileColour() {
        return profileColour;
    }

    public void setProfileColour(int profileColour) {
        this.profileColour = profileColour;
    }
}
