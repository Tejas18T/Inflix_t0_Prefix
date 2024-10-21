package inflixtoprefix;

import java.util.Scanner;



public class inflixtoprefixapp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.err.println("Enter Inflix String:");
		String st=sc.next();
		inflixtoprefixImp S1=new inflixtoprefixImp(st);
		String str=S1.ConvertIntoPost(st);
		if(str.length()==0)
		{
			System.err.println("Invalid Operatrion");
		}
		else
		{
			System.err.println("Preflix Expression: "+str);
		}
		
		

	}
}
