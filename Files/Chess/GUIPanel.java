//John Link Cole Blackman 5/10/17

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.io.*;
   
	
   public class GUIPanel extends JPanel implements ActionListener
   {
	   
	private static final long serialVersionUID = -749283768975179723L;

	ImageIcon chess = new ImageIcon("chessboard.png");
		public static boolean isWhiteTurn = true;
	   public static JButton[][] b1 = new JButton[10][10];
	   Color brown = new Color(181, 136, 99);
	   Color beige = new Color(240, 217, 181);
      public GUIPanel()
      {

    	setLayout(new GridLayout(10, 10));
    	  Font f = new Font("Arial", Font.PLAIN, 30);
    	  
    	  int numberInt = 8;
    	  char [] letterChar = new char[]{' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    	 
    	  for(int o = 1; o < 10; o++) //nested for loops to populate the array with x and y values 1,1 to 8,8
    	  { //o = y p = x
	    	  for(int p = 1; p < 10; p++)
	    	  {
	    		
		    			b1[o][p] = new JButton();
		    			b1[o][p].setBorderPainted(true);
		    			b1[o][p].setFocusPainted(false);
		    			
		    			this.b1[o][p].addActionListener(this);
		    		 	add(b1[o][p]);
		    		 	if((p + o) % 2 == 0)
		    		 	{
		    		 		b1[o][p].setBackground(beige);
		    		 		
		    		 	}
		    		 	else
		    		 	{
		    		 		b1[o][p].setBackground(brown);
		    		 	}
		    		 	
		    		 	if(o < 9 && p == 1)
		    		 	{
		    		 		b1[o][1].setText("" + numberInt);
		    		 		if(numberInt > 1)
		    		 		numberInt--;
		    		 		b1[o][1].setBackground(Color.LIGHT_GRAY);
		    		 		
		    		 		
		    		 	}
		    		 	if(o == 9 && p > 1)
		    		 	{
		    		 		b1[9][p].setText("" + letterChar[p-1]);
		    		 		b1[9][p].setBackground(Color.LIGHT_GRAY);
		    		 	}
		    		 	
	    	  }
	    	 
    	 }
    	System.out.println(b1[5][2].getLocation());
    	
    		 
    	 SetChessBoard();
    	  
    	  b1[9][1].addActionListener(new Listener());
    	  b1[9][1].setText("EXIT");
    	  b1[9][1].setBackground(beige);
      }
      
      public void SetChessBoard()
 	 {
 		 for(int o = 1; o < 10; o++) 
    	  { 
	    	  for(int p = 1; p < 10; p++)
	    	  {
	    		  //BLACK
	    		  //Pawn
	    		  if(o == 2 && p != 1)
	    		  {
	    				  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
	    				  
	    				  b1[o][p].setText("\u265F");
	    		  }
	    		  //WHITE
	    		  //PAWN
	    		  if(o == 7 && p != 1)
	    		  {
	    			 
	    				  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
	    				  b1[o][p].setForeground(Color.WHITE);
	    				  b1[o][p].setText("\u2659");
	   
	    		  }
	    		  //rook
	    		  //Black
	    		  if((o == 1 && p == 2) || (o == 1 && p == 9))
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
    				  b1[o][p].setText("\u265C");
	    			  
	    		  }
	    		  //rook
	    		  //White
	    		  if((o == 8 && p == 2) || (o == 8 && p == 9))
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
	    			  b1[o][p].setForeground(Color.WHITE);
    				  b1[o][p].setText("\u2656");
	    			  
	    		  }
	    		  //Knight
	    		  //Black
	    		  if((o == 1 && p == 3) || (o == 1 && p == 8))
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
    				  b1[o][p].setText("\u265E");
	    			  
	    		  }
	    		  //Knight
	    		  //White
	    		  if((o == 8 && p == 3) || (o == 8 && p == 8))
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
	    			  b1[o][p].setForeground(Color.WHITE);
    				  b1[o][p].setText("\u2658");
	    			  
	    		  }
	    		  //Bishop
	    		  //Black
	    		  if((o == 1 && p == 4) || (o == 1 && p == 7))
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
    				  b1[o][p].setText("\u265D");
	    			  
	    		  }
	    		  //Bishop
	    		  //White
	    		  if((o == 8 && p == 4) || (o == 8 && p == 7))
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
	    			  b1[o][p].setForeground(Color.WHITE);
    				  b1[o][p].setText("\u2657");
	    			  
	    		  }
	    		  //King
	    		  //White
	    		  if(o == 8 && p == 6)
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
	    			  b1[o][p].setForeground(Color.WHITE);
    				  b1[o][p].setText("\u2654");
	    			  
	    		  }
	    		  //King
	    		  //Black
	    		  if(o == 1 && p == 5)
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
    				  b1[o][p].setText("\u265A");  
	    		  }
	    		  //Queen 
	    		  //White
	    		  if(o == 8 && p == 5)
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
	    			  b1[o][p].setForeground(Color.WHITE);
    				  b1[o][p].setText("\u2655");
	    			  
	    		  }
	    		  //Queen
	    		  //Black
	    		  if(o == 1 && p == 6)
	    		  {
	    			  b1[o][p].setFont(new Font("Noto", Font.PLAIN, 50));
    				  b1[o][p].setText("\u265B");  
	    		  }
	    	  }
    	  }
 }
	    	 
      private class Listener implements ActionListener //listener 1
      {
         public void actionPerformed(ActionEvent e)
         {
        	 
            System.exit(0);
         }
      }
      public void actionPerformed(ActionEvent e) {
    	  //black pawn
    	  
    	  
    	  System.out.println(((JButton) e.getSource()).getText()+" Click");
       // System.out.println("  " + );
        	  
          }
      
      public void paintComponent(Graphics g)
      {
       //  g.setColor(Color.BLACK);
      //  g.drawImage(chess.getImage(), 0, 0, 1280, 1024, null);
      }
   	
   }