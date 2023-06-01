/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import object.OBJ_Key;

/**
 *
 * @author 820899
 */
public class UI {
    GamePanel gp;
    Font font;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    
    public UI(GamePanel gp)
    {
        this.gp = gp;
        font = new Font("Arial", Font.PLAIN, 40);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }
    public void draw(Graphics2D g2)
    {
        g2.setFont(font); //sets type of font
        g2.setColor(Color.white); //sets color of font
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null); //creates key image
        g2.drawString("x " + gp.player.hasKey, 74,65); //creates multiplier
        
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
    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }
}
