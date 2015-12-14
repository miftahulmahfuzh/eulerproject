def factors(x):
	return sorted(set(reduce(list.__add__,([i,x//i] for i in range(1,int(x**0.5)+1) if x%i==0),[])))[:-1]
def abundant(num):
	return sum(factors(num))>num
t = int(raw_input())
while t > 0 :
	result = 'NO'
	n = int(raw_input())
	for i in range(12,n/2+1):
		if abundant(i) and abundant(n-i):
			result = 'YES'
			break
	print result
	t -= 1
