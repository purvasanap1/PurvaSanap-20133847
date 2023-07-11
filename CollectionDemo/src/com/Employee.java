package com;

 

import java.util.List;

 

public class Employee{


     private int empid;

     private String empName;

     private List<String> programming;




    public List<String> getProgramming() {

        return programming;

    }

    public void setProgramming(List<String> programming) {

        this.programming = programming;

    }

    public int getempid() {

        return empid;

    }

    public void setempid(int empid) {

        this.empid = empid;

    }

    public String getempName() {

        return empName;

    }

    public void setempName(String empName) {

        this.empName = empName;

    }


     @Override

        public String toString() {

            return "Employee::empid = " + empid + ", empName = " + empName + ", programming=" + programming ;

        }

 

}