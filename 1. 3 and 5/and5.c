#include <stdio.h>
int main() {	
	/*additional function*/
	unsigned long long sums (unsigned long a,unsigned long b) {
		b -= b%a; // makes b%a == 0
		return b*(a+b)/(2*a);
	}
	/*dictionary*/
	unsigned long t;
	unsigned long n;
	unsigned long long sum;
	/*algorithm*/    
	scanf("%ld",&t);
	while(t) {
		sum=0; scanf("%ld",&n); n--;
		if(n >= 3) sum += sums(3,n);
		if(n >= 5) sum += sums(5,n);
		if(n >= 15)sum -= sums(15,n);
		printf("%lld\n",sum);
		t--;
	}
    return 0;
}
