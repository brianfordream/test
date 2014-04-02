/**
 * 
 *计数排序假设n个输入元素中的每一个都是在0到k区间内的一个整数，其中k为某个整数。当k=O(n)时，排序的运行时间为O(n)
 *计数排序的基本思想是：对每一个输入元素x，确定小于x的元素的个数，利用这一信息，就可以直接把x放到它在输出数组中的位置上。 
 *当我们脱离了比较排序模型的时候，Ω(nlgn)这一下界就不在适用了。
 */
public class CountingSort {
	public static void countingSort(int a[],int maxNum){
		int[] c=new int[maxNum+1];
		int[] b=new int[a.length];
		for(int i=0;i<c.length;i++){
			c[i]=0;
		}
		for(int i=0;i<a.length;i++){
			c[a[i]]=c[a[i]]+1;
		}
		for(int i=1;i<c.length;i++)
			c[i]=c[i]+c[i-1];
		for(int i=0;i<b.length;i++){
			b[c[a[i]]-1]=a[i];
			c[a[i]]=c[a[i]]-1;
		}
		for(int i:b){
			System.out.print(" "+i);
		}
	}
	public static void main(String args[]){
		int[] a={2,3,12,14,53,123,43,23};
		countingSort(a,123);
	}
}
