package com.gwf.demo.sort.divide;

import com.gwf.demo.sort.pq.HeapSort;

import java.util.Arrays;

/**
 * Created by gaowenfeng on 2017/8/27.
 */
public class MergeSort {
    /**
     * 合并排序
     * @param A 需要排序的数组
     * @param m 其实排序元素下标
     * @param n 终止排序元素下标
     */
    private void mergeSort(Comparable[] A,int m,int n){
        Comparable temp;
        if(n<m)
            throw new IllegalArgumentException("起始下标不能小于终止下标1");
        if(n>m){
            //1.讲A[m:n]划分成两个子数组A[m:i]与A[j:n]
            int i = m+(n-m)/2;
            int j = i+1;
            Comparable[] A1 = Arrays.copyOfRange(A,m,j);
            Comparable[] A2 = Arrays.copyOfRange(A,j,n+1);
            //2.对A[m:i]进行排序
            mergeSort(A1,0,A1.length-1);
            //3.对A[j:n]进行排序
            mergeSort(A2,0,A2.length-1);
            //将两个已排序子数组进行合并
            Comparable[] A_ = merge(A1,A2);
            System.arraycopy(A_,0,A,m,n-m+1);
        }
    }

    /**
     * 合并数组
     * @param A1
     * @param A2
     * @return
     */
    private Comparable[] merge(Comparable[] A1,Comparable[] A2){
        int i=0,j=0,k=0,n1= A1.length,n2 = A2.length;
        Comparable[] A = new Comparable[n1+n2];
        while (k<n1+n2){
            if(A1[i].compareTo(A2[j])<0){
                A[k++] = A1[i++];
                if(i==n1){
                    if(j<n2){
                        for(;j<n2;j++)
                            A[k++]=A2[j++];
                    }
                    break;
                }
            }
            else{
                A[k++] = A2[j++];
                if(j==n2){
                    if(i<n1){
                        for(;i<n1;j++)
                            A[k++]=A1[i++];
                    }
                    break;
                }
            }
        }
        return A;
    }

    public void mergeSort(Comparable[] A){
        mergeSort(A,0,A.length-1);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Integer[] source = {9,2,5,1,4,7,3};
        int i = 0,n=source.length;
        mergeSort.mergeSort(source);
        while (i<n)
            System.out.print(source[i++]+" ");
    }
}
