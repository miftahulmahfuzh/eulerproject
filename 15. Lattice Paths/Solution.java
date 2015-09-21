import java.util.Scanner;
import java.math.*;
class Solution {
	static int gcd(int a, int b) {
	//I.S : a>b	
		return b==0?a:gcd(b,a%b);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0) {
			int x = s.nextInt();
			int y = s.nextInt();
			if(x>y) {
				int z=x;
				x=y;
				y=z;
			}
			int[] div = new int[x+1];
			for(int i=0;i<=x;i++) 
				div[i] = i;
			BigInteger result = new BigInteger("1");
			for(int i=x+y;i>y;i--) {
				Integer temp = i;
				int j = 2;
				while(temp>1 && j<=x) {
					if(div[j]>1) {
						int tmpGcd = gcd(temp,div[j]);
						if(tmpGcd>1) {
							temp /= tmpGcd;
							div[j] /= tmpGcd;
						}
					}
					j++;
				}
				result = result.multiply(BigInteger.valueOf(temp.intValue()));
			}
			System.out.println(result.mod(new BigInteger("1000000007")));	
		}
	}
}