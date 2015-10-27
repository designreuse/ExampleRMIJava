package battleship.network;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RMISquareRootServer extends UnicastRemoteObject
  implements ISquareRoot
{
    
    private Registry registry;
    
 public RMISquareRootServer()throws RemoteException
 {
  
 }
 
 public double calculateSquareRoot(double aNumber)
 {
  return Math.sqrt( aNumber);
 }
 
 public static void main(String[] args) throws UnknownHostException, SocketException, RemoteException, AlreadyBoundException
 {
    
    String ipserver = NetUtils.getInstance().getHostAddress();
    System.out.println("Server IP : "+ipserver+"  in ascolto...");
    System.setProperty("java.rmi.server.hostname", ipserver);
    System.setProperty("java.rmi.disableHttp","true");
    ISquareRoot server = new RMISquareRootServer();
    //Registry registry1 = LocateRegistry.getRegistry();
    Registry registry1 = LocateRegistry.createRegistry(1234);
    registry1.bind("RMISquareRoot", server);
    
 }
} 
