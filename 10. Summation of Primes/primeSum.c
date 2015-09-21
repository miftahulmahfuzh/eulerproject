#include <stdio.h>

int main() {
	/*global dict*/
	typedef struct {
		unsigned idx;
		unsigned num;
		unsigned long long res;
	}number;
	number pm[10000];

	/*additional function*/
	void change(number *n1,number *n2) {
		number temp;
		temp.num = (*n1).num;		temp.idx = (*n1).idx;		temp.res = (*n1).res;
		(*n1).num = (*n2).num;	(*n1).idx = (*n2).idx;	(*n1).res = (*n2).res;
		(*n2).num = temp.num;		(*n2).idx = temp.idx;		(*n2).res = temp.res;
	}

	void quicksort(number x[10000],int first,int last,int num) {
		/*local dict*/
		int pivot,j,i;
		/*algorithm*/
		if(first<last) {
			pivot = first;
			i = first; j = last;
			while(i<j) {
				if(num) while(x[i].num <= x[pivot].num && i<last) i++;
				else		while(x[i].idx <= x[pivot].idx && i<last) i++;
				if(num) while(x[j].num > x[pivot].num) j--;
				else		while(x[j].idx > x[pivot].idx) j--;
				if (i<j) change(&x[i],&x[j]);	
			} change(&x[j],&x[pivot]);
			quicksort(x,first,j-1,num); quicksort(x,j+1,last,num);
		}
	}

	unsigned sqrt32(unsigned n) {
		unsigned q = 0x8000;
		unsigned c = 0x8000;
		for(;;) {
			if(q*q > n) q^=c;
			c>>=1;
			if(c==0) return q;
			q |= c;
		}
	}

	int isprime(long long int n) {
		int i=2; if(n==2) return 1;
		while (i<=sqrt32(n) && n%i!=0) i++;
		return (n%i!=0);
	}

	/*local dict*/
	unsigned t,n,i,pr;
	
	/*algorithm*/
	/*read input*/
	scanf("%d",&t);
	for (i=1;i<=t;i++) { 
		scanf("%d",&pm[i].num);
		pm[i].idx = i;
	}
	
	/*sort based on num*/
	quicksort(pm,1,t,1);

	/*main*/
	/*initiate*/
	pr = 2; pm[1].res = 0;
	while (pr<=pm[1].num) {
		pm[1].res += pr;
		if (pr == 2) pr++; else pr+=2;
		while(!isprime(pr)) pr+=2;
	}
	/*iterate*/
	for(i=2;i<=t;i++) {
		pm[i].res = pm[i-1].res;
		while (pr<=pm[i].num) {
			pm[i].res += pr; pr+=2;
			while(!isprime(pr)) pr+=2;
		}
	}

	/*sort based on idx*/
	quicksort(pm,1,t,0);

	/*print result*/
	for(i=1;i<=t;i++)
		printf("%lld\n",pm[i].res);
}
