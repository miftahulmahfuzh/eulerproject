#include <stdio.h>
int main() {
	/*additional procedure*/
	void turn(char in[51],int out[51]) {
		int i;
		for(i=0;i<=49;i++)
			out[i] = in[i] - '0';
	}
	/*dictionary*/
	int t,i,j,c;
	int tmp[51];
	int  res[51];
	char res2[51];
	int  n[51];
	char n2[51];
	/*algorithm*/
	scanf("%d",&t);
	/*first*/
	scanf("%s",res2); 
	turn(res2,res); 
	t--; tmp[49] = 0;
	/*iterate*/
	while(t) {
		scanf("%s",n2); 
		turn(n2,n);
		/*first*/
		i=49; 
		c=res[i]+n[i];
		tmp[i-1] = c/10;
		res[i]   = c%10;
		/*iterate*/
		for(i=48;i>=0;i--) {
			c = res[i]+n[i]+tmp[i];
			if(i>0) tmp[i-1] = c/10;
			else tmp[49] += c/10;
			res[i] = c%10;
		}
		t--;
	}
	j=9; c=tmp[49];	
	if(c) {
		printf("%d",c);
		if(c%100==0) j--;
		if(c%10==0) j--;
		j--;
	}
	for(i=0;i<=j;i++)
		printf("%d",res[i]);
	printf("\n");
	return 0;
}