/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import pkg2dgame.GamePanel;
import pkg2dgame.KeyHandler;

/**
 *
 * @author 820899
 */
public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel g, KeyHandler kh)
    {
        gp = g;
        keyH = kh;
        setDefaultValues();
        getPlayerImage();
    }
    //sets defalt values for player
    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    //reads sprite images
    public void getPlayerImage()
    {
        try
        {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Blob Backward 1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Blob Backward 2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Blob Forward 1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Blob Forward 2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Blob Left 1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Blob Left 2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Blob Right 1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Blob Right 2.png"));
        }
        catch(IOException e)
        {
            //prints where error happened
            e.printStackTrace();
        }
    }
    //called 60 times a second - updates the current direction, location, and time only if a key is pressed
    public void update()
    {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
        {
            if (keyH.upPressed == true)
            {
                direction = "up";
                y -= speed;
            }
            else if (keyH.downPressed == true)
            {
                direction = "down";
                y += speed;
            }
            else if (keyH.leftPressed == true)
            {
                direction = "left";
                x -= speed;
            }
            else if (keyH.rightPressed == true)
            {
                direction = "right";
                x += speed;
            }
            //changes player image every 10 frames
            spriteCounter++;
            if(spriteCounter > 10)
            {
                if (spriteNum == 1)
                    spriteNum = 2;
                else if (spriteNum == 2)
                    spriteNum = 1;
                spriteCounter = 0;
            }
        }       
    }
    
    //draws image of chracter based on direction, time, and location
    public void draw(Graphics2D g2)
    {
        BufferedImage image  = null;
        if (direction.equals("up"))
        {
            if (spriteNum == 1)
                image = up1;
            else if (spriteNum == 2)
                image = up2; 
        }
        else if (direction.equals("down"))
        {
            if (spriteNum == 1)
                image = down1;
            else if (spriteNum == 2)
                image = down2;
        }
        else if (direction.equals("left"))
        {
            if (spriteNum == 1)
                image = left1;
            else if (spriteNum == 2)
                image = left2; 
        }
        else if (direction.equals("right"))
        {
            if (spriteNum == 1)
                image = right1;
            else if (spriteNum == 2)
                image = right2;  
        }      
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
