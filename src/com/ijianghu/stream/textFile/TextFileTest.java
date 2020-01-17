package com.ijianghu.stream.textFile;

import java.io.PrintWriter;

/**
 * @author kai
 * @date 2020/1/17
 * @desc base-test
 **/
public class TextFileTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("liu kai",30000.00,"2019","11","15");
        staff[1] = new Employee("永 志",31000.00,"2018","10","18");
        staff[2] = new Employee("cui xu",32000.00,"2018","7","15");

        //save all employee records to the file employee.text
        try(PrintWriter out = new PrintWriter("employee.dat","UTF-8")){
            writerData(out,staff);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void writerData(PrintWriter out, Employee[] staff) {
        for(int i = 0;i<staff.length;i++){
            writeEmployee(out,staff[i]);

        }
    }

    private static void writeEmployee(PrintWriter out, Employee staff) {

    }


}
