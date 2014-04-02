/**
 * ��������
 * RADIX_SORT(A,d)
 * for i=1 to d 
 * 		use a stable sort to sort array A on digit i
 * ����������ԭַ���򣬶��ܶন(nlgn)ʱ��ıȽ�������ԭַ���򣬵�����������Ƚϱ���ʱ��
 * ���Ǹ����������������������ԭַ����
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
