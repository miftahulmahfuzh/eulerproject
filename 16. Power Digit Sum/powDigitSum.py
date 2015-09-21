def sumdigits(n):
	m = 0;
	for i in range(len(str(n))):
		m += n % 10
		n /= 10
	return m
t = int(raw_input())
while t > 0 :
	n = raw_input()
	print sumdigits(2**int(n))
	t = t - 1