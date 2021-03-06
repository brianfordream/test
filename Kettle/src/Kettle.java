/**
 *  假设给了你n个红色的水壶和n个蓝色的水壶，他们的形状和尺寸都各不相同，所有的红色水壶中所盛的水都不一样多
 *  蓝色水壶也是如此。而且，对于一个红色水壶来说，都有一个对应的蓝色水壶，两者盛有一样的水
 *  任务是找出所有所盛水量一样多的红色水壶和蓝色水壶，配成一对，不能直接比较两个红色或者蓝色的水壶。
 */
import java.util.Random;
public class Kettle {
	private int capacity;
	private int num;
	public int partitionRandom(int begin,int end){
		Random r=new Random();
		int random=begin+r.nextInt(end-begin+1);
		return random;
	}
	public int partition(Kettle[] kettleB,int begin,int end,Kettle kettleA){
		int i=begin-1;
		int eq=-1;
		for(int j=begin;j<=end;j++){
			if(kettleB[j].capacity<kettleA.capacity){
				i++;
				swap(kettleB,i,j);
			}
			
		}
		for(int m=i+1;m<=end;m++){
			if(kettleB[m].capacity==kettleA.capacity)
				eq=m;
		}
		swap(kettleB,i+1,eq);
		return i+1;
	}
	private void swap(Kettle[] kettleB, int i, int j) {
		int tmp=kettleB[i].capacity;
		kettleB[i].capacity=kettleB[j].capacity;
		kettleB[j].capacity=tmp;
		tmp=kettleB[j].num;
		kettleB[j].num=kettleB[i].num;
		kettleB[i].num=tmp;		
	}
	public void sort(Kettle[] kettleA,Kettle[] kettleB,int begin,int end){
		if(begin<=end){
			int random=partitionRandom(begin, end);
			int partitionB=partition(kettleB,begin,end,kettleA[random]);
		//	System.out.println(kettleA[random].capacity==kettleB[partitionB].capacity);
			int partitionA=partition(kettleA,begin,end,kettleB[partitionB]);
			System.out.println(kettleA[partitionA].num+"="+kettleB[partitionB].num);
			sort(kettleA,kettleB,begin,partitionB-1);
			sort(kettleA,kettleB,partitionB+1,end);
		}
	}
	public static void main(String args[]){
		int[] a={32,54,23,1,43,35};
		int[] b={23,54,32,35,43,1};
		Kettle[] kettleA=new Kettle[a.length];
		Kettle[] kettleB=new Kettle[b.length];
		for(int i=0;i<a.length;i++){
			Kettle k=new Kettle();
			k.setCapacity(a[i]);
			k.setNum(i);
			kettleA[i]=k;
			k=new Kettle();
			k.setCapacity(b[i]);
			k.setNum(i);
			kettleB[i]=k;
		}
		Kettle k=new Kettle();
		k.sort(kettleA,kettleB,0,kettleA.length-1);
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
