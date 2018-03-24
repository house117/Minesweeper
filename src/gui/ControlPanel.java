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
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author House
 */
public class ControlPanel extends JPanel implements ActionListener{
    private JButton btnJuego;
    private JTextField txtMinas;
    private JTextField txtTiempo;
    private JLabel texto;
    private EncabezadoListener listener;

    public ControlPanel(){
        super();
        super.setBackground(Color.RED);
        super.setLayout(new BorderLayout());
        btnJuego = new JButton("Click me");
        txtMinas = new JTextField("10");
        txtMinas.setPreferredSize(new Dimension(60, 30));
        txtTiempo = new JTextField("000");
        txtMinas.setPreferredSize(new Dimension(60, 30));
        btnJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(txtMinas.getText());
                System.out.println(txtTiempo.getText());
                listener.btnJuegoOnClick(txtMinas.getText(), txtTiempo.getText());
            }
        });
       
        JPanel pnlBoton = new JPanel();
        pnlBoton.setBackground(Color.GREEN);
        pnlBoton.add(btnJuego);

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}