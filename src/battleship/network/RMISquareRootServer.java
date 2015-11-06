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
        implements ISquareRoot {

    private Registry registry;

    public RMISquareRootServer() throws RemoteException {

    }

    public double calculateSquareRoot(double aNumber) {
        return Math.sqrt(aNumber);
    }
    
    public double calculatePowerTwo(double aNumber) {
        return (aNumber*aNumber);
    }
    
    public static void main(String[] args) throws UnknownHostException, SocketException, RemoteException, AlreadyBoundException {
        
        int PORT = Integer.parseInt(args[0]);
        String ipserver = NetUtils.getInstance().getHostAddress();
        System.out.println("Server IP : " + ipserver + "  in ascolto sulla porta "+PORT+"....");
        System.setProperty("java.rmi.server.hostname", ipserver);
        System.setProperty("java.rmi.disableHttp", "true");
        ISquareRoot server = new RMISquareRootServer();
        //Registry registry1 = LocateRegistry.getRegistry();
        Registry registry1 = LocateRegistry.createRegistry(PORT);
        registry1.bind("RMISquareRoot", server);

    }
}
