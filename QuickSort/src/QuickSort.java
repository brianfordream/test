import java.util.Random;
public class QuickSort {
	public int partition(int a[],int begin,int end){ //快速排序的非随机化版本
		int i=begin-1;
		int x=a[end];
		for(int j=begin;j<=end-1;j++)
		{
			if(a[j]<=x){
				i++;
				swap(a,i,j);
			}
		}
		swap(a,end,i+1);
		return i+1;
	}
	public int randomPartition(int a[],int begin,int end){ //快速排序的随机化版本
		int i=begin-1;
		int ran=new Random().nextInt(end-begin+1)+begin;
		swap(a,ran,end);
		return partition(a,begin,end);
	}
	public void quickSort(int[] a,int begin,int end){
		if(begin>=end)
			return;
		int ran=this.randomPartition(a, begin,end);
		quickSort(a,begin,ran-1);
		quickSort(a,ran+1,end);
	}

	private void swap(int[] a, int par, int end) {
		int tmp=a[par];
		a[par]=a[end];
		a[end]=tmp;	
	}
	
	public static void main(String args[]){
		QuickSort qs=new QuickSort();
		int[] a={2,1,42,123,12,32,14,1,3};
		qs.quickSort(a, 0, a.length-1);
		for(int tmp:a){
			System.out.print(" "+tmp);
		}
	}
}
