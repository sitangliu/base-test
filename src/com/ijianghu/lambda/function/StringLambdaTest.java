package com.ijianghu.lambda.function;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kai
 * @date 2019/10/16
 * @desc base-test
 **/
public class StringLambdaTest{

    public static void main(String[] args) {
        /**
         * 对元素进行过滤
         */
        List<String> strList = Arrays.asList("abc", "bcd", "cde", "ef", "fh");
        List<String> filtered = strList.stream().filter((x) -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List: %s,filtered list : %s %n",strList,filtered);

        /**
         * 对列表的每个元素应用函数
         */
        List<String> nameList = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "China");
        String collect = nameList.stream().map((name) -> name.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(collect);

        /**
         * 对元素进行去重
         */
        List<Integer> integerList = Arrays.asList(1, 3, 2, 4, 5, 6, 4, 2, 7, 4, 2, 8, 9, 3);
        List<Integer> integers = integerList.stream().distinct().collect(Collectors.toList());
        System.out.printf("Original List %s,distincted list : %s %n",integerList,integers);

        /**
         * 计算集合元素的最大值、最小值、总和以及平均值
         */
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 18, 23, 29);
        IntSummaryStatistics statistics = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List :"+statistics.getMax());
        System.out.println("Lowest prime number in List :"+statistics.getMin());
        System.out.println("Sum prime number in List :"+statistics.getSum());
        System.out.println("Average prime number in List :"+statistics.getAverage());
        System.out.println("Count prime number in List :"+statistics.getCount());


    }
}
