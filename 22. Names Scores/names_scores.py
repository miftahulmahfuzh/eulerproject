def get_value(name):
	val = 0
	for i in name: val += ord(i)-64
	return val

names = {} 
t = int(raw_input())
while t > 0 :
	name = raw_input()
	names[name] = get_value(name)
	t -= 1
qt = int(raw_input())
while qt > 0 :
	query = raw_input()
	print (sorted(names).index(query)+1) * names[query]
	qt -= 1
