import java.util.Random;


public class RandomArray {
	public static void main(String args[]){
		int[] arr=new int[100];
		for(int i=0;i<100;i++)
		{
			arr[i]=i;
		}
		randomize(arr);
		for(int a:arr){
			System.out.print(a+" ");
		}
	}

	public static void randomize(int[] arr) {
		Random r=new Random();
		int tmp;
		for(int i=0;i<arr.length;i++){
			int ran=i+r.nextInt(arr.length-i);
			tmp=arr[i];
			arr[i]=arr[ran];
			arr[ran]=tmp;
		}
	}
}
