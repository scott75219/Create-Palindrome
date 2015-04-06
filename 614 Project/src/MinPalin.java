import java.util.*;
import java.io.*;
public class MinPalin{

//Function to check if a string is palindrome
public boolean isPaindrome(String s){
    int beg=0;
    int end=s.length()-1;

    while(beg<end){
        if(s.charAt(beg)!=s.charAt(end)){
            return false;

        }
        beg++;
        end--;
    }
    System.out.println(s);

    return true;

}

public int MinInsert(String s){
    int min=0;
    if(isPaindrome(s)){
        return min;
    }

    min++;

    while(true){
        ArrayList<String> temp=comboes(s,min);
        if(hasPalindrome(temp)){
            return min;
        }
        else
            min++;
    }

}

/*
 * Returns an arraylist of strings, in which n characters are removed
* 
*/

public ArrayList<String> comboes(String s,int n){

    ArrayList<String> results=new ArrayList<String>();


    if(n==1){

        for(int i=0;i<s.length();i++){
            String text="";
            for(int j=0;j<s.length();j++){
                if(i!=j){

                    text=text+""+s.charAt(j);
                }


            }
            results.add(text);
        }

    }
    else{
        ArrayList<String> temp=new ArrayList<String>();

        for(int i=0;i<s.length();i++){
            String tempString="";
            for(int j=0;j<s.length();j++){
                if(i!=j){
                    tempString=tempString+s.charAt(j);

                }
            }
            temp=comboes(tempString, n-1);
            for(int j=0;j<temp.size();j++){
                results.add(""+temp.get(j));
            }
        }
    }
    return results;


}

public boolean hasPalindrome(ArrayList<String> text){
    System.out.println(text);

	for(String temp:text){
        if(isPaindrome(temp)){
            return true;
        }
    }

    return false;
}

public static void main(String[] args)throws IOException
 {
     System.out.println("Enter the word :");
     MinPalin obj=new MinPalin();
     BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
     int n=obj.MinInsert(r.readLine());
     System.out.println("Characters needed : "+n);
    }
}