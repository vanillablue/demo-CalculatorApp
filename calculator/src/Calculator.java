import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		// get input
		System.out.println("Please enter the expression: ");
		Scanner sc= new Scanner(System.in); 
		String exp = sc.nextLine();
		//"12435+34569-12345*10+50";
		Calculator cal = new Calculator();	
		System.out.println ("Result ="+cal.calculator(exp));
				
	}
		
	public int calculator(String exp)
	{
		int n = exp.length();
		double  num1=0;
		double  num2=0;
		int fl1 = 0;
		int fl2 = 0;
		double result = 0;
		char op = ' ';		
		char op2 = ' ';
		
		//parse string
		for(int id=0;id<n;id++)
		{
			char ch =exp.charAt(id);
			
			// get first operand (num1)
			if(ch>='0'&&ch<='9'&&fl1==0)
			{
				num1 = num1*10+Character.getNumericValue(ch);  
			}
			//get second operand (num2)
			else if(ch>='0'&&ch<='9'&&fl1==1)
			{
				num2 = num2*10+Character.getNumericValue(ch); 

			}
			//get the operator
			else if(ch=='+'||ch == '-'||ch =='*')	
			{
				
				if(fl1==0 && fl2 ==0)
				{
					fl1 = 1;
					op = ch;
				}
				else if(fl1 ==1 && fl2 == 0)
				{
					fl2 = 1;
					op2 = ch;
				}
				
			}
			// display error message and break from the program in case of unrecognisable characters.
			else
			{
				System.out.println("Invalid expression: Character '"+ ch +"' cannot be parsed");
				break;
			}	
			
			//perform operation : num1 op num2
			if((fl1==1 && fl2==1)||id ==(n-1))
			{
				
				if(op == '+')
				{
					result = num1+num2;
				}
				else if(op == '-')
				{
					result = num1-num2;
				}
				else 
				{
					result = num1*num2;
				}
				num1 = result;
				num2 = 0;
				fl2 = 0;
				if(id!=(n-1))
				{op=op2;}
				else
				{
					return ((int)result);
				}
			}
		}
		return 0;

	}	

}
