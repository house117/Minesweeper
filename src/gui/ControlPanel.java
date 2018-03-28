/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.listener.EncabezadoListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author House
 */
public class ControlPanel extends JPanel{
    private TButton btnJuego;
    private JTextField txtMinas;
    private JTextField txtTiempo;
    private JLabel texto;
    private EncabezadoListener listener;

    public ControlPanel(){
        super();
        super.setBackground(Color.RED);
        super.setLayout(new BorderLayout());
        btnJuego = new TButton("/images/vivo.png");
        TButton btn = new TButton("/images/muerto.png");
        
        
        txtMinas = new JTextField("10");
        txtMinas.setPreferredSize(new Dimension(60, 30));
        txtMinas.setFont(new Font("Courier New", Font.BOLD, 24));
        txtMinas.setForeground(Color.RED);
        txtMinas.setBackground(Color.BLACK);
        
        txtTiempo = new JTextField("000");
        txtTiempo.setPreferredSize(new Dimension(60, 30));
        
        btnJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(txtMinas.getText());
                System.out.println(txtTiempo.getText());
                listener.btnJuegoOnClick();
            }
        });
       
        JPanel pnlBoton = new JPanel();
        pnlBoton.setBackground(Color.GREEN);
        pnlBoton.add(btnJuego);
        pnlBoton.add(btn);

        super.add(pnlBoton, BorderLayout.CENTER);
        super.add(txtMinas, BorderLayout.WEST);
        super.add(txtTiempo, BorderLayout.EAST);
        
        
    }
    public void setListener(EncabezadoListener listener){
        this.listener = listener;
    }
    public Boolean botonJuegoActionPerformed(){
        return true;
    }
}
