/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author 820899
 */
public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile size
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale; // 48x48 tile size
    final int maxScreenCol = 16;
    final int maxScreenRow =12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    Thread gameThread;
    
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
