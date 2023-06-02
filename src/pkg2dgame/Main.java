/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2dgame;

import java.util.Scanner;
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
        
        //prints tutorial and reads user selection of map
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like a tutorial? (y/n)");
        String tcheck = scan.nextLine();
        if (tcheck.equalsIgnoreCase("y"))
        {
            System.out.println("The objective of this game is to find the treasure chest in the fastest time possible.");
            System.out.println("Use WASD keys to move character around.");
            System.out.println("Doors may block paths at times. Use keys found around the world to open them.");
            System.out.println("You can also pick up boots on the map to increase your character's speed.");
        }
        System.out.println("Which map would you like to play? (1-2)");
        int input = scan.nextInt();
        
        GamePanel gamePanel = new GamePanel(input); //creates GamePanel object
        window.add(gamePanel); //links gamepanel to window
        
        window.pack(); //sizes the window's objects to the right size
        
        window.setLocationRelativeTo(null); //sets gui to center of screen
        window.setVisible(true); //makes window visible
        
        gamePanel.setupGame();
        gamePanel.startGameThread(); //creates and starts thread
    }
    
}
