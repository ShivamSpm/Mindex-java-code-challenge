package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Compensation {
    private Employee employee;
    private double salary;
    private Date effectiveDate;

    @JsonCreator
    public Compensation(){
    }

    @JsonCreator
    public Compensation(@JsonProperty("employee") Employee employee, @JsonProperty("salary") double salary, @JsonProperty("effectiveDate") Date effectiveDate){
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public Employee getEmployee(){
        System.err.println("bakchod"+this.employee);
        return this.employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

}
