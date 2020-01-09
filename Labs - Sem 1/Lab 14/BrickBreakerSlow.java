import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BrickBreakerSlow extends JPanel implements Runnable, KeyListener/*, ActionListener*/{
    //Initialize Ball
    int ballx = 160;
    int bally = 218;
    Rectangle Ball = new Rectangle(ballx, bally, 5, 5);
    //Initialize Bat
    int batx = 160;
    int baty = 245;
    Rectangle Bat = new Rectangle(batx, baty, 40, 5);
    //Initialize Bricks
    int brickx = 70;
    int bricky = 50;
    Rectangle[] Brick = new Rectangle[18];
    //Establish Boolean for Key Press
    static boolean right = false;
    static boolean left = false;

    public BrickBreakerSlow(){
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        BrickBreakerSlow game = new BrickBreakerSlow();
        JButton button = new JButton("restart");
        frame.setSize(350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(game);
        frame.add(button, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        game.addKeyListener(game);
        game.setFocusable(true);
        /*button.addActionListener(game);*/

        Thread t = new Thread(game);
        t.start();
    }

    public void paint(Graphics g){

        //Panel
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,350,450);
        //Ball
        g.setColor(Color.red);
        g.fillOval(Ball.x, Ball.y, Ball.width, Ball.height);
        //Bat
        g.setColor(Color.green);
        g.fill3DRect(Bat.x, Bat.y, Bat.width, Bat.height, true);
        //Panel Below Bat
        g.setColor(Color.GRAY);
        g.fillRect(0,251,450,200);
        //Panel Border
        g.setColor(Color.red);
        g.drawRect(1,0,334,250);

        for(int i = 0; i < Brick.length; i++){
            if(Brick[i] != null){
                g.fill3DRect(Brick[i].x,Brick[i].y,Brick[i].width,Brick[i].height,true);
            }
        }

        if(ballFallDown == true || bricksOver == true){
            Font f = new Font("Arial", Font.BOLD, 20);
            g.setFont(f);
            g.drawString(status, 70, 120);
            ballFallDown = false;
        }
    }

    int movex = -1;
    int movey = -1;
    boolean ballFallDown = false;
    boolean bricksOver = false;
    String status;
    int count = 0;

    public void run(){

        //Display Bricks
        int firstX = brickx;
        for(int i = 0; i < Brick.length; i++){
            Brick[i] = new Rectangle(brickx, bricky, 30, 10);            
            if(i == 5){
                brickx = firstX - 31;
                bricky = 62;
            }
            if(i == 11){
                brickx = firstX - 31;
                bricky = 74;
            }
            brickx += 31;
        }

        boolean gameOver = false;
        while(!gameOver){

            //Brick Removed When Ball Hits
            for(int i = 0; i < Brick.length; i++){
                if(Brick[i] != null){
                    if(Brick[i].intersects(Ball)){
                        Brick[i] = null;
                        movey = -movey;
                        count++;
                    }
                }
            }

            if(count == Brick.length){
                bricksOver = true;
                status = "YOU WON THE GAME";
                gameOver = true;
                //repaint();
            }

            //Ball is Now "Moving"
            repaint();
            Ball.x += movex;
            Ball.y += movey;

            //Keep Ball Within Boundary
            if(Ball.x <= 0 || Ball.x + Ball.height >= 334){
                movex = -movex;
            }
            if(Ball.y <= 0){
                movey = -movey;
            }

            //You Lose Message
            if(Ball.y >= 250){
                ballFallDown = true;
                status = "YOU LOST THE GAME";
                repaint();
            }

            //Bat is Now "Moving"
            if(left == true){
                Bat.x -= 3;
                right = false;
            }
            if(right == true){
                Bat.x += 3;
                left = false;
            }

            //Keep Bat Within Boundary
            if(Bat.x <4){
                Bat.x = 4;
            } else if(Bat.x >= 293){
                Bat.x = 293;
            }

            //Bat Deflects Ball
            if(Ball.intersects(Bat)){
                movey = -movey;
            }

            //Execute Every 10 Milliseconds
            try{
                Thread.sleep(10);
            } catch(Exception ex){
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
            left = true;
        }

        if(keyCode == KeyEvent.VK_RIGHT){
            right = true;
        }
        
        if(keyCode == KeyEvent.VK_ESCAPE){
            //JFrame.EXIT_ON_CLOSE;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
            left = false;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            right = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0){
    }
}
