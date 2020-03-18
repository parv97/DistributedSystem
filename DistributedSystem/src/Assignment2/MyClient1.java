package Assignment2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{      
			Socket s=new Socket("localhost",6656);  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream din=new DataInputStream(s.getInputStream());
			dout.writeUTF("Client 2");
			dout.flush();
			String server_string=(String) din.readUTF();
			System.out.println("Output sent by server : \n"+server_string);
			dout.close();  
			s.close();  
			}catch(Exception e){System.out.println(e);} 
	}

}
