import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JPanel
{
    private JButton start;
    JFrame frame = new JFrame();
    public Menu(){
        //JPanel panel = new JPanel();


        frame.setTitle("Menu");
        frame.setSize(854,580);
        //frame.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //add(Box.createVerticalStrut(280));

        JButton start = new JButton("Start");

        start.setAlignmentX(CENTER_ALIGNMENT);
        start.addActionListener(new ButtonListener());
        frame.add(start);
        //add(Box.createVerticalGlue());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void start(){

        Game game = new Game();
        System.out.println(game.getWidth());
        game.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLUE);

    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            start();

        }
    }
}