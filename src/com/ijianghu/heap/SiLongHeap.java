package com.ijianghu.heap;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kai
 * @date 2019/12/12
 * @desc base-test
 **/
public class SiLongHeap {

    private Integer[] numberAyy;

    public SiLongHeap (Integer[] numArr){
       Arrays.sort(numArr,new MyCompare());
       numberAyy = numArr;
    }

    /**
     * 获取堆数组
     * @return
     */
    public Integer[] getHeapArr(){
        return numberAyy;
    }

    public Integer peek(){

        Integer result = numberAyy[0];

        //调换尾部节点和头部节点
        numberAyy[0] = numberAyy[numberAyy.length-1];
        Integer[] tempArr = Arrays.copyOf(numberAyy, numberAyy.length - 1);
        numberAyy = tempArr;
        //对堆进行堆化排序
        double level = Math.floor(Math.log(tempArr.length)/Math.log(2));
        Integer changeIndex = 0;
        for(int i = 0;i<level;i++){
            int leftIndex = changeIndex*2+1;
            int rightIndex = changeIndex*2+2;
            //对数组 进行越界检查
            if(leftIndex>numberAyy.length-1 || rightIndex > numberAyy.length-1){
                break;
            }
            changeIndex = shiftDown(numberAyy, changeIndex);
            if(numberAyy[leftIndex]<numberAyy[changeIndex] && numberAyy[rightIndex]<numberAyy[changeIndex]){
                break;
            }
        }
        return result;
    }

    /**
     * 上旋
     * @param numberAyy
     * @param index
     * @return
     */
    public Integer shiftUp(Integer[] numberAyy,Integer index){
        int changeIndex;
        Integer parentIndex = (index-2)/2;
        if(parentIndex<0){
            return index;
        }else{
            Integer temp = numberAyy[index];
            numberAyy[index] = numberAyy[parentIndex];
            numberAyy[parentIndex] = temp;
            changeIndex = parentIndex;
        }
        this.numberAyy = numberAyy;
        return changeIndex;
    }

    /**
     * 堆化
     * @param numberAyy
     * @param index
     * @return
     */
    public Integer shiftDown(Integer[] numberAyy,Integer index){
        int changeIndex;
        int leftIndex = index*2+1;
        int rightIndex = index*2+2;
        int temp = numberAyy[index];
        if(numberAyy[leftIndex] > numberAyy[rightIndex]){
            numberAyy[index] = numberAyy[leftIndex];
            numberAyy[leftIndex] = temp;
            changeIndex = leftIndex;
        }else{
            numberAyy[index] = numberAyy[rightIndex];
            numberAyy[rightIndex] = temp;
            changeIndex = rightIndex;
        }
        return changeIndex;
    }

    public Integer[] insert(Integer value){
        Integer[] tempArr = Arrays.copyOf(numberAyy, numberAyy.length + 1);
        tempArr[tempArr.length-1] = value;
        numberAyy = tempArr;
        //对堆数组进行上旋
        double level = Math.floor(Math.log(tempArr.length)/Math.log(2));
        Integer changeIndex = numberAyy.length-1;
        for(int i=0;i<level;i++){
            changeIndex = shiftUp(numberAyy, changeIndex);

        }
        return numberAyy;
    }

    class MyCompare implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {

            return o1>o2?-1:(o1 == o2?0:1);
        }
    }

}
