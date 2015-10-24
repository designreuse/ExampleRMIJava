package battleship.logic;

import battleship.network.NetUtils;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author andrea sghedoni
 * @class Player
 */
public class Player {
    
    /* username che l'utente usa all'iscrizione del gioco*/
    private String username;
    
    /* stringa dell'IP del giocatore */
    private String IP;
    
    /* costruttore inizializzato con username ed IP*/
    public Player(String u, String ip){
        this.username = u;
        this.IP = ip;
    }
    
    /* costruttore che inizializza con username, mentre l'IP viene preso automaticamente dopo*/
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
    
    /* getter username*/
    public String getUsername(){
        return this.username;
    }
    
    /* setter username*/
    public void setUsername(String u){
        this.username = u;
    }
    
    /* getter indirizzo ip*/
    public String getIP(){
        return this.username;
    }
    
    /* setter indirizzo ip*/
    public void setIP(String ip){
        this.IP = ip;
    }
    
}
