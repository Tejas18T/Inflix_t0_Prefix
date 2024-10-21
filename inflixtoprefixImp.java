package inflixtoprefix;

public class inflixtoprefixImp {
	private int size;
	private int top1;
	private int top2;
	private char stack1[];
	private String stack2[];
	
	
	inflixtoprefixImp()
	{
		size=0;
		top1=-1;
		top2=-1;
	}
	inflixtoprefixImp(String str)
	{
		size=str.length();
		top1=-1;
		top2=-1;
		stack1=new char[size];
		stack2=new String[size];
	}
	public boolean IsFull1()
	{
		return (top1==size-1);
	}
	public boolean IsFull2()
	{
		return (top2==size-1);
	}
	public boolean IsEmpty1()
	{
		return (top1==-1);
	}
	public boolean IsEmpty2()
	{
		return (top2==-1);
	}
	
	public void push1(char data)
	{
		if(!IsFull1())
		{
		  stack1[++top1]=data;
		}	
		else
		{
			System.out.println("Stack Overflow!!");
		}
		
	}
	public void push2(String data)
	{
		if(!IsFull2())
		{
		  stack2[++top2]=data;
		}	
		else
		{
			System.out.println("Stack Overflow!!");
		}
		
	}
	public char pop1()
	{
		char a='\0';
		if(!IsEmpty1())
		{
			return stack1[top1--];
		}
		return a;
	}
	public char peek1()
	{
		char a='\0';
		if(!IsEmpty1())
		{
			return stack1[top1];
		}
		return a;
	}
	public String pop2()
	{
		String str="";
		if(!IsEmpty2())
		{
			return stack2[top2--];
		}
		return str;
	}
	
	public boolean Isoperand(char c)
	{
		return ((c>='A' && c<='Z') ||(c>='a' && c<='z'));
	}
	public boolean Isoperator(char c)
	{
		return (c=='(' || c==')' || c=='/' || c=='*' || c=='+' || c=='-');
	}
	public int Setprecedence(char c)
	{
		switch(c)
  		{
		case '$':
			    return 4;
  		case '*':
  		case '/':
  		case '%':
  			return 3;
  			
  		case '+':
  		case '-':
  		    return 2;
       
  		case '(':
  			 return 1;
  		case ')':
  			return 0;
  		}
		return -1;
		
	

	}
	public String ConvertIntoPost(String str)
	{
		String str1="";
		char ch,ch1;
		
		for(int i=0;i<str.length();i++)
		{
			ch=str.charAt(i);
			if(Isoperand(ch))
			{
			    str1="";
			    str1+=ch;
			    push2(str1);
			    
			}
			else if(Isoperator(ch))
			{
				if(ch=='(')
				{
					push1(ch);
				}
				else if(ch==')')
				{
					 
				     while(peek1()!='(')
				     {
				    	 str1="";
				    	 ch1=pop1();
				    	 //String s1 = s1.valueOf(ch1);
				    	 if(top2>=1)
				    	 {
					    	 String ch3=pop2();
					    	 String ch2=pop2();
					    	 
					    	 str1+=ch1;
					    	 str1+=ch2;
					    	 str1+=ch3;
					    	 push2(str1);
				    	 }
				     }
				     pop1();
				}
			
			
				else if(IsEmpty1())
				{
					push1(ch);
				}
				else if(peek1()=='(')
				{
					push1(ch);
				}
				else if(Setprecedence(peek1()) < Setprecedence(ch))
				{
					push1(ch);
				}
				else {
					while((Setprecedence(peek1()) >= Setprecedence(ch)))
					{
						str1="";
						if(top2>=1)
				    	{
							ch1=pop1();
							String ch3=pop2();
					        String ch2=pop2();
					    	str1+=ch1;
					    	str1+=ch2;
					    	str1+=ch3;
					    	push2(str1);
				    	}
					}
					push1(ch);
				}
			}
			
		}//for
		while(!IsEmpty1()) 
		{
			str1="";
			ch1=pop1();
			//System.out.println(ch1);
			if(ch1 !=')' && ch1!='(' )
			{
				if(top2>=1)
		    	{
					String ch3=pop2();
			        String ch2=pop2();
					str1+=ch1;
			    	str1+=ch2;
			    	str1+=ch3;
			    	push2(str1);
		    	}
			}
			else
			{
				String s="str";
				return s ;
			}
		}
		
		
		String str4=pop2();
		return str4;
		
	}
	
}
