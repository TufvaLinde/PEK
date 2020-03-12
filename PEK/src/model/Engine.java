package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import view.DataPanel;
import view.SpiralPanel;

public class Engine {
    
    public boolean rad;
    
    public Engine(){}
    
    public void setRad(SpiralPanel SpiralPanel, boolean rad){
      SpiralPanel.rad = rad;
    }

    public void setVinkel(SpiralPanel SpiralPanel, String vinkelinpt) {
        SpiralPanel.uppdateraBlomma(vinkelinpt, rad); // true ska ändras
    }

    public void räknaEffektivitet(SpiralPanel sp, DataPanel dp, double start, double slut, double intervall) {
        HashMap<Double, Double> map = new HashMap<>();
        
        for ( double i = start; i < slut; i+= intervall) {
            sp.input = i;
            sp.repaint();
            map.put(i, sp.coveredAreaPercentage());
        }
        
        double maxValueInMap=(Collections.max(map.values()));
        for (Entry<Double, Double> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println(entry.getKey()); 
                sp.input = entry.getKey();
                sp.repaint();
            }
        }
        dp.värde.setText(sp.input + "°");
        dp.percentage.setText(sp.coveredAreaPercentage() + " %");
        dp.setRubrik(dp.vinkelinpt, sp.input + "");
    }
}