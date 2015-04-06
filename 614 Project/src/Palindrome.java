import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Palindrome {
static int Moves=0;

	
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
			System.out.println(Make(seq));
			System.out.println("In "+Moves+" moves");


		}

	}
	
	
	public static String Make(String seq)
	{
		String sequence="";

		String addOn="";
		String temp=seq;
		//check big O notation for this
		List<Character> list = new ArrayList<Character>();
		int length=seq.length();
		int head=0;
		int tail=length;
		int half=length/2;
		
		String front=seq.substring(0,half);
		String back=seq.substring(half);
		
		while(!Check(temp))
		{
			System.out.print(temp+"  "+Check(temp)+"  "+addOn);
			for (int i = 0; i < list.size(); i++) {int value = list.get(i);System.out.print(list.get(i));}

			System.out.println("");
			list.add(seq.charAt(head));
			head++;
			temp=seq.substring(head);

		}
		System.out.print(temp+"  "+Check(temp)+"  "+addOn + " ");
		
		for (int i = 0; i < list.size(); i++) {int value = list.get(i);System.out.print(list.get(i));}
		
		System.out.println("");
		sequence=temp;
		Moves=list.size();
		while(list!=null&&list.size()!=0)
		{
	//		System.out.println((list.size()));
			char el=list.remove(list.size()-1);
			sequence=el+sequence+el;
	//		System.out.println(sequence);
		}
		   return sequence;

	
	}

	
	
	public static boolean Check(String seq)
	{
        String reverse = new StringBuffer(seq).reverse().toString();
		boolean IsPalindrome=false;
		int length=seq.length();
		int half=length/2;
		
		for(int i=0;i<half;i++)
		{
			if(seq.charAt(i)==reverse.charAt(i))
			{
				IsPalindrome=true;
				
			}
			
			else
			{
				IsPalindrome=false;
			}
		}
	
		if(seq.length()==1){IsPalindrome=true;}
		return IsPalindrome;
		
	
	}

}
