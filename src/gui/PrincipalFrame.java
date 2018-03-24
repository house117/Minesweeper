/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.listener.EncabezadoListener;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author House
 */
public class PrincipalFrame extends JFrame{
            private ControlPanel pnlControl;
        private TableroPanel pnlTablero;
    public PrincipalFrame(String title){
        super(title);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(200, 300);
        super.setLayout(new BorderLayout());
           pnlControl = new ControlPanel();
           pnlControl.setListener(new EncabezadoListener() {
            @Override
            public void btnJuegoOnClick(String minas, String tiempo) {
               pnlTablero.setMensaje(minas+" : "+tiempo);
            }
        });
           
           pnlTablero = new TableroPanel();
           
           
           super.add(pnlControl, BorderLayout.NORTH);
           super.add(pnlTablero, BorderLayout.CENTER);
           super.setVisible(true);

    }
}
