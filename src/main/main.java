/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Objects.Celda;
import Objects.GameEst;
import controller.Buscaminas;
import controller.GestionadorArchivo;
import gui.PrincipalFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * @author House
 */
/*
TAREA ENTENDER JAJA
HACER LO MISMO PERO CON EL OBJETO ALUMNO
*/
public class main {
    
 
    
    
    public static void main(String[] args) {
        grafico();
    }
    
    public static void grafico(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrincipalFrame ventana = new PrincipalFrame("Buscaminas");
            }
        });
        
    }
    public static void pichon(){
        Scanner sc = new Scanner(System.in);
        Buscaminas busca = null;
        Integer a,b;
        Integer opcion;
        System.out.println("Que quieres hacer?");
        System.out.println("1. Juego Nuevo");
        System.out.println("2. Abrir");
        int op = sc.nextInt();
        switch(op){
            case 1:
                busca = new Buscaminas(10,10,10);
                
                break;
            case 2:
                try {
                    busca = GestionadorArchivo.abrirArchivo();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("error al abrir");
                }
                break;
            default:
                throw new AssertionError();
        }
        Celda[][] celda = busca.getTablero();
        
        
        do{
            for(int i=0 ; i<busca.getDimy();i++){
                for(int j=0;j<busca.getDimx();j++){
                     System.out.print(celda[j][i]);
                }
                System.out.println("");
             }
            
            System.out.println("*************************");
            System.out.println("1. Abrir");
            System.out.println("2. Marcar");
            System.out.println("3. Guardar");
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Coordenadas");
                    a=sc.nextInt();
                    b=sc.nextInt();
                    busca.abrirCelda(a, b);
                    break;
                case 2: 
                    System.out.println("Coordenadas");
                    a=sc.nextInt();
                    b=sc.nextInt();
                    busca.marcarCelda(a, b);
                    break;
                case 3:
                    
                    //Guardar buscaminas
            try {
                GestionadorArchivo.guardarArchivito(busca, "ArchivoPichon");
            } catch (IOException eX) {
                System.out.println("errorsito");
            }
                    break;
                case 4: 
                    
                default:
                    System.out.println("Mal");
            }

            busca.winner();
            if(busca.getEstado() == GameEst.Lose || busca.getEstado() == GameEst.Win){
                for(int i=0 ; i<busca.getDimy();i++){
                for(int j=0;j<busca.getDimx();j++){
                     System.out.print(celda[j][i]);
                }
                System.out.println("");
             }
            }
        }while(busca.isGameOn());     
    }


}


//terminar buscaminas
//iconos
