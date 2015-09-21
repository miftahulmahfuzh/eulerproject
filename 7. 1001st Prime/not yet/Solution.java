import java.util.*;
import java.io.*;
public class Solution {
	private int idx;
	private int num;
	private int res;
	public Solution(int i,int nm) {
		idx=i;
		num=nm;
	}
	public int getIdx() {
		return idx;
	}
	public int getNum() {
		return num;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}	

	public static class SolutionChainedComparator implements Comparator<Solution> {
		private List<Comparator<Solution>> ListSolution;
	
		@SafeVarargs
		public SolutionChainedComparator(Comparator<Solution>... comparators) {
			this.ListSolution = Arrays.asList(comparators);
		}
	
		@Override
		public int compare(Solution e1, Solution e2) {
			for(Comparator<Solution> comparator : ListSolution) {
				int result = comparator.compare(e1,e2);
				if(result != 0) {
					return result;
				}
			}
			return 0;
		}
	}

	public static class IdxComparator implements Comparator<Solution> {
		@Override
		public int compare(Solution e1, Solution e2) {
			return(e1.getIdx()-e2.getIdx()); 
		}	
	}

	public static class NumComparator implements Comparator<Solution> {
		@Override
		public int compare(Solution e1, Solution e2) {
			return(e1.getNum()-e2.getNum());
		}
	}

	public static Boolean isPrime(int x) {
		//special case
		if(x<2) return false;
		if(x<4) return true;
		int i=2;
		while(i<(int)Math.sqrt(x) && x%i!=0) {
			i++;
		}
		return(x%i!=0);
	} 

	public static void main(String args[]) {
		List<Solution> ListSolution = new ArrayList<Solution>();
		 
		//read input
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			String S = br.readLine();
			int T = Integer.parseInt(S);
			for(int i=1;i<=T;i++) {
				S = br.readLine();
				ListSolution.add(new Solution(i,new Integer(Integer.parseInt(S))));
			}
		}
		catch(IOException io) {
			io.printStackTrace();
		}

		//sort based on num
		Collections.sort(ListSolution, new SolutionChainedComparator(
			new NumComparator())
		);

		//1001stPrime Algorithm 
		int i=2; //index for all prime number
		int n=1; //odd number
		for(Solution s : ListSolution) {
			if(s.getNum()==1) s.setRes(2);
			else {
				while(i<=s.getNum()) {
					n+=2;
					while(!isPrime(n)) n+=2;
					i++;
				}
				s.setRes(n);
			}
		}

		//sort based on idx
		Collections.sort(ListSolution, new SolutionChainedComparator(
			new IdxComparator())
		);

		//print result		
		for(Solution e:ListSolution) {
			System.out.println(e.getRes());
		}
	}	
} 