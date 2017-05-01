import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class PanelPac extends JPanel
{
//setup the background
   private static final int FRAME = 1000;   
   private static final Color BACKGROUND = new Color(0, 0, 0);

   private BufferedImage myImage;
   private Graphics myBuffer;
   private Timer t;
   private Pacman pm;
   private Ghost gt;
   private JLabel label, label2, label3, labelScore, labelT;
   private treat t1;
   private Bumper b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37;

   int notagain = 0;
   int notitle = 0;
   int score = 0;
   int resume = 0;
   int maxScore = 5;
   public PanelPac()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      
      pm = new Pacman(1026, 55, 26, Color.YELLOW); 
      gt = new Ghost(1026, 25, 26);
      
      b1 = new Bumper(20, 20, 15, 960);//top
     //  Bumper[b1] = new Bumper(20, 20, 15, 960);
      b2 = new Bumper(20, 960, 15, 960);//bottom
      b3 = new Bumper(20, 20, 310, 15);//side pieces
      b5 = new Bumper(20, 660, 310, 15);
      b4 = new Bumper(965, 20, 310, 15);
      b6 = new Bumper(965, 660, 310, 15);
      b7 = new Bumper(45, 45, 40, 50);//top interactives
      b8 = new Bumper(375, 484, 83, 250);
      b9 = new Bumper(375, 597, 26, 250);
      b10 = new Bumper(490, 600, 100, 26);
      b11 = new Bumper(385, 495, 63, 230, 1);//black 5 arg constructor
      b12 = new Bumper(300, 675, 26, 100);
      b13 = new Bumper(600, 675, 26, 100);
      b14 = new Bumper(870, 330, 26, 110);
      b15 = new Bumper(870, 330+310, 26, 110);
      b16 = new Bumper(20, 330, 26, 110);
      b17 = new Bumper(20, 330+310, 26, 110);
      b18 = new Bumper(477, 20, 100, 26);
      b19 = new Bumper(885, 55, 40, 50);//right pieces
      b20 = new Bumper(885, 55+26+55, 40, 50);
      b21 = new Bumper();
      b22 = new Bumper();
      b37 = new Bumper();
      b23 = new Bumper(385, 780, 26, 230);//lower t mid
      b24 = new Bumper(487, 796, 100, 26);
      b25= new Bumper(30, 750, 26, 100);//side bottoms
      b26= new Bumper(870, 750, 26, 100);
      b27= new Bumper(230, 800, 100, 26);//bottom left t
      b28= new Bumper(230, 300, 230, 26);
      b29= new Bumper(770, 800, 100, 26);
      b30= new Bumper(770, 300, 230, 26);
      b31= new Bumper(385, 280, 26, 230);//mid upper
      b32= new Bumper(487, 296, 100, 26);    
      b33= new Bumper(185, 120, 26, 200);      
      b34= new Bumper(610, 120, 26, 200);     
      b35= new Bumper(265, 146, 100, 26);
      b36= new Bumper(690, 146, 100, 26);      
      
      t1 = new treat(500, 585);
      t = new Timer(0, new Listener());
      addKeyListener(new Key());
      setFocusable(true);
      addKeyListener(new Key1());
      setFocusable(true);
      
    
      t.start();
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), this);
      
   }
   private class Key extends KeyAdapter
   {
      private boolean isColliding(int x, int y)
      {
         if(myImage.getRGB(x, y) == -16776961){
            
            return true;
         }
         else  
            return false;
      }
      public void keyPressed(KeyEvent e)
      {
    	  
    	int speed = 10;
    	int d = 5;
    	int u = 10;
    	int r = 10;
    	int l = 10;
    	
    	
    	
    	//DOWN
         if(e.getKeyCode() == KeyEvent.VK_DOWN && pm.getY() < 980 && !isColliding((int)(pm.getX()+d), (int)(pm.getY()+d))){
            pm.setY(pm.getY()+speed);
            
         }
         if(e.getKeyCode()==KeyEvent.VK_DOWN && pm.getX() < 985 && isColliding((int)(pm.getX())+d, (int)(pm.getY())+d)){
            pm.setY(pm.getY()-speed);
            
         }
         //UP
         if(e.getKeyCode()==KeyEvent.VK_UP && pm.getY() > 15 && !isColliding((int)(pm.getX())-u, (int)(pm.getY())-u)){
            pm.setY(pm.getY()-speed);
            
         }
         if(e.getKeyCode()==KeyEvent.VK_UP && pm.getX() > 15 && isColliding((int)(pm.getX())-u, (int)(pm.getY())-u)){
            pm.setY(pm.getY()+speed);
            
         }
         //RIGHT
         if(e.getKeyCode()==KeyEvent.VK_RIGHT && pm.getX() < 985 && !isColliding((int)(pm.getX())+r, (int)(pm.getY())+r)){
            pm.setX(pm.getX()+speed);
            
         }
         if(e.getKeyCode()==KeyEvent.VK_RIGHT && pm.getX() < 985 && isColliding((int)(pm.getX())+r, (int)(pm.getY())+r)) {
            pm.setX(pm.getX()-speed);
            
         }
         //LEFT
         if(e.getKeyCode()==KeyEvent.VK_LEFT && pm.getX() > 15 && !isColliding((int)(pm.getX())-l, (int)(pm.getY())-l)){
            pm.setX(pm.getX()-speed);
            
         }
         if(e.getKeyCode()==KeyEvent.VK_LEFT && pm.getX() > 15 && isColliding((int)(pm.getX())-l, (int)(pm.getY())-l)) {
            pm.setX(pm.getX()+speed);
            
         
         }
         if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        	 notitle = 0;
         
       
      }
   }
   private class Key1 extends KeyAdapter
   {
      private boolean isColliding(int x, int y)
      {  
         if(myImage.getRGB(x, y) == -16776961){
             
            return true;
         }
         else  
            return false;
      }
      public void keyPressed(KeyEvent e)
      {
    	  int speed = 30;
      	int d = 5;
      	int u = 10;
      	int r = 10;
      	int l = 10;
    	  
    	//DON
          if(e.getKeyCode() == KeyEvent.VK_S && gt.getY() < 980 && !isColliding((int)(gt.getX()+d), (int)(gt.getY()+d))){
             gt.setY(gt.getY()+speed);
             
          }
          if(e.getKeyCode()==KeyEvent.VK_S && gt.getX() < 985 && isColliding((int)(gt.getX())+d, (int)(gt.getY())+d)){
             gt.setY(gt.getY()-speed);
             
          }
          //UP
          if(e.getKeyCode()==KeyEvent.VK_W && gt.getY() > 15 && !isColliding((int)(gt.getX())-u, (int)(gt.getY())-u)){
             gt.setY(gt.getY()-speed);
             
          }
          if(e.getKeyCode()==KeyEvent.VK_W && gt.getX() > 15 && isColliding((int)(gt.getX())-u, (int)(gt.getY())-u)){
             gt.setY(gt.getY()+speed);
             
          }
          //RIGHT
          if(e.getKeyCode()==KeyEvent.VK_D && gt.getX() < 985 && !isColliding((int)(gt.getX())+r, (int)(gt.getY())+r)){
             gt.setX(gt.getX()+speed);
             
          }
          if(e.getKeyCode()==KeyEvent.VK_D && gt.getX() < 985 && isColliding((int)(gt.getX())+r, (int)(gt.getY())+r)) {
             gt.setX(gt.getX()-speed);
             
          }
          //LEFT
          if(e.getKeyCode()==KeyEvent.VK_A && gt.getX() > 15 && !isColliding((int)(gt.getX())-l, (int)(gt.getY())-l)){
             gt.setX(gt.getX()-speed);
             
          }
          if(e.getKeyCode()==KeyEvent.VK_A && gt.getX() > 15 && isColliding((int)(gt.getX())-l, (int)(gt.getY())-l)) {
             gt.setX(gt.getX()+speed);
             
          
          }
          if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
         	 notitle = 0;
         	 resume = 1;
        
       }
      }
   }
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0,0, FRAME, FRAME);
         pm.setColor(Color.YELLOW);
         pm.draw(myBuffer);
         gt.setColor(Color.ORANGE);
         collide(pm,gt);
         getTheTreat(pm, t1);
         titleScreen();
         gt.draw(myBuffer);
         b1.draw(myBuffer);
         b2.draw(myBuffer);
         b3.draw(myBuffer);
         b4.draw(myBuffer);
         b5.draw(myBuffer);
         b6.draw(myBuffer);
         b7.draw(myBuffer);
         b8.draw(myBuffer);
         b9.draw(myBuffer);
         b10.draw(myBuffer);
         b11.draw(myBuffer);
         b12.draw(myBuffer);
         b13.draw(myBuffer);
         b14.draw(myBuffer);
         b15.draw(myBuffer);
         b16.draw(myBuffer);
         b17.draw(myBuffer);
         b18.draw(myBuffer);
         b19.draw(myBuffer);
         b20.draw(myBuffer);
         b21.draw(myBuffer);
         b22.draw(myBuffer);
         b23.draw(myBuffer);
         b24.draw(myBuffer);
         b25.draw(myBuffer);
         b26.draw(myBuffer);
         b27.draw(myBuffer);
         b28.draw(myBuffer);
         b29.draw(myBuffer);
         b30.draw(myBuffer);
         b31.draw(myBuffer);
         b32.draw(myBuffer);
         b33.draw(myBuffer);
         b34.draw(myBuffer);
         b35.draw(myBuffer);
         b36.draw(myBuffer);
         b37.draw(myBuffer);
        
         
         t1.draw(myBuffer);
         repaint();
         
      }
   }
   
   
   //testing
   public void titleScreen()
   {
	   if(notitle == 0)
	   {
		   
	   label=new JLabel("PACGHOST- Competitive PACMAN spinoff");
       label.setFont(new Font("Courier",Font.BOLD, 40)); //serif
       label.setForeground(Color.white);
       label.setBackground(Color.gray);
       label.setOpaque(true);
       add(label);
       
       
       JButton button3 = new JButton("QUIT TO DESKTOP");
       button3.setFont(new Font("Arial", Font.PLAIN, 40));
       button3.setPreferredSize(new Dimension(400, 100));
       button3.setBounds(500, 500, 100, 100);
       button3.addActionListener(new Listener3());
       button3.setBorderPainted(false);
       button3.setFocusPainted(false);
       button3.setBackground(Color.red);
       button3.setSize(new Dimension(100, 100));
       add(button3);
       
       
       JButton button2 = new JButton("PLAY PACGHOST");
       
       
       
       button2.setFont(new Font("Arial", Font.PLAIN, 40));
       button2.setPreferredSize(new Dimension(400, 100));
       button2.setBounds(500, 500, 100, 100);
       button2.addActionListener(new Listener2());
       button2.setBorderPainted(false);
       button2.setFocusPainted(false);
       button2.setBackground(Color.green);
       button2.setSize(new Dimension(100, 100));
       add(button2);
       
       JButton button4 = new JButton("INSTRUCTIONS");
       button4.setFont(new Font("Arial", Font.PLAIN, 40));
       button4.setPreferredSize(new Dimension(400, 100));
       button4.setBounds(500, 500, 100, 100);
       button4.addActionListener(new Listener4());
       button4.setBorderPainted(false);
       button4.setFocusPainted(false);
       button4.setBackground(Color.gray);
       button4.setSize(new Dimension(100, 100));
       add(button4);
       
       if(resume == 1)
       {
       JButton buttonR = new JButton("RESUME");
       buttonR.setFont(new Font("Arial", Font.PLAIN, 40));
       buttonR.setPreferredSize(new Dimension(400, 100));
       buttonR.setBounds(500, 500, 100, 100);
       buttonR.addActionListener(new ListenerR());
       buttonR.setBorderPainted(false);
       buttonR.setFocusPainted(false);
       buttonR.setBackground(Color.orange);
       buttonR.setSize(new Dimension(100, 100));
       add(buttonR);
       }
       revalidate();
	   
	   notitle++;
	   }
   }
   
   private class Listener3 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
   
   private class ListenerR implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         removeAll();
      }
   }
   
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         pm.setX(500);
         pm.setY(940);
         gt.setX(490);
         gt.setY(180);
         removeAll();
         notagain = 0;
         score = 0;
  
      }
   }
   
   private class Listener4 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	  removeAll();
    	  
    	  
    	  
    	  
    	  label=new JLabel("Instructions");
          label.setFont(new Font("Courier",Font.BOLD, 40)); //serif
          label.setForeground(Color.white);
          label.setBackground(Color.gray);
          label.setOpaque(true);
          add(label);
          
          
          labelT=new JLabel("<html>		The red player uses WASD keys to move.<br> 		Its objective is to touch yellow player.<br> Meanwhile, yellow wishes to amass the highest score possible by collecting treats.<br> He can move by arrow keys.<br> To begin playing, press esc, then select PLAY.</html> ");
          labelT.setFont(new Font("Courier",Font.BOLD, 20)); //serif
          labelT.setForeground(Color.white);
          labelT.setBackground(Color.BLACK);
          labelT.setOpaque(true);
          labelT.setBounds(100, 100, 400, 600);
          add(labelT);
      }
   }
   
   
   
   
   
   
   
   
   
   private double distance(double x1,double y1,double x2,double y2)
   {
      return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
   }
   public void collide(Pacman p,Ghost g)
   {
      double dist = distance(p.getX(),p.getY(),g.getX(),g.getY());
      
      if(dist < (p.getLength()/2)+(g.getLength()/2) && notagain == 0)
      { 
         label=new JLabel("Game Over. Ghost Wins");
         label.setFont(new Font("Courier",Font.BOLD, 80)); //serif
         label.setForeground(Color.white);
         add(label);
         
         
         JButton button = new JButton("QUIT");
         button.setFont(new Font("Arial", Font.PLAIN, 40));
         button.setPreferredSize(new Dimension(400, 100));
         button.setBounds(500, 500, 100, 100);
         button.addActionListener(new Listener12());
         button.setBorderPainted(false);
         button.setFocusPainted(false);
         button.setBackground(Color.red);
         button.setSize(new Dimension(100, 100));
         add(button);
         
         JButton button1 = new JButton("PLAY AGAIN");
         button1.setFont(new Font("Arial", Font.PLAIN, 40));
         button1.setPreferredSize(new Dimension(400, 100));
         button1.setBounds(500, 500, 100, 100);
         button1.addActionListener(new Listener13());
         button1.setBorderPainted(false);
         button1.setFocusPainted(false);
         button1.setBackground(Color.green);
         button1.setSize(new Dimension(100, 100));
         add(button1);

         revalidate();
         
         notagain ++;
    	 
      }
     
   }
   private class Listener12 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
   private class Listener13 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         pm.setX(500);
         pm.setY(940);
         gt.setX(500);
         gt.setY(55);
         removeAll();
         notagain = 0;
         t1.jump();
      }
   }
   
   public void getTheTreat(Pacman p, treat t)
   {
      double dist = distance(p.getX(),p.getY(),t.getX(),t.getY());
      if(dist < (p.getLength()/2)+(12/2))
      {
    	  t1.jump();
    	  score++;
    	  System.out.println(" " + score);
    	  
    	  if(score < maxScore)
    	  	{
    		     removeAll();
	    		 labelScore=new JLabel("Score: "+score);
	          	 labelScore.setFont(new Font("Courier",Font.BOLD, 40)); //serif
	          	 labelScore.setForeground(Color.white);
	          	 labelScore.setBounds(400, 450, 300, 60);
	        	 add(labelScore);
    	  
	        	 
    	  	}
    	  else
    	  	{
    		  	 label=new JLabel("Game Over. Ghost Wins");
    	         label.setFont(new Font("Courier",Font.BOLD, 80)); //serif
    	         label.setForeground(Color.white);
    	         add(label);
    	         
    	         score = 0; //reset score
    	         
    	         JButton button = new JButton("QUIT");
    	         button.setFont(new Font("Arial", Font.PLAIN, 40));
    	         button.setPreferredSize(new Dimension(400, 100));
    	         button.setBounds(500, 500, 100, 100);
    	         button.addActionListener(new Listener12());
    	         button.setBorderPainted(false);
    	         button.setFocusPainted(false);
    	         button.setBackground(Color.red);
    	         button.setSize(new Dimension(100, 100));
    	         add(button);
    	         
    	         JButton button1 = new JButton("PLAY AGAIN");
    	         button1.setFont(new Font("Arial", Font.PLAIN, 40));
    	         button1.setPreferredSize(new Dimension(400, 100));
    	         button1.setBounds(500, 500, 100, 100);
    	         button1.addActionListener(new Listener13());
    	         button1.setBorderPainted(false);
    	         button1.setFocusPainted(false);
    	         button1.setBackground(Color.green);
    	         button1.setSize(new Dimension(100, 100));
    	         add(button1);

    	         revalidate();
    	         
    	         notagain ++;
    	  	}
    	  
      }
      
    	  
   }
}