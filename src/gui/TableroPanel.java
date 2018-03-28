/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Objects.Celda;
import Objects.Estado;
import controller.Buscaminas;
import gui.listener.TableroListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author House
 */
public class TableroPanel extends JPanel{
    private TableroListener listener;
    public TableroPanel(){
        super();
        //super.setBackground(Color.BLUE);
        super.setLayout(null);
    }
    public void drawTablero(Buscaminas buscaminas){
        for(int i=0; i<buscaminas.getDimx(); i++){
            for(int j=0; j<buscaminas.getDimy(); j++){
                Celda celda = buscaminas.getTablero()[j][i];
                if(celda.getEstado() == Estado.ABIERTO){
                    JLabel abierto = new JLabel();
                    if(celda.getNumero() != 0){
                        abierto.setText(celda.getNumero().toString());
                    }
                abierto.setBounds(j*35+10, i*35+10, 30, 30);
                super.add(abierto);      
            }else{
                   TButton cerrado = new TButton(celda, j, i);
                    cerrado.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent ae) {
                       }
                    });
                    cerrado.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent evt){
                            if(evt.getButton() == MouseEvent.BUTTON3){
                                System.out.println("CAMBIAR ESTADO");
                                listener.onRightClickButton(cerrado.getXx(), cerrado.getYy());
                            }
                        }
                    });
                    super.add(cerrado);
                }                    
            }
        }
    }
    public void setListener(TableroListener listener){
        this.listener = listener;
    }

}
