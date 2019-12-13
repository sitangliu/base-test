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

    private Integer heapLength;


    /**
     * 构造函数
     * @param numArr
     */
    public SiLongHeap (Integer[] numArr){
       Arrays.sort(numArr,new MyCompare());
       numberAyy = numArr;
       this.heapLength = numberAyy.length;
    }

    /**
     * 获取堆数组
     * @return
     */
    public Integer[] getHeapArr(){
        return numberAyy;
    }

    /**
     * 获取堆顶数据值
     * @return
     */
    public Integer peek(){

        Integer result = numberAyy[0];
        //调换尾部节点和头部节点
        numberAyy[0] = numberAyy[numberAyy.length-1];
        Integer[] tempArr = Arrays.copyOf(numberAyy, numberAyy.length - 1);
        numberAyy = tempArr;
        heapLength--;
        //对堆进行堆化排序
        double level = Math.floor(Math.log(tempArr.length)/Math.log(2));
        Integer changeIndex = 0;
        for(int i = 0;i<level;i++){
            changeIndex = shiftDown(numberAyy, changeIndex);
            if(changeIndex == heapLength)
                break;
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
        int changeIndex = heapLength;
        int leftIndex = getLeftIndex(index);
        int rightIndex = getRightIndex(index);
        int temp = numberAyy[index];
        //越界检查
        if(leftIndex>heapLength-1 && rightIndex > heapLength-1) return heapLength;

        if(leftIndex <= heapLength -1 && rightIndex > heapLength -1 && numberAyy[leftIndex]>numberAyy[index]){
            numberAyy[index] = numberAyy[leftIndex];
            numberAyy[leftIndex] = temp;
            changeIndex = leftIndex;
        }else if(leftIndex <= heapLength -1 && rightIndex < heapLength -1 && ( numberAyy[leftIndex]>numberAyy[index] || numberAyy[rightIndex]>numberAyy[index])){
            //对数据进行性能优化
            if(numberAyy[index] > numberAyy[leftIndex] && numberAyy[index] > numberAyy[rightIndex])
                return heapLength;
            if(numberAyy[leftIndex] > numberAyy[rightIndex]){
                numberAyy[index] = numberAyy[leftIndex];
                numberAyy[leftIndex] = temp;
                changeIndex = leftIndex;
            }else{
                numberAyy[index] = numberAyy[rightIndex];
                numberAyy[rightIndex] = temp;
                changeIndex = rightIndex;
            }
        }
        this.numberAyy = numberAyy;
        return changeIndex;
    }

    /**
     * 插入值
     * @param value
     * @return
     */
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

    /**
     * 移除某个位置上的数据
     * @param index
     * @return
     */
    public Integer reomve(Integer index){
        Integer temp = numberAyy[heapLength-1];
        numberAyy[heapLength-1] = numberAyy[index];
        numberAyy[index] = temp;
        heapLength--;
        Integer result = removeLast();
        //对对应位置上的点进行排序
        Integer parentIndex = getParentIndex(index);
        if(numberAyy[index]>numberAyy[parentIndex]){
            double heapLevel = getHeapLevel(index);
            for(int i = 0;i<heapLevel;i++){
               shiftUp(numberAyy, index);
            }
        }else{
            int changeIndex = index;
            double heapLevel = getHeapLevel(null);
            double heapLevelRepresent = getHeapLevel(index);
            double cycleHeapLevel = heapLevel - heapLevelRepresent;
            for(int i = 0;i<cycleHeapLevel;i++){
                Integer shiftDown = shiftDown(numberAyy, changeIndex);
                changeIndex = shiftDown;
            }
        }

        return result;
    }

    public Integer removeLast(){
        Integer result = numberAyy[heapLength-1];
        Integer[] tempArr = Arrays.copyOf(numberAyy, heapLength - 1);
        numberAyy  = tempArr;
        return result;

    }

    private Integer getParentIndex(Integer index){
        Integer parentIndex = (index - 1) / 2;
        return parentIndex;
    }

    private Integer getLeftIndex(Integer index){
        Integer leftIndex = 2*index+1;
        return leftIndex;
    }

    private Integer getRightIndex(Integer index){
        Integer righIndex = 2*index+2;
        return righIndex;
    }

    private double getHeapLevel(Integer index){
        double level = 0.0;
        if(null == index){
            level = Math.floor(Math.log(heapLength)/Math.log(2));
        }else{
            level = Math.floor(Math.log(index+1)/Math.log(2));
        }

        return level;
    }

    class MyCompare implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {

            return o1>o2?-1:(o1 == o2?0:1);
        }
    }

}
