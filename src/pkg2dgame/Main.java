/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2dgame;

import javax.swing.JFrame;

/**
 *
 * @author Mazuki
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window = new JFrame(); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops program when window is closed
        window.setResizable(false); //sets window size
        window.setTitle("2D Adventure"); //sets title of window
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel); //links gamepanel to window
        
        window.pack(); //sizes the window's objects to the right size
        
        window.setLocationRelativeTo(null); //sets gui to center of screen
        window.setVisible(true); //makes window visible
        
        gamePanel.startGameThread(); //creates and starts thread
    }
    
}
