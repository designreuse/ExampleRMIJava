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
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMISquareRootClient
{
 public static void main(String[] args) {
  int x = Integer.parseInt(args[0]);

  try
  {
   ISquareRoot squareServer = null;
      try {
          squareServer = (ISquareRoot) Naming.lookup ("rmi://"+NetUtils.getInstance().getHostAddress()+"/RMISquareRoot");
      } catch (UnknownHostException ex) {
          Logger.getLogger(RMISquareRootClient.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SocketException ex) {
          Logger.getLogger(RMISquareRootClient.class.getName()).log(Level.SEVERE, null, ex);
      }

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
