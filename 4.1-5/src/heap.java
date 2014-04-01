
public class heap {
	public static void main(String args[]){
		int[] a={0,4,1,3,2,16,9,10,14,8,7};
		heap h=new heap();
		h.BUILD_MAX_HEAP(a);
		for(int i:a)
			System.out.print(" "+i);
		int index=a.length-1;
		System.out.println();
		for(int i=1;i<a.length;i++){
			h.HEAPSORT(a, index-i+1);
		}
	}
	public void BUILD_MAX_HEAP(int a[]){
		for(int i=(a.length-1)/2;i>=1;i--){
			MAX_HEAPIFY(a,i,a.length-1);
		}
	}
	public void MAX_HEAPIFY(int a[],int i,int length){
		int left=i<<1;
		int right=(i<<1)+1;
		int max=a[i];
		int maxId=i;
		if(right<length){
			if(max<a[left])
			{
				max=a[left];
				maxId=left;
			}
			if(max<a[right])
			{
				max=a[right];
				maxId=right;
			}
			if(maxId!=i){
				swap(a,maxId,i);
				MAX_HEAPIFY(a,maxId,length);

			}
					}
		else if(left<length){
			if(max<a[left])
			{
				max=a[left];
				maxId=left;
			}
			if(maxId!=i){
				swap(a,maxId,i);
				MAX_HEAPIFY(a,maxId,length);
			}
		
		}
	}
	public void HEAPSORT(int a[],int index){
		swap(a,index,1);
		System.out.print(" "+a[index]);
		this.MAX_HEAPIFY(a, 1,index);
		
	}
	private void swap(int[] a, int maxId, int i) {
		// TODO Auto-generated method stub
		int tmp=a[maxId];
		a[maxId]=a[i];
		a[i]=tmp;
	}
}
