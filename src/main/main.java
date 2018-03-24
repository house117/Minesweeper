/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Objects.Celda;
import Objects.GameEst;
import controller.Buscaminas;
//import gui.PrincipalFrame;
import java.util.Scanner;

/**
 *
 * @author cavr0
 */
/*
TAREA ENTENDER JAJA
HACER LO MISMO PERO CON EL OBJETO ALUMNO
*/
public class main {
    public static void main(String[] args) {
        /*PrincipalFrame ventana = new PrincipalFrame("Buscaminas");*/
         Scanner sc = new Scanner(System.in);
        Integer a,b;
        Integer opcion;
        Buscaminas busca = new Buscaminas(10,10,10);
        Celda[][] celda = busca.getTablero();
        
        do{
            for(int i=0 ; i<busca.getDimy();i++){
                for(int j=0;j<busca.getDimx();j++){
                     System.out.print(celda[j][i]);
                }
                System.out.println("");
             }
            
            System.out.println("*************************");
            System.out.println("Menu\n1.Abrir\t2.Marcar");
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
        //busca.resultados();
    }
    
}
/*public static void pichon(){
        Scanner sc = new Scanner(System.in);
        Integer a,b;
        Integer opcion;
        Buscaminas busca = new Buscaminas(10,10,10);
        Celda[][] celda = busca.getTablero();
        
        do{
            for(int i=0 ; i<busca.getDimy();i++){
                for(int j=0;j<busca.getDimx();j++){
                     System.out.print(celda[j][i]);
                }
                System.out.println("");
             }
            
            System.out.println("*************************");
            System.out.println("Menu\n1.Abrir\t2.Marcar");
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
                default:
                    System.out.println("Mal");
            }
            busca.winner();
        }while(busca.isGameOn());
        //busca.resultados();
}*/
//terminar buscaminas
//iconos
