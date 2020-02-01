package com.ijianghu.param;

/**
 * Created by 24596 on 2020/2/1.
 * 方法参数传递
 */
public class ParamTest {

    public static void main(String[] args) {

        /**
         *Test 1:Methods can't modify numeric parameters
         */
        System.out.println("Testing tripValue");
        double percent = 10;
        System.out.println("Before:percent="+percent);
        tripValue(percent);
        System.out.println("After:percent="+percent);

        /**
         * Test 2:Methods can change the state of object parameters
         */
        System.out.println("\nTesting tripSalary");
        Employee liukai = new Employee("liukai", 15000);
        System.out.println("Before:salary="+liukai.getSalary()+":"+liukai);
        tripleSalary(liukai);
        System.out.println("After:salary="+liukai.getSalary()+":"+liukai);

        /**
         * Test 3:Methods can't attach new object to object parameters
         */
        System.out.println("\nTesting swap");
        Employee a = new Employee("Alice", 7000);
        Employee b = new Employee("Bob", 6000);
        System.out.println("Before:a="+a.getName()+":"+a);
        System.out.println("Before:b="+b.getName()+":"+b);
        swap(a,b);
        System.out.println("After:a="+a.getName()+":"+a);
        System.out.println("After:b="+b.getName()+":"+b);


    }

    private static void swap(Employee a, Employee b) {
        Employee temp = a;
        a = b;
        b = temp;
        System.out.println("End of method:a="+a.getName()+":"+a);
        System.out.println("End of method:b="+b.getName()+":"+b);

    }

    private static void tripleSalary(Employee employee) {
        employee.raiseSalary(30);
        System.out.println("End of method:salary="+employee.getSalary()+":"+employee);
    }

    private static void tripValue(double x) {
        x = 3*x;
        System.out.println("End of method:x="+x);
    }

}
class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
