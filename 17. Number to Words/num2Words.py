def replace(x):
	if x == 1 :
		return "One"
	elif x == 2 :
		return "Two"
	elif x == 3 :
		return "Three"
	elif x == 4 :
		return "Four"
	elif x == 5 :
		return "Five"
	elif x == 6 :
		return "Six"
	elif x == 7 :
		return "Seven"
	elif x == 8 :
		return "Eight"
	elif x == 9 :
		return "Nine"
	elif x == 10 :
		return "Ten"
	elif x == 11 :
		return "Eleven"
	elif x == 12 :
		return "Twelve"
	elif x == 13 :
		return "Thirteen"
	elif x == 15 :
		return "Fifteen"	
	elif x == 18 :
		return "Eighteen"
	elif x >= 14 and x <= 19 :
		return replace(x%10) + "teen"
	elif x == 20 :
		return "Twenty"
	elif x == 30:
		return "Thirty"
	elif x == 40 :
		return "Forty"
	elif x == 50 :
		return "Fifty"
	elif x == 60 :
		return "Sixty"
	elif x == 70 :
		return "Seventy"
	elif x == 80 :
		return "Eighty"
	elif x == 90 :
		return "Ninety"
	else :
		return ""

def num_to_words(n):
	if n == 10**12 :
		return "One Trillion"
	elif n/10**9 > 0 :
		return num_to_words(n/10**9) + "Billion " + num_to_words(n%10**9)
	elif n/10**6 > 0 :
		return num_to_words(n/10**6) + "Million " + num_to_words(n%10**6) 
	elif n/10**3 > 0 :
		return num_to_words(n/1000) + "Thousand " + num_to_words(n%1000)
	elif n/100 > 0 :
		return num_to_words(n/100) + "Hundred " + num_to_words(n%100)
	elif n/10 > 1 : 
		return replace(n/10*10) + " " + num_to_words(n%10)
	elif n > 0 :
		return replace(n) + " "
	else :
		return ""
				
t = int(raw_input())
while t > 0 :
	n = int(raw_input())
	if n == 0 :
		print "Zero"
	else :
		print num_to_words(n)
	t = t - 1 