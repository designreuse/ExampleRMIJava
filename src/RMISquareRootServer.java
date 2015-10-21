/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RMISquareRootServer extends UnicastRemoteObject
  implements ISquareRoot
{
 public RMISquareRootServer()throws RemoteException
 {
  
 }
 
 public double calculateSquareRoot(double aNumber)
 {
  return Math.sqrt( aNumber);
 }
 
 public static void main(String[] args)
 {
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
   Naming.rebind("//192.168.43.185/RMISquareRoot",server);
  }
  catch (RemoteException e){e.printStackTrace( );}
  catch (MalformedURLException e) {e.printStackTrace( );}
 }
} 
