/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import pkg2dgame.GamePanel;

/**
 *
 * @author 820899
 */
public class SuperObject {

public BufferedImage image;
public String name;
public boolean collison = false;
public int worldX, worldY;

public void draw(Graphics2D g2, GamePanel gp)
{
    //where object should be drawn on screen
    int screenX = worldX - gp.player.worldX + gp.player.screenX;
    int screenY = worldY - gp.player.worldY + gp.player.screenY;
        
    g2.drawImage(image, screenX , screenY, gp.tileSize, gp.tileSize, null);
}
}
