/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class RMISquareRootClient
{
 public static void main(String[] args) {
  int x = Integer.parseInt(args[0]);

  try
  {
   ISquareRoot squareServer =
      (ISquareRoot) Naming.lookup ("rmi://192.168.43.185/RMISquareRoot");

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
  catch(MalformedURLException e)
  {
   e.printStackTrace( );
  }
 }
} 
