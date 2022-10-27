package com.payroll.e.litepayroll;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDTO
{
    private @Id Long employeeNumber;
    private String firstNames;
    private String lastName;
    private int salutation;
    private int gender;
    private float grossSalary;
    private int profileColour;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeNumber, String firstNames, String lastName, int salutation, int gender, float grossSalary, int profileColour) {
        this.employeeNumber = employeeNumber;
        this.firstNames = firstNames;
        this.lastName = lastName;
        this.salutation = salutation;
        this.gender = gender;
        this.grossSalary = grossSalary;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(float grossSalary) {
        this.grossSalary = grossSalary;
    }

    public int getProfileColour() {
        return profileColour;
    }

    public void setProfileColour(int profileColour) {
        this.profileColour = profileColour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDTO)) return false;

        EmployeeDTO employeeDTO = (EmployeeDTO) o;

        if (getSalutation() != employeeDTO.getSalutation()) return false;
        if (getGender() != employeeDTO.getGender()) return false;
        if (Float.compare(employeeDTO.getGrossSalary(), getGrossSalary()) != 0) return false;
        if (getProfileColour() != employeeDTO.getProfileColour()) return false;
        if (!getEmployeeNumber().equals(employeeDTO.getEmployeeNumber())) return false;
        if (!getFirstNames().equals(employeeDTO.getFirstNames())) return false;
        return getLastName().equals(employeeDTO.getLastName());
    }

    @Override
    public int hashCode() {
        int result = getEmployeeNumber().hashCode();
        result = 31 * result + getFirstNames().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getSalutation();
        result = 31 * result + getGender();
        result = 31 * result + (getGrossSalary() != +0.0f ? Float.floatToIntBits(getGrossSalary()) : 0);
        result = 31 * result + getProfileColour();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", firstNames='" + firstNames + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salutation=" + salutation +
                ", gender=" + gender +
                ", grossSalary=" + grossSalary +
                ", profileColour=" + profileColour +
                '}';
    }
}