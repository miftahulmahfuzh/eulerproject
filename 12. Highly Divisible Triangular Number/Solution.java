import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;
class Solution {
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
	public static int divs(int tmp,int num) {
		int res = 0;
		int i = 1;
		int _tmp = (int)Math.sqrt(tmp);
		while(i<=_tmp) {
			if(tmp%i==0) {
				if(tmp/i==_tmp) res++;
				else res+=2;
			}
			if(res>num) return res;
			i++;
		}
		return 0;
	}
	public static void main(String[] args) {
		ArrayList<Solution> AL = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=0;i<t;i++) 
			AL.add(new Solution(i,s.nextInt()));
		Collections.sort(AL,new numComparator());
		int j = 2;
		int tmp = 3;
		for(int i=0;i<t;i++) {
			boolean same = false;
			if(i>0) {
				if(AL.get(i).num==AL.get(i-1).num) {
					AL.get(i).res = AL.get(i-1).res;
					same = true;
				}
			}
			if(!same) {
				while(divs(tmp,AL.get(i).num)==0) {
					j++;
					tmp += j;
				}
				AL.get(i).res = tmp;
			}
		}
		Collections.sort(AL,new idxComparator());
		for(Solution a : AL) 
			System.out.println(a.res);
	}
}