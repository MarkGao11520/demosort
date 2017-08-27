package com.gwf.demo.sort.pq;


/**
 * Created by gaowenfeng on 2017/8/27.
 */
public class HeapSort {
    private void sort(Comparable[] A){
        int i,n=A.length-1;
        Comparable temp;

        //堆化除包含根的子树外的所有子树
        for(i=n/2;i>1;i--)
            siftUp(A,i,n);

        //重新堆化从根开始，删除根的关键字，将其放在输出队列中
        //并用以层次排列的最后一个叶子中的关键字替换根的关键字，
        //直到堆含有一个关键字
        for(i=n;i>1;i--){
            int l = 0;
            siftUp(A,1,i);
            l=1;
            temp = A[1]; A[1] = A[i]; A[i] = temp;  //交换A[1] 与 A[i]
        }
    }

    /**
     * 堆化A
     * @param A 需要堆化的数组
     * @param i 设i指向根
     * @param n 指向以层次排列的最后一个叶子
     */
    private void siftUp(Comparable[] A,int i,int n ){
        int j;
        Comparable rootKey;
        boolean notFinished;

        rootKey = A[i]; //rootKey 为根处关键字

        j = 2*i; //j指向i的孩子
        notFinished = (j<=n);  //如果j存在于树中则siftUp不会结束

        while(notFinished){
            //将任一大于根关键字的较大孩子沿着树向上移一层

            if(j<n){  //如果i的右孩子也存在于树中
                if(A[j+1].compareTo(A[j])>0) j++; //设j指向较大的孩子
            }

            if(A[j].compareTo(rootKey)<=0){
                notFinished = false;  //如果较大的孩子不大于根关键字，那么没有关键字上移
            }else {
                A[i] = A[j];  //将较大孩子沿着树向上移一层
                i = j;        //现在，设i指向较大孩子j
                j = 2*i;      //并让j指向i的新左孩子
                notFinished = (j<=n);   //如果j存在于树中，则siftUp不会结束
            }

        }  //end while

        A[i] = rootKey; //根关键字的最终位置
    }

    public void heapSort(Comparable[] A){
        Comparable[] A_ = new Comparable[A.length+1];
        System.arraycopy(A,0,A_,1,A.length);
        sort(A_);
        System.arraycopy(A_,1,A,0,A.length);
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        Integer[] source = {-1,2,5,1,4,7};
        heapSort.heapSort(source);
        int i = 0,n=source.length;
        while (i<n)
            System.out.print(source[i++]+" ");
    }

}
