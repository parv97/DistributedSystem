package Assignment2;

import java.io.*; 
import java.net.*; 
  
// Server class 
public class MyServer  
{ 
    public static void main(String[] args) throws IOException  
    { 
        // server is listening on port 5056 
        ServerSocket ss = new ServerSocket(6656); 
          
        // running infinite loop for getting 
        // client request 
        while (true)  
        { 
            Socket s = null; 
              
            try 
            { 
                // socket object to receive incoming client requests 
                s = ss.accept(); 
                   
                  
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
 
  
                // create a new thread object 
                Thread t = new ClientHandler(s, dis, dos); 
  
                // Invoking the start() method 
                t.start(); 
                  
            } 
            catch (Exception e){ 
                s.close(); 
                e.printStackTrace(); 
            } 
        } 
    } 
} 
  
// ClientHandler class 
class ClientHandler extends Thread  
{  
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
    static String str = "";  
  
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)  
    { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
    } 
  
    @Override
    public void run()  
    { 
        String received; 
         
         
            try { 
  
                received = dis.readUTF(); 
                str+=received+"\n";  
                dos.writeUTF("Total connected clients are : \n"+str);
                
                    this.s.close(); 
                 
                    this.dis.close(); 
                    this.dos.close();                   
                 
                 
            } catch (IOException e) { 
                e.printStackTrace(); 
            }
         
          
        
    } 
} 