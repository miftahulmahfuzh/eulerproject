import java.math.BigInteger;
import java.util.Scanner;
public class Solution {
	public static long sums(int a,long b) {
		long c = b;
		c -= c%a;
		return c*(c+a)/(2*a);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		long n;
		long sum;
		while(t>0) {
			sum = 0;
			n = s.nextInt(); n--;
			if(n>=3) sum += sums(3,n);
			if(n>=5) sum += sums(5,n);
			if(n>=15) sum -= sums(15,n);
			System.out.println(sum); 
			t--;
		}
	}
}