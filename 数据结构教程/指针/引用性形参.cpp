#include<stdio.h>
void swap(int &x,int &y){
	int temp=x;
	x=y;
	y=temp;
}
int main(){
	int x=3,y=5;
    swap(x,y);
    printf("%d %d",x,y);
}

