import java.math.BigInteger;	
import java.util.Scanner;	
import java.io.*;	
class Solution {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s = a.nextLine();
		int t = Integer.parseInt(s.trim());
		BigInteger res = new BigInteger("0");
		while(t-->0) {
			s = a.nextLine();
			BigInteger tmp = new BigInteger(s);
			res = res.add(tmp);	
		}
		String result = "" + res;
		System.out.println(result.substring(0,10));
	}	
}