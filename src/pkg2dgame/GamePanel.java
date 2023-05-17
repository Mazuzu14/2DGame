/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author 820899
 */
public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile size
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale; // 48x48 tile size
    final int maxScreenCol = 16;
    final int maxScreenRow =12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    //Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        //allows Game Panel to recieve key input
        this.setFocusable(true);
    }
    
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null)
        {           
            //UPDATE information
            update();
            //DRAW with updated information
            //repaint calls paintComponent
            repaint();
        }
    }
    
    public void update()
    {
        if (keyH.upPressed = true)
        {
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed = true)
        {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed = true)
        {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed = true)
        {
            playerY += playerSpeed;
        }
    }
    public void paintComponent(Graphics g) 
    {
         super.paintComponent(g);
         Graphics g2 = (Graphics2D)g;
         
         g2.setColor(Color.white);
         
         g2.fillRect(playerX, playerY, tileSize, tileSize);
         
         g2.dispose();
         
    }
}


