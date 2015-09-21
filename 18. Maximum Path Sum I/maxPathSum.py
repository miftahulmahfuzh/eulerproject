def max_path(temp,n,path) :
	if n == 1 :
		return map(str, temp)
	else :
		tmp = []
		path_n = path[n-2]
		for i in range(n-1) :
			if temp[i]>temp[i+1] :
				x = temp[i]
			else :
				x = temp[i+1]
			tmp.append(path_n[i]+x)
		return max_path(tmp,n-1,path) 	

t = int(raw_input())
while t > 0 :
	path = []
	n = int(raw_input())
	for i in range(n) :
		row = map(int, str.split(raw_input()))
		path.append(row)
	print ''.join(max_path(path[n-1],n,path))
	t = t - 1		