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
Tile[] tile;
int mapTileNum[][];

public TileManager(GamePanel g)
{
    gp = g;
    tile = new Tile[10]; //instatiates tile array
    mapTileNum = new int[gp.maxScreenRow][gp.maxScreenCol];
    getTileImage(); //creates tile objects in tile array
    loadMap("/maps/map01.txt"); //loads map
}
public void getTileImage()
{
    try
    {
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass.png")); //sets tile at index 0 to grass
        
        tile[1] = new Tile();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall.png"));//sets tile at index 1 to wall
        
        tile[2] = new Tile();
        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water.png")); //sets tile at index 2 to water
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
        while (col < gp.maxScreenCol && row < gp.maxScreenRow)
        {
            String line = br.readLine(); //reads line from textfile
            
            while(col < gp.maxScreenCol)
            {
                String numbers[] = line.split(" "); //seperates string based on spaces
                
                int num = Integer.parseInt(numbers[col]); //converts string to num
                
                mapTileNum[row][col] = num;
                col++;
            }
            col = 0;
            row++;
        }
        br.close(); //stops reading file
    }
    catch(Exception e)
    {
        
    }
}
public void draw(Graphics2D g2)
{
    int col = 0;
    int row =0;
    int x = 0;
    int y = 0;
    while (col < gp.maxScreenCol && row < gp.maxScreenRow)
    {
        int tileNum = mapTileNum[row][col];
        g2.drawImage(tile[tileNum].image, x , y, gp.tileSize, gp.tileSize, null);
        col++;
        x += gp.tileSize;
        //goes to next row if at end of row
        if (col == gp.maxScreenCol)
        {
            col = 0;
            x = 0;
            row++;
            y += gp.tileSize;
        }
    }
}
}
