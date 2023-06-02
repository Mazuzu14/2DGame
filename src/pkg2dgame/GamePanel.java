/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;


import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;

/**
 *
 * @author 820899
 */
public class GamePanel extends JPanel implements Runnable{
    
    int mapNumber;
    // SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile size
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; // 48x48 tile size
    public final int maxScreenCol = 16; //tiles across screen
    public final int maxScreenRow = 12; //tiles down screen
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    int FPS = 60;//sets frames per second
    
    TileManager tileM;
    KeyHandler keyH = new KeyHandler();
    public UI ui = new UI(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter;
    public Player player = new Player(this, keyH);
    public SuperObject[] obj = new SuperObject[12]; //how many objects can be displayed
    
    public GamePanel(int mnum)
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //sets size of screen
        this.setBackground(Color.black); //sets background color
        this.setDoubleBuffered(true); //eliminates image flickering
        this.addKeyListener(keyH); //allows Game Panel to recieve key input
        this.setFocusable(true); //allows Game Panel to be focused
        mapNumber = mnum; 
        tileM = new TileManager(this, mapNumber);
        aSetter = new AssetSetter(this, mapNumber);
    }
    
    public void setupGame()
    {
        aSetter.setObject(); //creates game objects
    }
    public void startGameThread()
    {
        gameThread = new Thread(this); //creates a thread object
        gameThread.start(); //starts the thread object
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; //1 second divided by frames
        double nextDrawTime = System.nanoTime() + drawInterval; //returns current time + time too next draw
        while(gameThread != null)
        {           
            //UPDATE information
            update();
            
            //DRAW with updated information
            //repaint calls paintComponent
            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime(); //finds time remaining between current time and next draw time
                remainingTime = remainingTime/1000000; //convert to miliseconds
                //sets remaining time to 0 if it has already been passed
                if (remainingTime < 0)
                {
                    remainingTime = 0; 
                }
                Thread.sleep((long)remainingTime); //pauses the method for the remainingTime
                
                nextDrawTime += drawInterval; //updates nextDrawTime
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex); //catches possible error
            }
        }
    }
    
    public void update()
    {
        player.update(); //updates player information
    }
    public void paintComponent(Graphics g) 
    {
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D)g;
         tileM.draw(g2);//draws tiles
         
         for(int i = 0; i < obj.length; i++) //draws objects
         {
             if (obj[i] != null) //checks if object exists
             {
                 obj[i].draw(g2, this);
             }
         }

         player.draw(g2);//draws player
         
         ui.draw(g2);//draws UI
         
         g2.dispose();//reallocates resources used by graphics object
         
    }

}


