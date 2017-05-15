//John Link Cole Blackman 5/10/17

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.io.*;
   
	
   public class GUIPanel extends JPanel
   {
	   ImageIcon chess = new ImageIcon("chessboard.png");
      
   	
      public GUIPanel()
      {
        
      }
      public void paintComponent(Graphics g)
      {
         g.setColor(Color.BLACK);
         g.drawImage(chess.getImage(), 0, 0, 1280, 1024, null);
      }
   	
   }