/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.image.BufferedImage;

/**
 *
 * @author 820899
 */
public class Entity {

    public int x, y; //location of entity
    public int speed; 
    //Stores image files
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; 
    public String direction;
    
    public int spriteCounter = 0; //timer for sprite
    public int spriteNum = 1; //current sprite image
}
