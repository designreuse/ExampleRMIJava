/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.network;

import java.io.Serializable;

/**
 *
 * @author andrea
 */
public class Message implements Serializable {
    
    /* contenuto vero e proprio del messaggio */
    private Object payload;
    
    /* identificativo univoco del player che invia il messaggio messaggio */
    private int id;
    
    public Message(Object o, int id){
        this.payload = o;
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public Object getPayload(){
        return this.payload;
    }

}
