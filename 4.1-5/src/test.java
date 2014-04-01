
public class test {
	public static void main(String args[]){
		int a[]={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		max(a);
	}
	public static void max(int a[]){
		int sum=Integer.MIN_VALUE;
		int tmp=Integer.MIN_VALUE;
		int min=-1;
		int max=-1;
		for(int i=0;i<a.length;i++){
			if(tmp>0)
				{
					tmp+=a[i];
				}
			else
				{
					tmp=a[i];
					min=i;
				}
			if(tmp>sum)
				{
					sum=tmp;
					max=i;
				}
		}
		System.out.println(min+":"+max+":"+sum);
	}
}
