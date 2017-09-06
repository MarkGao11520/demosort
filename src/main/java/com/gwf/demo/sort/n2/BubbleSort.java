package com.gwf.demo.sort.n2;

/**
 * 冒泡排序
 * Created by gaowenfeng on 2017/8/31.
 */
public class BubbleSort {
    public static void buddleSort(Comparable[] source){
        for(int i=0;i<source.length;i++){
            for(int j=i+1;j<source.length;j++){
                if(source[i].compareTo(source[j])>0){
                    Comparable temp = source[i];
                    source[i]=source[j];
                    source[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] source = {1,5,3,7,2,6};
        buddleSort(source);
        for(int i=0;i<source.length;i++)
            System.out.print(source[i]+" ");
    }
}
