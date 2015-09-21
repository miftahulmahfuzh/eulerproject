#include <stdio.h>
#include <stdlib.h>
/*representasi unsigned long long  belum mencukupi*/
int main() {
	unsigned sqrt32(unsigned n) {
		unsigned q = 0x8000;
		unsigned c = 0x8000;
		for(;;) {
			if(q*q>n) q^=c;
			c>>=1;
			if(c==0) return q;
			q|=c; 
		}
	}
	int gcd(int a,int b) {
		int c;
		if(b>a) {c=a; a=b; b=c;}
		if(b==0) return a;
		return gcd(b,a%b);
	}
	/*dictionary*/
	int* div;
	int t,c,i,j,x,y,temp,cd;
	unsigned long long res;
	/*main*/
	scanf("%d",&t);
	while(t) {
		res=1;
		scanf("%d%d",&x,&y);
		if (x>y) {c=x; x=y; y=c;}
		div = (int *) malloc((x+1)*sizeof(int));
		for(j=1;j<=x;j++)
				div[j] = j;
		//main		
			c=x+y;
			for(i=c;i>y;i--) {
				temp=i; j=2;
				while(temp>1&&j<=x) {
					if(div[j]>1) {
						cd=gcd(temp,div[j]); //printf("%d,%d ",cd,div[j]);
						if(cd>1) { 
							temp/=cd;//printf("\n%d\n",temp);
							div[j]/=cd;
						}		
					}
					j++;//printf("\n%d -> %d\n",i,temp);
				}
				res*=temp;				
				if(res>2548782591045708352) res = 2548782591045708352;
			}
		printf("%lld\n",res);
		t--;
	}
	return 0;
}