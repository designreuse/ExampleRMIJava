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
    ISquareRoot server = new RMISquareRootServer();
    System.setProperty("java.rmi.server.hostname",NetUtils.getInstance().getHostAddress());
    System.setProperty("java.rmi.disableHttp","true");
    
    Registry registry1 = LocateRegistry.getRegistry();
    registry1.bind("RMISquareRoot", server);
    
    /*
    
     try {
         System.out.println("IP della macchina server:"+NetUtils.getInstance().getHostAddress());
     } catch (UnknownHostException ex) {
         Logger.getLogger(RMISquareRootServer.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SocketException ex) {
         Logger.getLogger(RMISquareRootServer.class.getName()).log(Level.SEVERE, null, ex);
     }
  try
  {
   ISquareRoot server = new RMISquareRootServer();
        try {
       try {
           Naming.rebind("//"+NetUtils.getInstance().getHostAddress()+"/RMISquareRoot",server);
       } catch (MalformedURLException ex) {
           Logger.getLogger(RMISquareRootServer.class.getName()).log(Level.SEVERE, null, ex);
       }
        } catch (UnknownHostException ex) {
            Logger.getLogger(RMISquareRootServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(RMISquareRootServer.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  catch (RemoteException e){e.printStackTrace( );}
            */
 }
} 
