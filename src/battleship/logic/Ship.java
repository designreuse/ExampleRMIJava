/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.logic;

/**
 *
 * @author andrea
 */
public class Ship {
    
    /* lunghezza della nave */
    private int size;
    /* coordinata x, indica un estremo della nave sulla tabella di gioco */
    private int x;
    /* coordinata y, indica un estremo della nave sulla tabella di gioco */
    private int y;
    /* direzione che indica se la nave è posta in orizzontale o vertizale*/
    private String direction;
    
    
    public Ship(int s){
        this.size = s;
    }
    
    private void setX(int x){
        this.x = x;
    }
    
    public int getX(){
        return this.x;
    }
    
    private void setY(int y){
        this.y = y;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setDirection(String d){
        this.direction = d;
    }
    
    public String getDirection(){
        return this.direction;
    }
    
    public void setPosition(int x, int y, String D){
        this.setX(x);
        this.setY(y);
    }
    
}
