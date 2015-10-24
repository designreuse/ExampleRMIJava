/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.logic;

/**
 * @author andrea
 * @class GameTable
 */
public class GameTable {
    
    /* Tabella di gioco relativa alla posizione/situazione delle proprie navi */
    private static final String TYPE_POSITION_SHIPS = "TYPE_POSITION_SHIPS";
    /* Tabella di gioco relativa alla posizione/situazione dei colpi già sparati dai players */
    private static final String TYPE_POSITION_SHOTS = "TYPE_POSITION_SHOTS";
    /* Lunghezza della tabella/matrice che sarà in base a quanti players partecipano */
    private int size;
    /* Matrice con i flag della situazione di gioco */
    private int[][] matrix;
    /* Indica se la tabella è di tipo TYPE_POSITION_SHIPS oppure TYPE_POSITION_SHOTS */
    private String type;
    
    public GameTable(int size, String t){
        this.size = size;
        this.matrix = new int[this.size][this.size];
        if(t.equals(TYPE_POSITION_SHIPS) || t.equals(TYPE_POSITION_SHOTS))
            this.type = t;
        //else
            //rilancia eccezione mia personale
    }
    
    /* Pone tutti i valori della matrice a -1 */
    public void resetMatrix(){
        for (int i=0; i<this.size; i++)
            for(int j=0; j<this.size; j++)
                this.matrix[i][j] = -1;
    }
    
    /* Ritorna il tipo di tabella(se quella per colpi o quella per navi) */
    public String getType(){
        return this.type;
    }
    
    /* Ritorna la Matrice */
    public int[][] getMatrix(){
        return this.matrix;
    }
    
    /* Date riga e colonna, torna il valore della matrice in quel punto */
    public int getValuePosition(int i, int j){
        return this.matrix[i][j];
    }
    
    /* Date riga, colonna ed un valore v, setta con v il valore della matrice in quel punto */
    public void setValuePosition(int i, int j, int v){
        this.matrix[i][j] = v;
    }
    
    /* Date riga e colonna, indica se la cella è ancora vuota o meno */
    public boolean isEmpty(int i, int j){
        return this.matrix[i][j] == -1;
    }
    
}
