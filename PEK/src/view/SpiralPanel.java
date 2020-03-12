package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import static java.lang.Double.valueOf;
import javax.swing.*;

public class SpiralPanel extends JPanel {

    public double input;
    public boolean enteredvalue = false;
    public boolean rad = false;

    public SpiralPanel() {
        setPreferredSize(new Dimension(1080, 1080));
        setDoubleBuffered(true);
        Color bgc = new Color(87, 96, 114);
        setBackground(bgc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color crcl = new Color(255, 210, 153);
        g.setColor(crcl);
        g.fillOval(150, 150, 780, 780);

        g.setColor(Color.black);
        float c = 12;

        float iv = (float) (input * (Math.PI / 180));
        if (rad == true) {
            iv = (float) input;
        }

        if (enteredvalue == true) { 
            for (int i = 0; i < 1000; i++) {
                float v = i * iv;
                float r = (float) (c * Math.sqrt(i));
                int x = (int) Math.round(r * Math.cos(v) + getWidth() / 2);
                int y = (int) Math.round(r * Math.sin(v) + getHeight() / 2);
                g.fillOval(x - 9, y - 9, 18, 18);
            }
        }
    }

    public double coveredAreaPercentage() {
        int blackpixelcount = 0;
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        paint(g2);
        
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color c = new Color(image.getRGB(x, y), false);
                if (c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 0) {
                    blackpixelcount++;
                }
            }
        }
        double percentage = (100 * blackpixelcount / (390 * 390 * Math.PI));
        return percentage;
    }

    public void uppdateraBlomma(String sx, boolean b) {
        this.input = valueOf(sx);
        enteredvalue = true;
        repaint();
    }
}