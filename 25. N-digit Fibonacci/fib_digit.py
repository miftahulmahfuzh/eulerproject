from collections import Counter
t = int(raw_input())
answers = Counter()
list_n = []
while t > 0 :
	list_n.append(int(raw_input()))
	t -= 1
tp = sorted(list_n)
a,b,c,j = 0,1,1,2
for i in range(len(tp)):
	while len(str(c)) < tp[i]:
		a = b
		b = c
		c = a + b
		j += 1
	answers[tp[i]] = j
for i in list_n:
	print answers[i]
