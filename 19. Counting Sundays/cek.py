n = int(raw_input())
leap = 0
for i in range(1,n):
	if (i%4<1 and i%100>0) or (i%400<1):
		leap = leap+1
print leap