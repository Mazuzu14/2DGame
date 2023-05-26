/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;

import entity.Entity;

/**
 *
 * @author 820899
 */
public class CollisionChecker {
    
    GamePanel gp;
    
    public CollisionChecker(GamePanel gp)
    {
        this.gp = gp;
    }
    
    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x; //left edge of player hitbox
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width; //right edge of player hitbox
        int entityTopWorldY = entity.worldY + entity.solidArea.y; //top edge of player hitbox
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height; //bottom edge of player hitbox
        
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityTopWorldY/gp.tileSize;
        
        int tileNum1, tileNum2;
    }
}
