import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{      
			Socket s=new Socket("localhost",2957);  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream din=new DataInputStream(s.getInputStream());
			int choice = -1;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your choice : ");
			choice=Integer.parseInt(br.readLine());
			String inp = Integer.toString(choice)+" ";
			switch(choice) {
			case 1: System.out.println("Enter two numbers to be added : ");
					break;
			case 2: System.out.println("Enter a number to get factorial : ");
					break;
			case 3 : System.out.println("Enter a decimal number : "); 
					break;
			default: System.out.println("Enter a valid operation!");
			}
			inp += br.readLine();
			dout.writeUTF(inp);  
			  
			
			String opt=(String) din.readUTF();
			System.out.println("Output sent by server : "+opt);
			dout.flush();
			dout.close();  
			s.close();  
			}catch(Exception e){System.out.println(e);}  
	}

}
