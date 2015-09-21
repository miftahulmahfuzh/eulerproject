import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	static ArrayList<Solution> AL = new ArrayList<>();
	int idx,num,res;
	Solution(int _idx,int _num) {
		idx = _idx;
		num = _num;
	}
	static class idxComparator implements Comparator<Solution> {
		@Override
		public int compare(Solution s1, Solution s2) {
			return s1.idx-s2.idx;
		}
	} 
	static class numComparator implements Comparator<Solution> {
		@Override
		public int compare(Solution s1, Solution s2) {
			return s1.num-s2.num;
		}
	}	
	static Boolean colletz(int n1, int max[]) {
		int rs = 1;
		long n = n1;
		while(n>1) {
			n = n%2==0?n/2:3*n+1;
			rs++;
		}
		if(rs>=max[0]) {
			max[0] = rs;
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=0;i<t;i++)
			AL.add(new Solution(i,s.nextInt()));
		Collections.sort(AL,new numComparator());
		int[] max = new int[1];
		max[0] = 0;
		int tmp = 1;
		int tmp2 = 0;
		for(int i=0;i<t;i++) {
			while(tmp<=AL.get(i).num) {
				tmp2 = colletz(tmp,max)?tmp:tmp2;
				tmp++; 
			}
			AL.get(i).res = tmp2;
		}
		Collections.sort(AL,new idxComparator());
		for(int i=0;i<t;i++)
			System.out.println(AL.get(i).res);
	}
}