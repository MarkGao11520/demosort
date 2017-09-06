package com.gwf.demo.sort.n2;

/**
 * 插入排序
 * Created by gaowenfeng on 2017/8/31.
 */
public class QuickSort {
    private static void insertSort(Comparable[] source){
        for(int i=1;i<source.length;i++){
            int j = i;
            Comparable a = source[i];
            while (j>0&&a.compareTo(source[j-1])<0){
                source[j] = source[--j];
            }
            source[j]=a;
        }
    }

    public static void main(String[] args) {
        Integer[] source = {5,1,3,7,2,6};
        insertSort(source);
        for(int i=0;i<source.length;i++)
            System.out.print(source[i]+" ");
    }
}
