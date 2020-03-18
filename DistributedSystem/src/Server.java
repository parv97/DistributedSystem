import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();//establishes connection
            System.out.println("New client connected");
            DataOutputStream output=new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);
            //Thread.sleep(10000);
            writer.println(new Date().toString());
        }catch(Exception e){System.out.println(e);}
    }
}