package com.ijianghu.lambda.compartor;

/**
 * @author kai
 * @date 2019/10/15
 * @desc base-test
 **/
public class Student implements Comparable{

    private String name;

    private int age;

    private String hobbies;

    private int averageScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int compareTo(Object stu ) {
        return this.getAverageScore()-((Student)stu).getAverageScore();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies='" + hobbies + '\'' +
                ", averageScore=" + averageScore +
                '}';
    }
}
