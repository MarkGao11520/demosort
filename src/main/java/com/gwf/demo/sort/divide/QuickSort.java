package com.gwf.demo.sort.divide;

/**
 * Created by gaowenfeng on 2017/8/27.
 */
public class QuickSort {
    /**
     * 快速排序法
     * @param A 排序的数组
     * @param m 开始排序的下标
     * @param n 终止排序的下标
     */
    private void quickSort(Comparable[] A,int m,int n){
        if(m>n)
            throw new IllegalArgumentException("起始下标不能小于终止下标");
        if(m<n){
            //1.将A[m:n]分成leftPartition和rightPartition两个区
            //2.利用A[m:n]中的一个关键字作为轴关键字
            int p = partition(A,m,n);
            //3.对leftPartition执行QuickSort
            quickSort(A,m,p-1);
            //4.对rightPartition执行QuickSort
            quickSort(A,p+1,n);
        }
    }

    /**
     * 分区算法
     * @param A  要分区的数组
     * @param i  开始排序的下标
     * @param j  终止排序的下标
     * @return
     */
    private int partition(Comparable[] A,int i,int j){
        Comparable pivot,temp;
        int k,middle,p;

        middle = (i+j)/2;  //选择中间关键字为轴

        pivot = A[middle];A[middle] = A[i]; A[i] = pivot; //将pivot放入A[i]中
        p = i; // 并让P指向pivot

        for(k=i+1;k<=j;k++){  //扫描A[i+1:j]中剩下的关键字
            if(A[k].compareTo(pivot)<0){   //小于pivot的A[k]
                temp = A[++p];A[p]=A[k];A[k]=temp;  //移到A[++p]
            }
        }

        temp = A[i];A[i]=A[p];A[p]=temp;  //然后将pivot放入A[p]中
        return p;
    }

    public void quickSort(Comparable[] A){
        quickSort(A,0,A.length-1);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Integer[] source = {-1,2,5,1,4,7};
        quickSort.quickSort(source);
        int i = 0,n=source.length;
        while (i<n)
            System.out.print(source[i++]+" ");
    }
}
