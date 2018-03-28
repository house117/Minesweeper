/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author House
 * 
 * encription String
 * se encripta a partir de los bites
 * encriptar hacer lo de las sumas de caracteres 
 * dividir en archivos
 */
public class Test {
    public static void main(String[] args) throws IOException {
        
        
        File file = new File("test.txt");
        
        
        FileReader reader = new FileReader(file);
        
        int caracter = 0;
        
        while(caracter != -1){
            caracter = reader.read();
            char c = (char)caracter;
            System.out.print(c);
        }
        
        
        
        
    }
}
