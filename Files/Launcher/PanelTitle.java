//John Link 11/10/16

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
	
   public class PanelTitle extends JPanel
   {
   	ImageIcon pacman = new ImageIcon("pacman.jpg");//add new Image icons
      ImageIcon chess = new ImageIcon("chess.png");
   	
      public PanelTitle()
      {
         setLayout(new BorderLayout()); //instantiate borderlayout
         JPanel panel2 = new JPanel();
			
         panel2.setPreferredSize(new Dimension(140, 500));
       	
         panel2.setLayout(new GridLayout(4, 1));
      
         JButton button = new JButton("Exit"); //create buttons
			JButton button1 = new JButton("PacGHOST");
			JButton button2 = new JButton("Classic Chess");
			
         button.addActionListener(new Listener()); //create listeners for each button
			button1.addActionListener(new Listener());
 			button2.addActionListener(new Listener());

         button.setHorizontalAlignment(SwingConstants.RIGHT);//setup styles for each button so they are consistent
			button.setBackground(Color.RED);
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setOpaque(false);
			
			button1.setHorizontalAlignment(SwingConstants.RIGHT);
			button1.setBackground(Color.RED);
			button1.setBorderPainted(false);
			button1.setFocusPainted(false);
			button1.setOpaque(false);
			
			button2.setHorizontalAlignment(SwingConstants.RIGHT);
			button2.setBackground(Color.RED);
			button2.setBorderPainted(false);
			button2.setFocusPainted(false);
			button2.setOpaque(false);
			button.setContentAreaFilled(false);
			
         panel2.add(button); //add each button to the panel
      	panel2.add(button1);
			panel2.add(button2);
			
         add(panel2, BorderLayout.EAST); //add the panel to the left side

      }
      private class Listener implements ActionListener //listener 1
      {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      }
		private class Listener1 implements ActionListener //listener 2
      {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
				//this uses Desktop.getDesktop().open(file); to open the PacGHOST .jar
				//todo
         }
      }
		private class Listener2 implements ActionListener//listener 3
      {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
				//this uses Desktop.getDesktop().open(file); to open the classic chess .jar
				//todo
         }
      }
      
      public void paintComponent(Graphics g) //standard paintcomponent with title text and our names
      {
         g.setColor(Color.BLACK);
         g.fillRect(0, 0, 960, 540);
         g.setColor(Color.WHITE);
         g.fillRect(20, 30, 472, 472);
         g.drawImage(chess.getImage(), 0, 10, 512, 512, null);
         g.drawImage(pacman.getImage(), 520, 142, 256, 256, null);
         g.setFont(new Font("Arial", Font.BOLD, 30));
         g.drawString("Team ALM Games", 520, 79);
         g.setFont(new Font("Arial", Font.BOLD, 25));
         g.drawString("By John Link and Cole Blackman", 520, 477);
      }
   	
   }