import java.io.*;	
class Solution {
	public static Boolean isPrime(int x) {
		if(x<2) return false;
		if(x<4) return true;
		int i=2;
		while(i<(int)Math.sqrt(x) && x%i!=0) {
			i++;
		}
		return(x%i!=0);
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String S = br.readLine();
			int T = Integer.parseInt(S);
			int[] prime = new int[10001];
			//initiate
			prime[1]=2; prime[2]=3;
			int maxprimecount = 2;
			for(int i=0;i<T;i++) {
				S = br.readLine();
				int x = Integer.parseInt(S);
				if(x>maxprimecount) {
					int temp = prime[maxprimecount]+2;
					while(maxprimecount<x) {
						while(!isPrime(temp)) temp+=2;
						//now temp is prime
						prime[++maxprimecount] = temp;
						temp+=2;
					}//maxprimecount==x
				}
				System.out.println(prime[x]);
			}
		}
		catch(IOException io) {
			io.printStackTrace();
		}
	}  
}