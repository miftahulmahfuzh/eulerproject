t = int(raw_input())
while t>0 :
	n = int(raw_input())
	total = 1
	while n>0:
		total *= n
		n -= 1
	temp = str(total)
	total_list = []
	for digit in temp:
		total_list.append(int(digit))	
	result = 0
	for i in total_list:
		result += i
	print result	
	t -= 1