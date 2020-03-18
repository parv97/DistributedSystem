import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",6666);
            //s.setSoTimeout (5000);
            DataInputStream input=new DataInputStream(s.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String time = reader.readLine();
            System.out.println(time);
        }
        catch (InterruptedIOException iioe)
        {
            System.err.println ("Remote host timed out during read operation");
        }
        catch (IOException ioe)
        {
            System.err.println ("Network I/O error - " + ioe);
        }
    }
}