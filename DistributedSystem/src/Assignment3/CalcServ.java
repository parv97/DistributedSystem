package Assignment3;
import java.rmi.Naming;
public class CalcServ
{
	CalcServ()
	{
	try{
		Calc c= new CalciImpl();
		Naming.rebind("rmi://localhost:1099/calcservice",c);
	}
	catch(Exception e)
	{
		System.out.println("Exception:"+e);
	}
	}
	public static void main(String arg[])
	{
		new CalcServ();
	}
}


