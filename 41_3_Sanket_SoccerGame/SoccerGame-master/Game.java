import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Game extends JFrame {
    private JButton Enter;
    private JLabel pow;
    private JTextField getPower;
    private JLabel ang;
    private JLabel attempts;
    private JLabel Goals;
    private JLabel perc;
    private JTextField getAngle;
    private GamePanel bottom;
    private static int tries = 0;
    private static int goals = 0;
    private double percentage;


    public Game() {
        // initialize
        setSize(854,580);
        setTitle("Game");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // init panels
        JPanel top = new JPanel();
        bottom = new GamePanel();
        top.setBackground(Color.cyan);
        attempts = new JLabel("Tries: " + Integer.toString(tries));
        Goals = new JLabel("     Goals: " + Integer.toString(goals));
        perc = new JLabel("      percentage: " + Double.toString(percentage));
        JButton Enter = new JButton("Enter");
        JLabel pow = new JLabel("Power: ");
        JLabel ang = new JLabel("Angle: ");
        getPower = new JTextField(5);
        getAngle = new JTextField(5);
        Enter.addActionListener(new ButtonListener());
        top.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //top.setBackground(Color.cyan);
        top.add(pow);
        top.add(getPower);
        top.add(ang);
        top.add(getAngle);
        top.add(Enter);
        top.add(attempts);
        top.add(Goals);
        top.add(perc);

        top.setSize(854,100);
        top.setPreferredSize(new Dimension(854, 100));
        top.setLocation(0, 0);

        bottom.setSize(854, 480);
        bottom.setPreferredSize(new Dimension(854, 480));
        bottom.setLocation(0, 100);


        // add to frame
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);

        //start
        //setVisible(true);
        //bottom.start();
    }
    public static void main(String [] args){
        Game g = new Game();
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            tries++;
            attempts.setText("Tries: " + Integer.toString(tries));
            bottom.power = Double.parseDouble(getPower.getText());
            bottom.angle = Double.parseDouble(getAngle.getText());
            if(bottom.x > 774 && bottom.x <= 854 && bottom.y > 130 && bottom.y < 350){
                goals++;
                Goals.setText("Goals: " + Integer.toString(goals));
            }
            percentage = (goals/tries)*100;
            perc.setText("Percentage: " + Double.toString(percentage));
        }
    }
}