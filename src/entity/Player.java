/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
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
    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    
    public void getPlayerImage()
    {
        try
        {
            up1 = ImageIO.read(getClass().getResourceAsStream());
            up2 = ImageIO.read(getClass().getResourceAsStream());
            down1 = ImageIO.read(getClass().getResourceAsStream());
            down2 = ImageIO.read(getClass().getResourceAsStream());
            left1 = ImageIO.read(getClass().getResourceAsStream());
            left2 = ImageIO.read(getClass().getResourceAsStream());
            right1 = ImageIO.read(getClass().getResourceAsStream());
            right2 = ImageIO.read(getClass().getResourceAsStream());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void update()
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
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.white);
         
         g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
