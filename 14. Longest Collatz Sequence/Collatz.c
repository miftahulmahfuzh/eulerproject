#include <stdio.h>
int main() {
	/*global dictionary*/
	typedef struct {
		unsigned long idx,num,res;
	}number;
	number cl[10000];
	/*additional function*/
	void change(number *n1,number *n2) {
		number temp;
		temp.num = (*n1).num; temp.idx = (*n1).idx; temp.res = (*n1).res;
		(*n1).num = (*n2).num;   (*n1).idx = (*n2).idx;   (*n1).res = (*n2).res;
		(*n2).num = temp.num; (*n2).idx = temp.idx; (*n2).res = temp.res;
	}
	void quicksort(number cl[10000],int first,int last,int num) {
		int i,j,pivot;
		if(first<last) {
			pivot=first;
			i=first;j=last;
			while(i<j){
				if(num) while(cl[i].num<=cl[pivot].num && i<last) i++;
				else while(cl[i].idx<=cl[pivot].idx && i<last) i++;
				if(num) while(cl[j].num>cl[pivot].num) j--;
				else while(cl[j].idx>cl[pivot].idx) j--;
				if(i<j) change(&cl[i],&cl[j]);
			}	change(&cl[j],&cl[pivot]);
			quicksort(cl,first,j-1,num); quicksort(cl,j+1,last,num);
		}
	}
	unsigned long colletz(unsigned long n1,unsigned long *max) {
		unsigned long rs = 1;
		unsigned long n=n1;
		while(n>1) {
			if(n%2==0) n/=2;
			else n = 3*n+1;
			rs++;
		} //n==1
		if (rs >= *max) {*max=rs; return n1; }
		return 0;
	}

	/*dict*/
	unsigned long t,i,max,tmp,tmp2,tmp3;
	/*algorithm*/
	scanf("%ld",&t);
	for(i=1;i<=t;i++) {
		scanf("%ld",&cl[i].num);
		cl[i].idx = i;
	}
	/*scan based on num*/
	quicksort(cl,1,t,1);
	/*main*/
	/*first*/
	max=0;tmp=1;
	/*iterate*/
	for(i=1;i<=t;i++) {
		while(tmp<=cl[i].num) {
			tmp2=colletz(tmp,&max);
			if (tmp2) tmp3=tmp2;
			tmp++;
		}
		cl[i].res=tmp3;
	}
	/*scan based on idx*/
	quicksort(cl,1,t,0);
	/*print result*/
	for(i=1;i<=t;i++)
		printf("%ld\n",cl[i].res);
	return 0;
}