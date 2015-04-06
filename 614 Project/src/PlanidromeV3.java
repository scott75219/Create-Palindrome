import java.util.Scanner;


public class PlanidromeV3 {

	static String Palindrome="";
	public static void main(String[] args) {
		Scanner user_input= new Scanner (System.in);
		System.out.print("Please enter a sequence: ");
		String seq=user_input.nextLine();
		
		if(Check(seq)==true)
		{
			System.out.println(seq+" is a palindrome, no additional moves needed");
		}
		
		else
		{
			//	System.out.println(seq+" is not a palindrome");
			System.out.println(Insertions(seq)+" moves");
			System.out.println(Palindrome);


		}

	}

	public static int Insertions(String seq)
	{
		String RightPal=seq;
		String LeftPal=seq;
		
		LeftPal=MakePal(seq,0);
		RightPal=MakePal(seq,1);
		
		int moves=0;
		while(true)
		{
			if(Check(LeftPal))
			{
				break;
			}
			else
			{
				LeftPal=MakePal(LeftPal,0);
			}
		}
		
		while(true)
		{
			if(Check(RightPal))
			{
				break;
			}
			else
			{
				RightPal=MakePal(RightPal,1);
				
			}
		}
		int Leftmoves=LeftPal.length()-seq.length();
		int Rightmoves=RightPal.length()-seq.length();
		
		if(Leftmoves<Rightmoves)
		{
			moves=Leftmoves;
			Palindrome=RightPal;
		}
		
		else if(Leftmoves>=Rightmoves)
		{
			moves=Rightmoves;
			Palindrome=RightPal;
		}

		return moves;
		
	}
	
	public static String MakePal(String seq,int side)
	{
		if(Check(seq)==true)
		{
			System.out.println("True: "+seq);
			return seq;
		}
		//0=insert on left side
		//1=insert on right side
	    StringBuilder str = new StringBuilder(seq);
	       int front=0;
	       int tail=seq.length()-1; //otherwise will get index out of bounds
	       
	       while(front<tail)
	       {
	    	   if(seq.charAt(front)!=seq.charAt(tail))
	    	   {
	    		   if(side==0)
	    		   {
		    		   str.insert(front, seq.charAt(tail));
		    		   break;
	    		   }
	    		   if(side==1)
	    		   {
		    		   str.insert(tail+1, seq.charAt(front));
		    		   break;
	    		   }
	    	   }
	    	   tail--;
	    	   front++;
	       }
	       return str.toString();
	}
	public static boolean Check(String seq)
	{
       int front=0;
       int tail=seq.length()-1; //otherwise will get index out of bounds
       
       for (int i=front;i<tail;i++)
       {
    	   if(seq.charAt(front)!=seq.charAt(tail))
    	   {
    		   return false;
    	   }
    	   tail--;
    	   front++;
       }
	   return true;
	
	}

}
