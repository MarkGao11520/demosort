package com.gwf.demo.sort.pq;

/**
 * Created by gaowenfeng on 2017/8/27.
 */
public class SelectionSort {
    public void selectionSort(Comparable[] A){
        int i,j,k,n=A.length;
        Comparable temp;
        i = n-1;  //初始时，Q为空，PQ包含A中所有关键字，
                  // 所以PQ中最后一个关键字的索引i就设为n-1，即A中最后一个关键字的索引

        while (i>0){  //当PQ中关键字数量大于1时，标出并将PQ中的最大关键字移到Q中

            j = i;  //j 初始时指向PQ中的最后一个关键字

            for(k=0;k<i;k++){  //扫描0:i-1区间内剩下的危重以找到关键字A[j]
                if(A[k].compareTo(A[j])>0)
                    j = k;
            }

            //交换最大关键字A[j] 与 最后一个关键字A[i]
            temp = A[i]; A[i] = A[j]; A[j] = temp;

            //将PQ与Q的关键字向下移动一个位置
            i -- ;
        }
    }



    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        Integer[] source = {5,3,2,7,1,9};
        selectionSort.selectionSort(source);
        int i=0,n=source.length;
        while (i<n){
            System.out.print(source[i++]+" ");
        }
    }
}
