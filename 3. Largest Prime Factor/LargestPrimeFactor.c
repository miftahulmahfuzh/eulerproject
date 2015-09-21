#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
	/*additional func*/
	unsigned int sqrt32(unsigned long n) {
   unsigned int c = 0x8000;  
   unsigned int g = 0x8000;  
   for(;;) {  
    if(g*g > n) g ^= c;  
    c >>= 1;  
    if(c == 0) return g;  
    g |= c;  
   }  
  }
	int isprime(int a) {
		/*local dict*/
		int i = 2;
		/*algorithms*/
		if (a == 2) return 1;
		while (i<=sqrt32(a) && a%i != 0) i++;
		return (a%i!=0);		
	}
	/*dict*/
	int t; // test case
	int n;
	int j = 2; // counter
	/*algorithms*/
	scanf("%d",&t);
	while(t) {
		scanf("%d",&n);
        if (isprime(n)) printf("%d",n);
        else {
          while((n%j!=0) || isprime(n/j)!=1) j++;
		  printf("%d\n",n/j);
        }
        t--;
	}

}
