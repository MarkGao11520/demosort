package com.gwf.demo.sort.n2;

import javax.swing.*;

/**
 * 选择排序
 * Created by gaowenfeng on 2017/8/31.
 */
public class ChoiceSort {
    public static void choiceSort(Comparable[] source){
        for(int i=0;i<source.length;i++){
            int min = i;
            for(int j=i;j<source.length;j++){
                if(source[j].compareTo(source[min])<0)
                    min = j;
            }
            Comparable temp = source[i];
            source[i] = source[min];
            source[min] = temp;
        }

    }

    public static void main(String[] args) {
        Integer[] source = {5,1,3,7,2,6};
        choiceSort(source);
        for(int i=0;i<source.length;i++)
            System.out.print(source[i]+" ");
    }
}
