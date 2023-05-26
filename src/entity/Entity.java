/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author 820899
 */
public class Entity {

    public int worldX, worldY; //position of entity
    public int speed; //speed of entity
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; //Stores image files
    public String direction; //direction of image
    
    public int spriteCounter = 0; //timer for sprite
    public int spriteNum = 1; //current sprite image
    
    public Rectangle solidArea; //hitbox of entity
    public boolean collisionOn = false; 
}
