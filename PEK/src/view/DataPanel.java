package view;

import controllers.InputController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.lang.Double.valueOf;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class DataPanel extends JPanel { 

    public double start, slut, intervall;

    public JTextField vinkelinpt, startinpt, slutinpt, intervallinpt;
    public JLabel coveredarea, percentage, maxvärde, värde;
    JCheckBox radbox;
    JButton räknamax, stängknapp;

    Font titleFont = new Font("Trebuchet MS", Font.PLAIN, 30);
    Color titleColor = new Color(255, 210, 153);
    Font boxFont = new Font("Cambria", Font.PLAIN, 15);
    Color boxColor = new Color(87, 96, 114);
    
    public DataPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(840, 1080));
        setDoubleBuffered(true);
        
        JLabel toptitleLbl = new JLabel("PEK");
        toptitleLbl.setFont(new Font("Georgia", Font.PLAIN, 100));
        toptitleLbl.setForeground(new Color(87, 96, 114));
        toptitleLbl.setSize(500, 500);
        add(toptitleLbl, "WEST");
        
        JPanel pnlAlign = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlAlign.setBackground(Color.white);
        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
        add(pnlAlign);
        pnlAlign.setPreferredSize(new Dimension(750, 900));
        
        JPanel settingsPnl = new JPanel();
        settingsPnl.setBackground(Color.white);
        settingsPnl.setLayout(new FlowLayout(FlowLayout.LEADING));
        settingsPnl.setBorder(BorderFactory.createTitledBorder(null, " Inställningar ", WIDTH, WIDTH, titleFont, titleColor));
        settingsPnl.setPreferredSize(new Dimension(750, 60));
        pnlAlign.add(settingsPnl);

        radbox = new JCheckBox("Radianer");
        radbox.setBackground(Color.white);
        radbox.setFont(boxFont);
        radbox.setForeground(boxColor);
        settingsPnl.add(radbox);
        radbox.setActionCommand("Radian");
        
        JPanel settingspacePnl = new JPanel();
        settingspacePnl.setPreferredSize(new Dimension(530, 0));
        settingsPnl.add(settingspacePnl);
        
        stängknapp = new JButton("Avsluta");
        stängknapp.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
//        stängknapp.setBackground(new Color(255, 210, 153));
        stängknapp.setOpaque(true);
        settingsPnl.add(stängknapp, BorderLayout.EAST);
        stängknapp.setActionCommand("stäng");

        JPanel viewPnl = new JPanel();
        viewPnl.setBackground(Color.white);
        viewPnl.setLayout(new BoxLayout(viewPnl, BoxLayout.PAGE_AXIS));
        viewPnl.setBorder(BorderFactory.createTitledBorder(null, " Visualisera blomma ", WIDTH, WIDTH, titleFont, titleColor));
        pnlAlign.add(viewPnl);
        viewPnl.setPreferredSize(new Dimension(400, 100));

        JPanel vinkelPnl = new JPanel(new FlowLayout(FlowLayout.LEADING));
        vinkelPnl.setBackground(Color.white);
        viewPnl.add(vinkelPnl);

        vinkelinpt = new JTextField();
        vinkelinpt.setActionCommand("Vinkel");
        setRubrik(vinkelinpt, "");
        vinkelinpt.setPreferredSize(new Dimension(180, 60));
        vinkelPnl.add(vinkelinpt);

        JPanel areaPnl = new JPanel(new FlowLayout(FlowLayout.LEADING));
        areaPnl.setBackground(Color.white);
        viewPnl.add(areaPnl);

        coveredarea = new JLabel("Täckt yta: ");
        coveredarea.setFont(new Font("Cambria", Font.PLAIN, 30));
        coveredarea.setForeground(boxColor);
        areaPnl.add(coveredarea);
        percentage = new JLabel("");
        percentage.setFont(new Font("Cambria", Font.PLAIN, 30));
        percentage.setForeground(boxColor);
        areaPnl.add(percentage);

        JPanel countPnl = new JPanel();
        countPnl.setBackground(Color.white);
        countPnl.setLayout(new BoxLayout(countPnl, BoxLayout.PAGE_AXIS));
        countPnl.setBorder(BorderFactory.createTitledBorder(null, " Beräkna effektivitet ", WIDTH, WIDTH, titleFont, titleColor));
        pnlAlign.add(countPnl);
        
        JPanel inputcountPnl = new JPanel(new FlowLayout(FlowLayout.LEADING));
        inputcountPnl.setBackground(Color.white);
        inputcountPnl.setPreferredSize(new Dimension(750, 300));
        countPnl.add(inputcountPnl);
        
        startinpt = new JTextField();
        setRubrik(startinpt, "");
        startinpt.setPreferredSize(new Dimension(150, 60));
        startinpt.setSelectionColor(Color.red);
        inputcountPnl.add(startinpt);

        slutinpt = new JTextField();
        setRubrik(slutinpt, "");
        slutinpt.setPreferredSize(new Dimension(150, 60));
        inputcountPnl.add(slutinpt);

        intervallinpt = new JTextField();
        setRubrik(intervallinpt, "");
        intervallinpt.setPreferredSize(new Dimension(150, 60));
        inputcountPnl.add(intervallinpt);
        
        JPanel coutnspacePnl = new JPanel();
        coutnspacePnl.setPreferredSize(new Dimension(250, 0));
        inputcountPnl.add(coutnspacePnl);

        räknamax = new JButton("Räkna");
        räknamax.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        räknamax.setActionCommand("Räkna");
        inputcountPnl.add(räknamax);
        
        JPanel spacepnl = new JPanel();
        spacepnl.setPreferredSize(new Dimension(500, 0));
        inputcountPnl.add(spacepnl);
        
        maxvärde = new JLabel("Mest spridning: ");
        maxvärde.setFont(new Font("Cambria", Font.PLAIN, 30));
        maxvärde.setForeground(boxColor);
        inputcountPnl.add(maxvärde);
        
        JPanel spacepnl2 = new JPanel();
        spacepnl2.setPreferredSize(new Dimension(500, 0));
        inputcountPnl.add(spacepnl2);
        
        värde = new JLabel("");
        värde.setFont(new Font("Cambria", Font.PLAIN, 130));
        värde.setForeground(boxColor);
        inputcountPnl.add(värde);
        
        JPanel bottomspacePnl = new JPanel();
        bottomspacePnl.setPreferredSize(new Dimension(250, 110));
        bottomspacePnl.setBackground(Color.white);
        pnlAlign.add(bottomspacePnl);
    }

    public void setStart(String s) {
        start = valueOf(s);
    }

    public void setSlut(String text) {
        slut = valueOf(text);
    }

    public void setIntervall(String text) {
        intervall = valueOf(text);
    }

    public void setRubrik(JTextField t, String s) {
        
        if (t == vinkelinpt) {
            Border b = new TitledBorder(null, " Ange Vinkel: ", WIDTH, WIDTH, boxFont, boxColor);
            if (s != "") {
                b = new TitledBorder(null, "Ange vinkel:  (" + s + "°)", WIDTH, WIDTH, boxFont, boxColor);
                t.setText("");
            }
            vinkelinpt.setBorder(b);
        } else if (t == startinpt) {
            Border b = new TitledBorder(null, "Startvinkel: ", WIDTH, WIDTH, boxFont, boxColor);
            if (s != "") {
                b = new TitledBorder(null, "Startvinkel:  (" + s + "°)", WIDTH, WIDTH, boxFont, boxColor);
                t.setText("");
            }
            startinpt.setBorder(b);
        } else if (t == slutinpt) {
            Border b = new TitledBorder(null, "Slutvinkel: ", WIDTH, WIDTH, boxFont, boxColor);
            if (s != "") {
                b = new TitledBorder(null, "Slutvinkel:  (" + s + "°)", WIDTH, WIDTH, boxFont, boxColor);
                t.setText("");
            }
            slutinpt.setBorder(b);
        } else if (t == intervallinpt) {
            Border b = new TitledBorder(null, "Intervall: ", WIDTH, WIDTH, boxFont, boxColor);
            if (s != "") {
                b = new TitledBorder(null, "Intervall:  (" + s + "°)", WIDTH, WIDTH, boxFont, boxColor);
                t.setText("");
            }
            intervallinpt.setBorder(b);
        }
    }

    public void setController(InputController InputController) {
        vinkelinpt.addActionListener(InputController);
        radbox.addActionListener(InputController);
        räknamax.addActionListener(InputController);
        stängknapp.addActionListener(InputController);
    }
}