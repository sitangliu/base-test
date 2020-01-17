package com.ijianghu.stream.textFile;

/**
 * @author kai
 * @date 2020/1/17
 * @desc base-test
 **/
public class Employee{
    private String name;
    private double salary;
    private String year;
    private String month;
    private String day;
    private String hireDay;


    public Employee(String name, double salary, String year, String month, String day) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHireDay() {
        return getYear()+"-"+getMonth()+"-"+getDay();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay='" + hireDay + '\'' +
                '}';
    }
}
