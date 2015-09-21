#include <stdio.h>

int main() {
    /*global dict*/
    typedef struct {
        int idx,num;
        unsigned long res;
    } number;
    number pm[10]; // saves input and result 

    /*additional function*/ 
    void change(number *n1,number *n2) {
        number temp;
        temp.num = (*n1).num;       temp.idx = (*n1).idx;       temp.res = (*n1).res;
        (*n1).num = (*n2).num;  (*n1).idx = (*n2).idx;  (*n1).res = (*n2).res;
        (*n2).num = temp.num;       (*n2).idx = temp.idx;       (*n2).res = temp.res;
    }
    void quicksort(number x[10], int first, int last,int num) {
        /*local dict*/
        int i,j,pivot;
        /*algorithm*/
        if (first<last){
            pivot = first;
            i = first; j = last;
            while(i<j){
                if(num) while(x[i].num <= x[pivot].num && i<last) i++;
                else        while(x[i].idx <= x[pivot].idx && i<last) i++;
                if(num) while(x[j].num >    x[pivot].num) j--;
                else        while(x[j].idx >    x[pivot].idx) j--;
                if(i<j) change (&x[i],&x[j]);
            } change(&x[pivot],&x[j]);
            quicksort(x,first,j-1,num); quicksort(x,j+1,last,num);
        }
    }
    unsigned long sqrt32(unsigned long n) {
        unsigned long q = 0x8000;
        unsigned long c = 0x8000;
        for(;;) {
            if(q*q>n) q^=c;
            c>>=1;
            if(c==0) return q;
            q|=c;
        }
    }
    int divs(unsigned long tmp,int num) {
        /*local dict*/
        int res=0;
        int i=1;
        /*algorithm*/
        while(i<=sqrt32(tmp)) {
            if(tmp%i==0) {
                if(tmp/i==sqrt32(tmp)) res++;
                else res+=2;
            }
            if(res>num) return res;
            i++;
        }
        return 0;
    }

    /*local dict*/
    unsigned long tmp; // saves temporary triangular number
    int j; // saves amount of divisor for each num
    int t,i;
    
    /*algorithm*/
    /*read input*/
    scanf("%d",&t);
    for(i=1;i<=t;i++) {
        scanf("%d",&pm[i].num);
        pm[i].idx = i;
    }

    /*sort based on num*/
    quicksort(pm,1,t,1);
    
    /*main*/
    j=2;tmp=3;
    while(!divs(tmp,pm[1].num)) {
        j++;
        tmp+=j; 
    }
    pm[1].res=tmp;
    for (i=2;i<=t;i++) {
        if(pm[i].num==pm[i-1].num)
            pm[i].res= pm[i-1].res;
        else {
            while(!divs(tmp,pm[i].num)) {
                j++;
                tmp+=j; 
            }
            pm[i].res=tmp;  
        }
    }
    
    /*sort based on idx*/
    quicksort(pm,1,t,0);
    
    /*print result*/
    for(i=1;i<=t;i++) printf("%ld\n",pm[i].res);
}