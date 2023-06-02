/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

/**
 *
 * @author 820899
 */
public class AssetSetter {
    int mapNumber;
    GamePanel gp;
    
    public AssetSetter(GamePanel gp, int mnum)
    {
        this.gp = gp;
        mapNumber = mnum;
    }
    //Creates objects based on map number
    public void setObject()
    {
        if (mapNumber == 1)
        {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;
        
        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;
        
        gp.obj[2] = new OBJ_Key();
        gp.obj[2].worldX = 38 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;
        
        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 11 * gp.tileSize;
        
        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 8 * gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;
        
        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 12 * gp.tileSize;
        gp.obj[5].worldY = 22 * gp.tileSize;
        
        gp.obj[6] = new OBJ_Chest();
        gp.obj[6].worldX = 10 * gp.tileSize;
        gp.obj[6].worldY = 7 * gp.tileSize;
        
        gp.obj[7] = new OBJ_Boots();
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize;
        }
        
        else if (mapNumber == 2)
        {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 2 * gp.tileSize;
        gp.obj[0].worldY = 1 * gp.tileSize;
        
        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 11 * gp.tileSize;
        gp.obj[1].worldY = 46 * gp.tileSize;
        
        gp.obj[2] = new OBJ_Key();
        gp.obj[2].worldX = 47 * gp.tileSize;
        gp.obj[2].worldY = 13 * gp.tileSize;
        
        gp.obj[3] = new OBJ_Key();
        gp.obj[3].worldX = 1 * gp.tileSize;
        gp.obj[3].worldY = 35 * gp.tileSize;
        
        gp.obj[4] = new OBJ_Boots();
        gp.obj[4].worldX = 24 * gp.tileSize;
        gp.obj[4].worldY = 38 * gp.tileSize;
        
        gp.obj[5] = new OBJ_Boots();
        gp.obj[5].worldX = 31 * gp.tileSize;
        gp.obj[5].worldY = 26 * gp.tileSize;
        
        gp.obj[6] = new OBJ_Door();
        gp.obj[6].worldX = 31 * gp.tileSize;
        gp.obj[6].worldY = 25 * gp.tileSize;
        
        gp.obj[7] = new OBJ_Door();
        gp.obj[7].worldX = 23 * gp.tileSize;
        gp.obj[7].worldY = 22 * gp.tileSize;
        
        gp.obj[8] = new OBJ_Door();
        gp.obj[8].worldX = 23 * gp.tileSize;
        gp.obj[8].worldY = 24 * gp.tileSize;
        
        gp.obj[9] = new OBJ_Door();
        gp.obj[9].worldX = 23 * gp.tileSize;
        gp.obj[9].worldY = 26 * gp.tileSize;
        
        gp.obj[10] = new OBJ_Chest();
        gp.obj[10].worldX = 23 * gp.tileSize;
        gp.obj[10].worldY = 30 * gp.tileSize;
        }
    }

}
