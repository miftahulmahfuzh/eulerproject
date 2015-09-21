import java.util.Scanner;		
class Solution {
	public static int f(int b,int n) {
		int a1 = detA(b,n,true), a2 = detA(b,n,false); 
		if(a1%a2==0 && a1>0 && a2>0) {
			int a = a1/a2;
			return a * b * (int)Math.sqrt(a*a+b*b);
		}
		else return -1;
	}
	public static int detA(int b,int n,boolean a1) {
		return a1?n*(n-2*b):2*(n-b); 
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0) {
			int n = s.nextInt();
			int result = -1;
			for(int b=1;b<n;b++) {
				int tmp = f(b,n);
				if(tmp>result)
					result = tmp;
			}
			System.out.println(result);
		}
	}
}