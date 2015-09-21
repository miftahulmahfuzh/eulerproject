//this is solution for project euler+ #10 : summation of primes
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;	
class Solution {
	static class Tab {
		int idx, num;
		long res;
		Tab(int _idx,int _num) {
			idx = _idx;
			num = _num;
		}
	}
	static class idxComparator implements Comparator<Tab> {
		@Override
		public int compare(Tab t1, Tab t2) {
			Integer idx1 = t1.idx;
			Integer idx2 = t2.idx;
			return idx1.compareTo(idx2);
		}
	}
	static class numComparator implements Comparator<Tab> {
		@Override
		public int compare(Tab t1, Tab t2) {
			Integer num1 = t1.num;
			Integer num2 = t2.num;
			return num1.compareTo(num2);
		}
	}
	static boolean isPrime(int n) {
		int i=2;
		if(n==2) return true;
		while(i<Math.sqrt(n) && n%i>0) i++;
		return n%i>0;
	}
	static int nextPrime(int prime) {
		int next = prime;
		if(next<3) next++;
		else next+=2;
		while(!isPrime(next))
			next+=2;
		return next; 
	}
	public static void main(String[] args) {
		//read input
		ArrayList<Tab> RS = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=0;i<t;i++) {
			int num = s.nextInt();
			RS.add(new Tab(i,num));
		}
		//algorithm
		Collections.sort(RS,new numComparator());
		int prime = 2;
		for(int i=0;i<t;i++) {
			RS.get(i).res = i>0?RS.get(i-1).res:0;
			while(prime<=RS.get(i).num) {
				RS.get(i).res += prime;
				prime = nextPrime(prime); 
			}
		}
		//print output
		Collections.sort(RS,new idxComparator());
		for(Tab T : RS) 
			System.out.println(T.res);
	}
}