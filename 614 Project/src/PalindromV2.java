import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PalindromV2 {
static int Moves=0;
static String Palindrome="";
	
	public static void main(String[] args) 
	{
		
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
			System.out.println(Calculate(seq)+" moves");
			System.out.println(Palindrome);


		}

	}
	
	
	
	public static int Calculate(String seq) 
	{
		int moves=1;
		while(true){
	        ArrayList<String> seqs=BreakDown(seq,moves);
	        System.out.println(seqs);
	        seq=join(seqs,",");

	        if(SendCheck(seqs)){
	            return moves;
	        }
	        else
	            moves++;
	    }
	}
	
	public static ArrayList<String> BreakDown(String seq,int remove)
	{
        ArrayList<String> list=new ArrayList<String>();
        if(remove==1){
	        for (int i=0;i<seq.length();i++)
	        {
	        	String tester="";
	        	for(int j=0;j<seq.length();j++)
	        	{	        		
		        	if(j!=i)
		        	{
			        	 tester+=seq.charAt(j);

		        	}
	        	}
	         	list.add(tester);
	        }

        }
        
        else
        {
        	List<String> seqsList = Arrays.asList(seq.split("\\s*,\\s*"));
        	for(int i=0;i<seqsList.size();i++)
        	{
        		String temp=seqsList.get(i);
        		for (int j=0;j<temp.length();j++)
    	        {
        			String tester1="";
        			for(int k=0;k<temp.length();k++)
    	        	{	        		
        				if(j!=k)
    		        	{
    			        	 tester1+=temp.charAt(k);

    		        	}
    	        	}
		         	list.add(tester1);	
    	        }
        	}
        	
        }
        
        return list;

	}

	public static boolean SendCheck(ArrayList<String> seqs)
	{
		boolean containsPal=false;
		for(String seq:seqs){
	        if(Check(seq)){
	        	System.out.println(seq);
	        	MakePalindrome(seq);
	            return true;
	        }
	    }

		return containsPal;
		
	}
	public static void MakePalindrome(String seq)
	{
        String back=seq;
		String front = new StringBuffer(seq).reverse().toString();

        String reverse = new StringBuffer(seq).reverse().toString();
		boolean IsPalindrome=false;
		int length=seq.length();
		int half=length/2;
		
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
	
	public static String join(List<String> list, String delim) {

	    StringBuilder sb = new StringBuilder();

	    String loopDelim = "";

	    for(String s : list) {

	        sb.append(loopDelim);
	        sb.append(s);            

	        loopDelim = delim;
	    }

	    return sb.toString();
	}

}
