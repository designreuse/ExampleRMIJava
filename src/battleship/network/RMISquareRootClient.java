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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMISquareRootClient
{
 public static void main(String[] args) throws RemoteException, NotBoundException {
     
  String IP_SERVER = args[0];
  int PORT = Integer.parseInt(args[1]);
  int x = Integer.parseInt(args[2]);
  System.out.println("avvio richiesta del client");
  

   ISquareRoot squareServer = null;
   //squareServer = (ISquareRoot) Naming.lookup ("rmi://"+IP_SERVER+"/RMISquareRoot");
   Registry register = LocateRegistry.getRegistry(IP_SERVER, PORT);
   squareServer = (ISquareRoot) register.lookup("RMISquareRoot");
   
   Scanner scanner=new Scanner(System.in);
    while (true) {
        System.out.println("[INPUT] Insert code operations:");
        String question = scanner.nextLine();
        if(question.equals("q")){
            break;
        }
        else if(question.equals("1")){
            System.out.println("[INPUT] Insert number for operations 1:");
            x = Integer.parseInt(scanner.nextLine());
            double result = squareServer.calculateSquareRoot(x) ;
            System.out.println(result);
        }
        else if(question.equals("2")){
            System.out.println("[INPUT] Insert number for operations 2:");
            x = Integer.parseInt(scanner.nextLine());
            double result = squareServer.calculatePowerTwo(x) ;
            System.out.println(result);
        }
    } 
 }
} 
