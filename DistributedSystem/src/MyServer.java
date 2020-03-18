import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		try{  
			ServerSocket ss=new ServerSocket(2957);  
			Socket s=ss.accept();  
			DataInputStream dis=new DataInputStream(s.getInputStream()); 
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			String str=(String)dis.readUTF();  
//			System.out.println("Hello"+str);
			String[] opt = str.split(" ");
			
			if(opt[0].equals("1")) {
//				System.out.println(opt[0]);
				int a =Integer.parseInt(opt[1]);
				int b = Integer.parseInt(opt[2]);
				dout.writeUTF(Integer.toString(a+b));
				
			}else if(opt[0].equals("2")){
//				System.out.println(opt[1]);
				dout.writeUTF(fact(opt[1]));
				
			}else {
//				System.out.println(opt[0]);
				dout.writeUTF(getBinary(opt[1]));
				
			}
			dout.flush();
			dout.close();
			s.close();
			ss.close();  
		}catch(Exception e){
			System.out.println(e);
		}  
	}
	public static String fact(String s) {
		int n = Integer.parseInt(s);
		int ans = 1;
		while(n>0) {
			ans = ans*n;
			n--;
		}
		return Integer.toString(ans);
	}
	public static String getBinary(String s) {
		int n = Integer.parseInt(s);
		String ans = "";
		while(n>=0) {
			if(n%2==0) {
				ans+="0";
			}else {
				ans+="1";
			}
			n=n/2;
		}
		StringBuilder sans = new StringBuilder(ans); 
		return sans.reverse().toString();
	}

}
