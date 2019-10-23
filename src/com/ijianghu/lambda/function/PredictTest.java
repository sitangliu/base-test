package com.ijianghu.lambda.function;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author kai
 * @date 2019/10/16
 * @desc base-test
 **/
public class PredictTest{

    public static void main(String[] args) {

        List languages = Arrays.asList("JavaEE", "Scala", "C++", "Haskell", "Lisp","JavaSE");
        System.out.println("Language which starts with J");
        filter(languages,(str)->str.startsWith("J"));

        System.out.println("Language which ends with a");
        filter(languages,(str)->str.endsWith("a"));

        System.out.println("Print all languages");
        filter(languages,(str)->true);

        System.out.println("Print no languages");
        filter(languages,(str)->false);

        System.out.println("Print language whose length greater than 4");
        filter(languages,(str)->str.length()>4);

        filter2(languages);

    }

/*    public static void filter(List<String> names, Predicate condition){
        for (String name: names) {
            if(condition.test(name)){
                System.out.println(name+" ");
            }
        }
    }*/

    public static void filter(List<String> names,Predicate<String> condition){
        names.stream().filter((name)->(condition.test(name))).forEach((name)->{
            System.out.println(name+"");
        });
    }

    public static void filter2(List<String> names){
        Predicate predict = (n) -> ((String) n).startsWith("J");
        Predicate predict2 = (n) -> ((String) n).length()>4;
        names.stream().filter(predict.and(predict2)).forEach( (n)-> System.out.println("nName,which starts with J and letter length >4 :"+n));
    }
}
