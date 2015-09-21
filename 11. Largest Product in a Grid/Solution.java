import java.util.Scanner;	
class Solution {
	public static void main(String[] args) {
		//read input
		Scanner s = new Scanner(System.in); 
		int n[][] = new int[21][21];
		int i,j,k,tmp;
		int max=0;
		for(i=1;i<=20;i++) {
			for(j=1;j<=20;j++) {
				tmp = s.nextInt();
				n[i][j] = tmp>0?tmp:-1;
			}	
		}
		//scan row
		for(i=1;i<=20;i++) {
			//first
			tmp=n[i][1];
			for(j=2;j<=20;j++) {
				if(j>4)
					tmp/=n[i][j-4];
				tmp*=n[i][j];
				if(tmp>max) max=tmp;
			}
		}
		//scan column
		for(j=1;j<=20;j++) {
			tmp=n[1][j];
			for(i=2;i<=20;i++) {
				if(i>4)
					tmp/=n[i-4][j];
				tmp*=n[i][j];
				if(tmp>max) max=tmp;
			}
		}
		//scan lower half (>>)
		for(i=1;i<=17;i++) {
			//first
			tmp = n[i][1];
			for(k=2;k<=4;k++)
				tmp*=n[i+k-1][k];
			if(tmp>max) max = tmp;
			//iterate
			j=1;
			while(j+i<=17) {
				tmp/=n[i+j-1][j];	
				tmp*=n[i+j+3][j+4];
				if(tmp>max) max=tmp;
				j++;
			}
		}
		//scan upper half (>>)
		for(j=2;j<=17;j++) {
			//first
			tmp=n[1][j];
			for(k=2;k<=4;k++)
				tmp*=n[k][j+k-1];
			if(tmp>max) max=tmp;
			//iterate
			i=1;
			while(i+j<=17) {
				tmp/=n[i][i+j-1];
				tmp*=n[i+4][i+j+3];
				if(tmp>max) max=tmp;
				i++;
			}
		}
		//scan lower half (<<)
		for(i=2;i<=17;i++) {
			tmp = n[i][20];
			int a=i+1;
			for(j=19;j>=i;j--) {
				if(j<17) 
					tmp/=n[a-4][j+4];
				tmp*=n[a][j];
				a++; 
				if(tmp>max) max=tmp;
				System.out.println(tmp);
			}
		}
		//scan upper half (<<)
		for(j=20;j>=4;j--) {
			tmp = n[1][j];
			int a=j-1;
			for(i=2;i<=j;i++) {
				if(i>4) 
					tmp/=n[i-4][a+4];
				tmp*=n[i][a];
				a--; 
				if(tmp>max) max=tmp;
			}
		}
		//print result
		System.out.println(max);
	}
}