/**
 * 
 *�����������n������Ԫ���е�ÿһ��������0��k�����ڵ�һ������������kΪĳ����������k=O(n)ʱ�����������ʱ��ΪO(n)
 *��������Ļ���˼���ǣ���ÿһ������Ԫ��x��ȷ��С��x��Ԫ�صĸ�����������һ��Ϣ���Ϳ���ֱ�Ӱ�x�ŵ�������������е�λ���ϡ� 
 *�����������˱Ƚ�����ģ�͵�ʱ�򣬦�(nlgn)��һ�½�Ͳ��������ˡ�
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
