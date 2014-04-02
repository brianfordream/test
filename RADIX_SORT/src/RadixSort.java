/**
 * 基数排序
 * RADIX_SORT(A,d)
 * for i=1 to d 
 * 		use a stable sort to sort array A on digit i
 * 基数排序不是原址排序，而很多Θ(nlgn)时间的比较排序是原址排序，当主存的容量比较宝贵时，
 * 我们更倾向于像快速排序这样的原址排序。
 */
import java.util.Arrays;
public class RadixSort {
	public static void main(String args[]){
		RadixSort rs=new RadixSort();
		int a[]={1,3,1,123,32,12,43};
		rs.radixSort(a, 3);
		for(int i:a){
			System.out.print(" "+i);
		}
	}
	public void radixSort(int[] a,int d){
		int[] b=Arrays.copyOf(a, a.length);
		int[][] tmp=new int[10][a.length+1];
		for(int i=1;i<=d;i++){
			tmp=new int[10][a.length+1];
			for(int j=0;j<b.length;j++){
				int num=getNumInPos(b[j],i);
				tmp[num][0]++;
				int index=tmp[num][0];
				tmp[num][index]=b[j];	
			}
			for(int j=0,k=0;k<tmp.length && j<b.length;k++){
				for(int m=1;m<=tmp[k][0];m++){
					b[j]=tmp[k][m];
					j++;
				}
			}
		}
		for(int i=0;i<a.length;i++)
			a[i]=b[i];
	}

	private int getNumInPos(int num,int pos) {
		for(int i=1;i<pos;i++){
			num=num/10;
		}
			return num%10;
	}
}
