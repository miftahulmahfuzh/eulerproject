import java.io.*;
class testprime {
	public static void main (String[] args) {
		Boolean found = false;
		int i = 0,y = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String S = br.readLine();
			int x = Integer.parseInt(S);
			for(i=1;i<=x && !found;i++) {
				S = br.readLine();
				y = Integer.parseInt(S);
				if(y>4) {
					int j=3;
					while(j<(int)Math.sqrt(y) && y%j!=0)
						j+=2;
					if(y%j==0 && y!=j) found = true;
				}
			}
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		if(found) 
			System.out.println("Found on (row,x) : "+i+','+y);
		else 
			System.out.println("Not Found");
	}
}