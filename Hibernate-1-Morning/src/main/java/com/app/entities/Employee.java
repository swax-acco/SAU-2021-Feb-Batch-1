package com.app.entities;
import javax.persistence.*;

@Entity
@Table(name="employee_table")
public class Employee {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer Id;

    @Column (name = "fname")
    private String fname;

    @Column (name = "lname")
    private String lname;

    @Column (name = "age")
    private Integer age = 23;

    @Column (name = "dob")
    private String dob;

    @Column (name = "salary")
    private Integer salary = 13000;

    @Column (name = "designation")
    private String designation;

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return String.valueOf(this.Id) + " " + this.fname + " " + this.lname + " " + String.valueOf(this.salary);
    }
    
}

