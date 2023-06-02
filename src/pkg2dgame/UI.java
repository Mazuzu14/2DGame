/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import object.OBJ_Key;

/**
 *
 * @author 820899
 */
public class UI {
    GamePanel gp;
    Font arial40, arial80B;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial40 = new Font("Arial", Font.PLAIN, 40); 
        arial80B = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }
    public void draw(Graphics2D g2)
    {
        if(gameFinished == true)
        {
            g2.setFont(arial40); //sets type of font
            g2.setColor(Color.white); //sets color of font
            
            String text = "Treasure Found!";
            int textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); //returns length of text
            //Draws text slightly above middle of the screen
            int x = gp.screenWidth/2 - textLength/2;
            int y = gp.screenHeight/2 + gp.tileSize*2;
            g2.drawString(text, x, y);
            
            text = "Your time is: " + dFormat.format(playTime);
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); //returns length of text
            //Draws text near bottom of screen
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + gp.tileSize*4;
            g2.drawString(text, x, y);
            
            g2.setFont(arial80B); //sets type of font
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); //returns length of text
            //Draws Text in middle of screen
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2;
            g2.drawString(text, x, y);
            
            gp.gameThread = null;
        }
        else
        {
            g2.setFont(arial40); //sets type of font
            g2.setColor(Color.white); //sets color of font
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null); //creates key image
            g2.drawString("x " + gp.player.hasKey, 74,65); //creates multiplier
            
            //TIME
            playTime += 1.0/60;
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 11, 65); //draws time in upper right hand corner
            
            //Draws Message
            if(messageOn)
            {
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
            
                messageCounter++;
            
                //draws message for 120 frames and then deletes it
                if(messageCounter > 120)
                {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
    
    //allows a message to be set
    public void showMessage(String text)
    {
        message = text; 
        messageOn = true;
    }
}
