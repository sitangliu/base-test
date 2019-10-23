package com.ijianghu.lambda.compartor;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author kai
 * @date 2019/10/15
 * @desc base-test
 **/
public class StudentTest {



    public static void main(String[] args) {
        Set<Student> studentSet = new TreeSet<Student>();
        String[] firstName = new String[]{"赵","钱","孙","李","周","吴","郑","王"};
        String[] secondName = new String[]{"帝","高","阳","之","苗","裔","兮","朕","皇","考","曰","伯","庸"};
        Student student = null;
        for(int i = 0;i<50;i++){
              String name = firstName[new Random().nextInt(7)];
              boolean isThree = new Random().nextBoolean();
              if(isThree){
                 name =  name +secondName[new Random().nextInt(12)]+secondName[new Random().nextInt(12)];
              }else{
                  name =  name +secondName[new Random().nextInt(12)];
              }
              int age = new Random().nextInt(15);
              int averageScore = new Random().nextInt(100);
              student = new Student();
              student.setAge(age);
              student.setName(name);
              student.setAverageScore(averageScore);
              studentSet.add(student);

        }

        for (Student stu: studentSet) {
            System.out.println(stu.toString());
        }

    }

}
