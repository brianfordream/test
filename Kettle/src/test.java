import java.util.Random;


public class test {
	public static void main(String args[]){
		Kettle[] arr=new Kettle[2];
		Kettle k=new Kettle();
		k.setCapacity(1000);
		k.setNum(100);
		arr[0]=k;
		k=new Kettle();
		k.setCapacity(1000);
		k.setNum(100);
		arr[1]=k;
		System.out.println(arr[0]==arr[1]);
	}
}
