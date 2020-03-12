package view;

import controllers.InputController;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.Engine;

public class PEK extends JFrame {

    public PEK() {
        Engine Engine = new Engine();
        setTitle("Proportionseffektivitetskalkylatorn PEK");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        
        SpiralPanel SpiralPanel = new SpiralPanel();
        add(SpiralPanel, BorderLayout.WEST);
        
        DataPanel DataPanel = new DataPanel();
        add(DataPanel, BorderLayout.EAST);
        
        InputController InputController = new InputController(SpiralPanel, DataPanel, Engine);
        
        DataPanel.setController(InputController);
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new PEK();
    }
}