from collections import Counter

def divisors(x):
	return sorted(reduce(list.__add__,([i,x//i] for i in range(1,int(x**0.5)+1) if x%i==0),[]))[:-1]

def is_amicable(x):
	div_sum = sum(divisors(x))
	return sum(divisors(div_sum))==x and div_sum!=x,div_sum

list_n = []
cnt_result = Counter() #this counter is used so that sorting process just called once
cnt_amicable = Counter() #this counter so is_amicable dont called twice for the same number
t = int(raw_input()) 
while t>0:
	n = int(raw_input())
	list_n.append(n)
	t -= 1
tp = sorted(list_n)
nbelmt=len(tp)
for idx in range(nbelmt):
	if idx==0 : 
		start=0
		result=0
	else: 
		start=tp[idx-1]
		result=cnt_result[start]
	cnt_added = Counter() #using this so no redundant numbers in result sum
	flag,div_sum = False,0
	for i in range(start+1,tp[idx]+1):
		if cnt_amicable[i] > 0:
			result += i
		elif cnt_added[i] == 0:
			flag,div_sum = is_amicable(i)
			if flag:
				result += i
				if div_sum <= tp[idx]: 
					result += div_sum
					cnt_added[div_sum] += 1
				elif div_sum <= tp[-1] and idx != nbelmt-1 :
					cnt_amicable[div_sum] += 1
	cnt_result[tp[idx]] = result
for i in list_n:
	print cnt_result[i]
