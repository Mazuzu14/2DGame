/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import pkg2dgame.GamePanel;

/**
 *
 * @author 820899
 */
public class TileManager {

GamePanel gp;
public Tile[] tile;
public int[][] mapTileNum;

public TileManager(GamePanel g, int mnum)
{
    gp = g;
    tile = new Tile[10]; //instatiates tile array
    mapTileNum = new int[gp.maxWorldRow][gp.maxWorldCol];
    getTileImage(); //creates tile objects in tile array
    loadMap("/maps/world0" + mnum + ".txt"); //loads map
}
public void getTileImage()
{
    try
    {
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass.png")); //sets tile at index 0 to grass
        
        tile[1] = new Tile();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall.png"));//sets tile at index 1 to wall
        tile[1].collision = true;
        
        tile[2] = new Tile();
        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water.png")); //sets tile at index 2 to water
        tile[2].collision = true;
        
        tile[3] = new Tile();
        tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Dirt.png")); //sets tile at index 3 to earth
        
        tile[4] = new Tile();
        tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tree.png")); //sets tile at index 4 to tree
        tile[4].collision = true;
        
        tile[5] = new Tile();
        tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Sand.png")); //sets tile at index 5 to sand
        
    }
    catch(IOException e)
    {
        e.printStackTrace(); //catches possible error
    }
}
public void loadMap(String filePath)
{
    try
    {
        InputStream is = getClass().getResourceAsStream(filePath); //imports text file
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); //reads text file
        
        int col = 0;
        int row = 0;
        while (row < gp.maxWorldRow && col < gp.maxWorldCol)
        {
            String line = br.readLine(); //reads line from textfile top to  bottom
            
            while(row < gp.maxWorldRow)
            {
                String[] numbers = line.split(" "); //seperates string based on spaces
                
                int num = Integer.parseInt(numbers[row]); //converts string to num
                
                mapTileNum[row][col] = num;
                row++;
            }
            row = 0;
            col++;
        }
        br.close(); //stops reading file
    }
    catch(Exception e)
    {
        
    }
}
public void draw(Graphics2D g2)
{
    int worldRow = 0;
    int worldCol = 0;
    while (worldRow < gp.maxWorldRow && worldCol < gp.maxWorldCol)
    {
        int tileNum = mapTileNum[worldRow][worldCol];
        
        //location of tile on worldmap
        int worldX = worldRow * gp.tileSize; 
        int worldY = worldCol * gp.tileSize; 
        
        //where tile should be drawn on screen
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        
        g2.drawImage(tile[tileNum].image, screenX , screenY, gp.tileSize, gp.tileSize, null);
        worldCol++;
        //goes to next row if at end of row
        if (worldCol == gp.maxWorldCol)
        {
            worldCol = 0;
            worldRow++;
        }
    }
}
}
