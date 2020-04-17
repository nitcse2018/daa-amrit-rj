// Fibonacci Series using Dynamic Programming
/*Output:
Fibonacci Series: 
[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55]*/ 
import java.util.Arrays;
public class Fibonacci 
{ 
	int[] fib(int n) 
	{ 
		int f[] = new int[n+1];
		int i; 
		f[0] = 0; 
		f[1] = 1; 
		for (i = 2; i <= n; i++)  
			f[i] = f[i-1] + f[i-2];
		return f; 
	} 
	
	public static void main (String args[]) 
	{ 
		Fibonacci ob=new Fibonacci();
		int n = 10; 
		System.out.println("Fibonacci Series: \n"+Arrays.toString(ob.fib(n))); 
	} 
}
