import java.util.Random;


public class MergeSort {
	private final static int NUM=200000;
	public static void main(String args[]){
		
		RandomArray ra=new RandomArray();
		int[] arr=new int[NUM];
		Random r=new Random();
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=r.nextInt(NUM*10);
		}
		ra.randomize(arr);
		System.out.println();
		MergeSort ms=new MergeSort();
		long now=System.currentTimeMillis();
		ms.mergeSort(arr, 0, arr.length-1);
	
		System.out.println("time is :"+Long.toString(System.currentTimeMillis()-now));
//		for(int i:arr)
//			System.out.print(i+",");
		ra.randomize(arr);
		now=System.currentTimeMillis();
		ms.insertSort(arr);
		System.out.println("time is :"+Long.toString(System.currentTimeMillis()-now));
		System.out.println();
//		for(int i:arr)
//		System.out.print(i+",");
	}
	public void insertSort(int a[]){
		int k;
		int tmp = 0;
		for(int i=1;i<a.length;i++){
			tmp=a[i];
			for(k=i-1;k>=0;k--){
				
				if(tmp<a[k])
					a[k+1]=a[k];
				else
					break;
			}
				a[++k]=tmp;
		}
	}
	public void mergeSort(int a[],int begin,int end){
		if(begin<end){
			int middle=(end+begin)/2;
			mergeSort(a,begin,middle);
			mergeSort(a,middle+1,end);
			mergeArray(a,begin,middle,end);
		}
	}
	public void mergeArray(int a[],int begin,int middle,int end){
		int i=begin;
		int j=middle+1;
		int k=0;
		int tmp[]=new int[end-begin+1];
		while(i<=middle && j<=end){
			if(a[i]<=a[j])
				tmp[k++]=a[i++];
			else 
				tmp[k++]=a[j++];
		}
		while(i<=middle)
			tmp[k++]=a[i++];
		while(j<=end)
			tmp[k++]=a[j++];
		for(int m=0;m<k;m++){
			a[m+begin]=tmp[m];
		}
	}
}
