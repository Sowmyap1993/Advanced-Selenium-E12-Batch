package practice;

public class Generic_Method_Practice {

	public static void main(String[] args) { //calling function
		// TODO Auto-generated method stub
		int sum=add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,40));
		add(100,sum);
		add(200,300);
		System.out.println(add(2,4,5));
		

	}
	public static int add(int a, int b) //called function generic
	{
		int c=a+b;
		return c;
		
	}
	public static int add(int a, int b, int s) //called function generic
	{
		int c=a+b+s;
		return c;
		
	}


}
