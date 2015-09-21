import java.util.Scanner;
class Solution {
static String replace(long x) {
	if( x == 1 )
		return "One";
	else if( x == 2) 
		return "Two";
	else if( x == 3 )
		return "Three";
	else if( x == 4 )
		return "Four";
	else if( x == 5 )
		return "Five";
	else if( x == 6 )
		return "Six";
	else if( x == 7 )
		return "Seven";
	else if( x == 8 )
		return "Eight";
	else if( x == 9 )
		return "Nine";
	else if( x == 10 )
		return "Ten";
	else if( x == 11 )
		return "Eleven";
	else if( x == 12 )
		return "Twelve";
	else if( x == 13 )
		return "Thirteen";
	else if( x == 15 )
		return "Fif(teen";	
	else if( x == 18 )
		return "Eighteen";
	else if( x >= 14 && x <= 19 )
		return replace(x%10) + "teen";
	else if( x == 20 )
		return "Twenty";
	else if( x == 30)
		return "Thirty";
	else if( x == 40 )
		return "Forty";
	else if( x == 50 )
		return "Fifty";
	else if( x == 60 )
		return "Sixty";
	else if( x == 70 )
		return "Seventy";
	else if( x == 80 )
		return "Eighty";
	else if( x == 90 )
		return "Ninety";
	else 
		return "";
}

static String num2Words(long n) {
	if( n/1000000000000L > 0 )
		return num2Words(n/1000000000000L) + " Trillion" + num2Words(n%1000000000000L);
	else if( n/1000000000L > 0) 
		return num2Words(n/1000000000L) + " Billion" + num2Words(n%1000000000L);
	else if( n/1000000 > 0 )
		return num2Words(n/1000000) + " Million" + num2Words(n%1000000) ;
	else if( n/1000 > 0 )
		return num2Words(n/1000) + " Thousand" + num2Words(n%1000);	
	else if( n/100 > 0 )
		return num2Words(n/100) + " Hundred" + num2Words(n%100);
	else if( n/10 > 1  )
		return " " + replace(n/10*10) + num2Words(n%10);
	else if( n > 0 )
		return " " + replace(n);
	else 
		return "";
}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0) {
			long n = s.nextLong();
			System.out.println(num2Words(n).substring(1));
		} 
	}
}