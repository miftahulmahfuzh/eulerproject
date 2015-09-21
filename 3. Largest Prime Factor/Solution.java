import java.io.*;
class Solution {
	public static Boolean isPrime(long a) {
		int i;
		for(i=2;i<(int)Math.sqrt(a) && a%i!=0;i++);
		return a%i!=0;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String S = br.readLine();
			int t = Integer.parseInt(S);
			long n,i;
			while(t>0) {
				S = br.readLine();
				n = Long.parseLong(S);
				if(isPrime(n))
					System.out.println(n);
				else {
					i=2;
					while(true) {
						while(n%i!=0) i++;
						if(isPrime(n/i)) break;
						else i++;
					}
					System.out.println(n/i);
				}
				t--;
			}
		}
		catch (IOException io) {
			io.printStackTrace();
		}		
	}
}