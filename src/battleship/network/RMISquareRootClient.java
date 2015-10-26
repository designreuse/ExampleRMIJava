package battleship.network;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMISquareRootClient
{
 public static void main(String[] args) {
     
  String IP_SERVER = args[0];
  int x = Integer.parseInt(args[1]);
  System.out.println("avvio richiesta del client");
  
  try
  {
   ISquareRoot squareServer = null;
   //squareServer = (ISquareRoot) Naming.lookup ("rmi://"+IP_SERVER+"/RMISquareRoot");
   Registry register = LocateRegistry.getRegistry(IP_SERVER);
   squareServer = (ISquareRoot) register.lookup("RMISquareRoot");
   
   double result = squareServer.calculateSquareRoot(x) ;
   System.out.println(result);
  }
  catch(NotBoundException e)
  {
   e.printStackTrace( );
  }
  catch(RemoteException e)
  {
   e.printStackTrace( );
  }
 }
} 
