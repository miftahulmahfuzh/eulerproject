def leap_year_before(year):
	return (year/4) - (year/100) + (year/400) 
def is_leap(year):
	return (year%4==0 and year%100>0) or year%400==0
def get_day(month,year):
	if(month==2):
		day_passed = 28;
		if(is_leap(year)):
			day_passed += 1;
	elif(month==4 or month==6 or month==9 or month==11):
		day_passed = 30
	else:
		day_passed = 31	
	return day_passed
t = int(raw_input())
while t > 0 :
	begin = map(long,str.split(raw_input()))
	end = map(long,str.split(raw_input()))
	year = begin[0]
	month = begin[1]
	date = begin[2]
	if date>1:
		month += 1
		if month>12:
			year += 1
			month = 1
	leap = leap_year_before(year-1) - leap_year_before(1899)
	day_name = ((year-1900)*365 + leap)
	for i in range(1,month):
		day_name += get_day(i,year)
	day_name = (day_name+1)%7
	result = 0
	while True:
		if day_name==0:
			result += 1
		if month==end[1] and year==end[0]:
			break	
		day_name += get_day(month,year)
		day_name %= 7
		month += 1
		if(month>12):
			year += 1
			month = 1
	print result
	t -= 1	
