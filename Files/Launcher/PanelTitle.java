//John Link 11/10/16

   import javax.swing.*;
   import java.awt.*;

   public class PanelTitle extends JPanel
   {
		ImageIcon pacman = new ImageIcon("pacman.jpg");
		ImageIcon chess = new ImageIcon("chess.png");
      public void paintComponent(Graphics g)
      {
         g.setColor(Color.BLACK);
			g.fillRect(0, 0, 960, 540);
			g.setColor(Color.WHITE);
			g.fillRect(20, 30, 472, 472);
			g.drawImage(chess.getImage(), 0, 10, 512, 512, null);
			g.drawImage(pacman.getImage(), 520, 142, 256, 256, null);
			g.setFont(new Font("Century Schoolbook", Font.BOLD, 30));
			g.drawString("Team ALM Games", 520, 79);
			g.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
			g.drawString("By John L. and Cole B.", 520, 477);
      }
   }