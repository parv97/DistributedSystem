package Assignment3;

import java.rmi.Naming;
public class Calclaint
{
	public static void main(String arg[])
	{
		try{
			Calc c=(Calc)Naming.lookup("//127.0.0.1:1099/calcservice");
			System.out.println("Addition:"+c.addition(10,5));
			System.out.println("subtraction:"+c.subtraction(10,5));
			System.out.println("Multiplication:"+c.multiplication(10,5));
			System.out.println("Divition:"+c.divition(10,5));
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
	}
}
