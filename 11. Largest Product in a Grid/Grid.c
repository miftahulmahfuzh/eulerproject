#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

  /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
  /*dictionary*/
  int i,j,k;
  double max,tmp;
  double n[21][20];
  /*algorithm*/
  for(i=1;i<=20;i++)
    for(j=1;j<=20;j++) {
      scanf("%lf",&n[i][j]);
      if (n[i][j]==0.0) n[i][j]--;
    }
  /*algorithm*/
  /*initiate*/
  max=0;
  /*scan row*/
  for(i=1;i<=20;i++) {
    /*first*/
    tmp=n[i][1];
    for(k=2;k<=4;k++) 
      tmp*=n[i][k];
    if(tmp>max) max=tmp;
    /*iterate*/
    for(j=2;j<=17;j++) {
      tmp/=n[i][j-1];
      tmp*=n[i][j+3];
      if(tmp>max) max=tmp;
    }
  }
  /*up to down - scan column*/
  for(j=1;j<=20;j++) {
    /*first*/
    tmp=n[1][j];
    for(k=2;k<=4;k++) 
      tmp*=n[k][j];
    if(tmp>max) max=tmp;
    /*iterate*/
    for(i=2;i<=17;i++) {
      tmp/=n[i-1][j];
      tmp*=n[i+3][j];
      if(tmp>max) max=tmp;
    }
  }
  /*left to right - scan lower half matrix*/
  for(i=1;i<=17;i++){
    /*first*/
    tmp=n[i][1];
    for(k=2;k<=4;k++)
      tmp*=n[i+k-1][k];
    if(tmp>max) max=tmp;
    /*iterate*/
    j=1;
    while(j+i<=17) {
      tmp/=n[j+i-1][j];
      tmp*=n[j+i+3][j+4];
      if(tmp>max) max=tmp;
      j++;
    }
  }
  /*left to right - scan upper half matrix*/
  for(j=2;j<=17;j++) {
    /*first*/
    tmp=n[1][j];
    for(k=2;k<=4;k++)
      tmp*=n[k][j+k-1];
    if(tmp>max) max=tmp;
    /*iterate*/
    i=1;
    while(i+j<=17) {
      tmp/=n[i][i+j-1];
      tmp*=n[i+4][i+j+3];
      if(tmp>max) max=tmp;
      i++;
    }
  }
  /*right to left- scan lower half matrix*/
  for(i=1;i<=17;i++){
    /*first*/
    j=0;tmp=n[i][20];
    for(k=19;k<=17;k--){
      j++;
      tmp*=n[i+j][k];
    }
    if(tmp>max) max=tmp;
    /*iterate*/
    j=16;k=1;
    while(j>=i) {
      tmp/=n[j+4][k];
      tmp*=n[j][k+4];
      if(tmp>max) max=tmp;
      j--;k++;
    }
  }
  /*right to left - scan upper half matrix*/
  for(j=19;j<=4;j--) {
    /*first*/
    tmp=n[1][j]; k=j;
    for(i=2;i<=4;i++) {
      k--;
      tmp*=n[i][k];
    }
    if(tmp>max) max=tmp;
    /*iterate*/
    i=5;k=j;
    while(i<=j) {
      tmp/=n[i-4][k];
      tmp*=n[i][k-4];
      if(tmp>max) max=tmp;
      i++;k--;
    }
  }
  printf("%.0lf\n",max);
  return 0;
}
