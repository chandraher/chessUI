package com.nostratech;

import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    //masukkan gambar icon di src/main/resources
    public static void main( String[] args )
    {
        JFrame window = new JFrame("Catur");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.launchGame();
        System.out.println( "Hello World!" );
    }
}
