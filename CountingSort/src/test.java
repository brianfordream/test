
/**
 * 
 *JAVA函数是值传递,下面的输出结果是 1 4 3
 *
 */
public class test {
	public static void main(String args[]){
		int[] a={1,2,3};
		cal(a);
		for(int i:a)
			System.out.println(i);
	}

	private static void cal(int[] a) {
		// TODO Auto-generated method stub
		a[1]=4;
	}
}
