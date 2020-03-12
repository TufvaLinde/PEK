package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import model.Engine;
import view.DataPanel;
import view.SpiralPanel;

public class InputController implements ActionListener{
    
    private Engine engine;
    private SpiralPanel SpiralPanel;
    private DataPanel DataPanel;
    
    public InputController(SpiralPanel SpiralPanel, DataPanel DataPanel, Engine engine){
        this.engine = engine;
        this.SpiralPanel = SpiralPanel;
        this.DataPanel = DataPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Vinkel")){
            engine.setVinkel(this.SpiralPanel,((JTextField)e.getSource()).getText());
            DataPanel.setRubrik(DataPanel.vinkelinpt, ((JTextField)e.getSource()).getText());
            DataPanel.percentage.setText(SpiralPanel.coveredAreaPercentage() + " %");
        }else if(e.getActionCommand().equals("Räkna")){
            DataPanel.setStart(DataPanel.startinpt.getText());
            DataPanel.setSlut(DataPanel.slutinpt.getText());
            DataPanel.setIntervall(DataPanel.intervallinpt.getText());
            
            DataPanel.setRubrik(DataPanel.startinpt, DataPanel.startinpt.getText());
            DataPanel.setRubrik(DataPanel.slutinpt, DataPanel.slutinpt.getText());
            DataPanel.setRubrik(DataPanel.intervallinpt, DataPanel.intervallinpt.getText());
            
            engine.räknaEffektivitet(SpiralPanel, DataPanel, DataPanel.start, DataPanel.slut, DataPanel.intervall);
            
        }else if (e.getActionCommand().equals("Radian")){
            engine.setRad(SpiralPanel, ((JCheckBox)e.getSource()).isSelected());
        }else if (e.getActionCommand().equals("stäng")){
            System.exit(0);
        }
    }
}