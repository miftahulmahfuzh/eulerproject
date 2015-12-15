import math
t = int(raw_input())
while t > 0:
	word = 'abcdefghijklm'
	result = ''
	n = int(raw_input())
	while True:
		if len(word)==2: break
		idx = 0
		div,mod = divmod(n,math.factorial(len(word)-1))
		if div>0:
			if len(word)==3: 
				idx = (n//2)%3-1
				idx += n%2 
			else:
				idx = div % len(word)
				if mod==0: idx -= 1
		result += word[idx]
		word = word.replace(result[-1],'')
	if n%2==0: a,b = -1,0
	else: a,b = 0,-1
	result += word[a] + word[b]
	print result
	t -= 1
