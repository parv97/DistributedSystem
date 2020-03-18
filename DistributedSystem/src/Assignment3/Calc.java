package Assignment3;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Calc extends Remote
{
	public long addition(long a,long b)throws RemoteException;
	public long subtraction(long a,long b)throws RemoteException;
	public long multiplication(long a,long b)throws RemoteException;
	public long divition(long a,long b)throws RemoteException;
}

