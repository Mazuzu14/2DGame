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
        if (entity.direction.equals("up"))
        {
            entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize; //predict where player will be
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow]; //checks tiles in front 
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow]; 
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true )
            {
                entity.collisionOn = true;
            }
        }
        else if (entity.direction.equals("down"))
        {
            entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize; //predict where player will be
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow]; //checks tiles in front 
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow]; 
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true )
            {
                entity.collisionOn = true;
            }
        }
        else if (entity.direction.equals("left"))
        {
            entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize; //predict where player will be
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow]; //checks tiles in front 
            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow]; 
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true )
            {
                entity.collisionOn = true;
            }
        }
        else if (entity.direction.equals("right"))
        {
            entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize; //predict where player will be
            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow]; //checks tiles in front 
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow]; 
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true )
            {
                entity.collisionOn = true;
            }
        }
    }
}
