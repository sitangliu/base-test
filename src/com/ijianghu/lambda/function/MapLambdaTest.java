package com.ijianghu.lambda.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2019/10/16
 * @desc base-test
 **/
public class MapLambdaTest {

    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400);
        ArrayList<Double> beforeCost = new ArrayList<>();
        costBeforeTax.stream().map((cost)->cost+.12*cost).forEach((cost)->beforeCost.add(cost));
        Integer bill = costBeforeTax.stream().reduce((sum, cost) -> sum + cost).get();
        System.out.println(bill);
        beforeCost.stream().forEach((cost)-> System.out.println(cost));
    }
}
