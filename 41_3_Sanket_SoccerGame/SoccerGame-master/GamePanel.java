import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;

public class GamePanel extends JPanel {
    // images
    private BufferedImage ball;
    private BufferedImage goal;

    // ball coords
    public double x =50;
    public double y =50;
    private final int xGoal = 774;
    private final int yGoal = 120;
    private double vel, xvel, yvel;

    public double power = 0;
    public double angle = 0;

    public GamePanel() {
        setSize(854, 480);

        // init vars


        // load assets
        try {
            goal = ImageIO.read(new File("SoccerGame-master/goal.png"));
            ball = ImageIO.read(new File("SoccerGame-master/ball.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start() {
        try {
            while(true) {
                update();
                repaint();
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if (this.power > 1) this.power -= 1;
        else this.power = 0;

        if (this.x > 854) {
            this.angle = 180-this.angle;
            this.x = 853;
        }
        if (this.x < 0) {
            this.angle = 180-this.angle;
            this.x = 1;
        }
        if(this.y > 480){
            this.angle = -180 + this.angle;
            this.y = 479;
        }
        if(this.y < 0){
            this.angle = -180 + this.angle;
            this.y=1;
        }
        double angle = Math.toRadians(this.angle);



        int dx = (int) (Math.cos(angle) * this.power);
        int dy = (int) (Math.sin(angle) * this.power);

        this.x += dx;
        this.y += dy;
    }
    /*public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }*/

    @Override
    public void paintComponent(Graphics g) {
        update();
        g.setColor(Color.green);
        g.fillRect(0, 0, 854, 480);
        g.drawImage((Image) goal, xGoal, yGoal, null);
        g.drawImage((Image) ball, (int)x, (int)y, null);
        repaint();

    }
}