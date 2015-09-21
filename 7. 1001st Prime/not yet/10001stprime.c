#include <stdio.h>
int main() {
	/*dictionary*/
	typedef struct {
		int num;
		int idx; // saves the first index
		unsigned long long res;	
	}nn;
	nn n[1000]; 
	
	/*additional function*/
	void change(nn *n1,nn *n2) {
		nn temp;
		temp.num = (*n1).num; temp.idx = (*n1).idx; temp.res = (*n1).res;
		(*n1).num = (*n2).num;   (*n1).idx = (*n2).idx;   (*n1).res = (*n2).res;
		(*n2).num = temp.num; (*n2).idx = temp.idx; (*n2).res = temp.res;
	}
	void quicksort(nn x[1000],int first,int last,int num){
    int pivot,j,i;
    if(first<last){
    	pivot=first;
    	i=first; j=last;
      while(i<j){
      	if(num) while(x[i].num <= x[pivot].num && i<last) i++;
      	else    while(x[i].idx <= x[pivot].idx && i<last) i++;
      	if(num) while(x[j].num > x[pivot].num) j--;
      	else    while(x[j].idx > x[pivot].idx) j--;
        if(i<j) change(&x[i],&x[j]);
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
			q|=c;
		} 
	}
	int isprime(long long int n) {
		int i = 2; 
		if (n==i) return 1;
		while ((i<=sqrt32(n))&&(n%i!=0)) i++;
		return (n%i!=0);
	}
	int t,tt;
	int i,j; // counter
	unsigned long long k; // saves prime
	/*algorithms*/
	scanf("%d",&t);
	for (i=1;i<=t;i++) {
		n[i].idx = i; 
		scanf("%d",&n[i].num);
	}
	/*sort based on num*/
	quicksort(n,1,t,1); 
	/*main*/
	for(i=1;i<=t;i++) {
		if (n[i].num == n[i-1].num) n[i].res = n[i-1].res;
		else { 
			if (i==1) { 
				if (n[i].num==1) n[i].res = 2;
				k = 3; j = 2; 
			}	else k = n[i-1].res;
			while (j<n[i].num) {
				k+=2;
				if (isprime(k)) j++;  
			} // now j == n[i].num	
			if (i>1 || n[1].num != 1) n[i].res = k;
		}
	}
	/*sort based on idx*/
	quicksort(n,1,t,0);
	/*print result*/
	for(i=1;i<=t;i++) printf("%lld\n",n[i].res);
}