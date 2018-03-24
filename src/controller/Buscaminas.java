/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Objects.Celda;
import Objects.Estado;
import Objects.GameEst;
import java.util.Random;

/**
 *
 * @author cavr0
 */
public class Buscaminas {
    private Celda tablero[][];
    private Integer dimx;
    private Integer dimy;
    private Integer minas;
    private GameEst juego;
    private boolean juegoOn;
    
    
    
    public Buscaminas(Integer x,Integer y,Integer m){
        tablero=new Celda[x][y];
        dimx=x;
        dimy=y;
        minas=m;
        juego=GameEst.Sigue;
        this.juegoOn=true;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                tablero[i][j]=new Celda(i,j);
            }
        }
        colocarMinas();
       
        
    }
    private void colocarMinas(){
        Random random = new Random();
        int contador = 0;
        while(contador<minas){
            int xx = random.nextInt(this.dimx);
            int yy = random.nextInt(this.dimy);
            if (!(tablero[xx][yy]).isMina()) {
                tablero[xx][yy].setMina(true);
                contador++;
            }
        }
    }
    
    public Integer getDimx() {
        return dimx;
    }

    public void setDimx(Integer dimx) {
        this.dimx = dimx;
    }

    public Integer getDimy() {
        return dimy;
    }

    public void setDimy(Integer dimy) {
        this.dimy = dimy;
    }
    public Celda[][] getTablero(){
        return tablero;
    }
    
    public void abrirCelda(Integer x, Integer y){
        if(celdaOK(x,y)){
            if((!tablero[x][y].isMina())){
                if(tablero[x][y].getEstado()==Estado.CERRADO){
                    tablero[x][y].setEstado(Estado.ABIERTO);
                }
                int mina = cantMinas(x,y);
                tablero[x][y].setNumero(mina);
                if(mina == 0){
                    for (int i = x-1; i <=x+1; i++) {
                        for (int j = y-1; j <= y+1; j++) {
                            if(celdaOK(i,j) && tablero[i][j].getEstado()== Estado.CERRADO){
                                abrirCelda(i,j);                           
                            }
                        }
                    }
                }
            }else if(tablero[x][y].getEstado() == Estado.CERRADO){
                looser(x, y);

            }
        }
    }
    public boolean winner(){
        boolean resultado = true;
        for (int i = 0; i < dimy; i++) {
            for (int j = 0; j < dimx; j++) {
                if ( (tablero[j][i].getEstado() != Estado.ABIERTO) &&(!tablero[j][i].isMina() ) ){
                    return false;
                }
            }
        }      
        if (resultado == true){
            juegoOn = false;
            juego = GameEst.Win;  
            System.out.println("Ganaste");
        }
        return resultado;
    }
    public void looser(Integer x, Integer y){
        juegoOn=false;
        tablero[x][y].setEstado(Estado.BOOM);
        System.out.println("Perdiste");
        juego= GameEst.Lose;
        for(int i=0; i<dimx; i++){
            for(int j=0; j<dimy; j++){
                if(tablero[i][j].isMina() && tablero[i][j].getEstado()==Estado.CERRADO){
                    tablero[i][j].setEstado(Estado.MINA);
                }
                if(tablero[i][j].getEstado()==Estado.BANDERA && !tablero[x][y].isMina()){
                    tablero[i][j].setEstado(Estado.BANDERAMALA);
                }  
            }
        }
    }
    public void resultados(){
         for (int i = 0; i < dimy; i++) {
            for (int j = 0; j < dimx; j++) {
                if ( tablero[j][i].getEstado()!= Estado.ABIERTO){
                    if ((tablero[j][i].isMina())&&(tablero[j][i].getEstado()== Estado.CERRADO)){
                        tablero[j][i].setEstado(Estado.MINA);
                    }else if ((!tablero[j][i].isMina())&&(tablero[j][i].getEstado()== Estado.BANDERA)){
                        tablero[j][i].setEstado(Estado.BANDERAMALA);
                    }
                }
                //System.out.println(tablero[j][i]);
            }
        }
       
         
    }
    public void marcarCelda(Integer x, Integer y){
        tablero[x][y].nextEdo();
        
    }
    private boolean celdaOK(int i, int j) {
        return (((i >= 0) && (i <= dimx)) && ((j >= 0) && (j <= dimy))) && ((i != dimx) && (j != dimy));
    }
    public Integer cantMinas(Integer x , Integer y){
        Integer numMinas=0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j =y-1; j <= y+1; j++) {
                if(celdaOK(i,j)){
                    if(tablero[i][j].isMina()){
                        numMinas++; 
                    }
                }
            }            
        } 
        return numMinas;
    }
    
    public GameEst getEstado(){
        return juego;
    }
    public boolean isGameOn(){
        return juegoOn;
    }
    
}
//uva