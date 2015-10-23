/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.logic;

import battleship.network.NetUtils;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrea
 */
public class Player {
    
    private String username;
    
    private String IP;
    
    public Player(String u, String ip){
        this.username = u;
        this.IP = ip;
    }
    
    public Player(String u){
        this.username = u;
        try {
            this.IP = NetUtils.getInstance().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
