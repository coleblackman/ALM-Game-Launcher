

   import java.awt.*;
import java.awt.image.BufferedImage;
   
   public class treat
   {
      private double myX;   
      private double myY;
      private double myDiameter;
      private Color myColor; 
      private double myRadius;
      
      private BufferedImage myImage;
      private Graphics myBuffer;
    
      public treat()     
      {
         myX = 200;
         myY = 200;
         myDiameter = 25;
         myColor = Color.RED;
         myRadius = myDiameter/2;
      }
      public treat(double x, double y)
      {
         myX = x;
         myY = y;
         myDiameter = 12;
         myColor = Color.WHITE;
         myRadius = 6;
      }
   
      public double getX() 
      { 
         return myX;
      }
      public double getY()      
      { 
         return myY;
      }
      public double getDiameter() 
      { 
         return myRadius*2;
      }
      public Color getColor() 
      { 
         return myColor;
      }
      public double getRadius() 
      { 
         return myRadius;
      }
   // modifier methods
      public void setX(double x)
      {
         myX = x;
      } 
      public void setY(double y)
      {
         myY = y;
      } 
      public void setColor(Color c)
      {
         myColor = c;
      }
      private boolean isColliding(int x, int y)
      {
    	  myImage =  new BufferedImage(900, 900, BufferedImage.TYPE_INT_RGB);
          myBuffer = myImage.getGraphics();
          
         if(myImage.getRGB(x, y) == -16776961){
            
            return true;
         }
         else  
            return false;
      }
      public void jump()
      {
    	  
    	  
    	  	int X = (int)(Math.random()* (900-myDiameter) + myRadius);
      	 	int Y = (int)(Math.random()* (900-myDiameter) + myRadius);
      	 	while(isColliding(X, Y))
      	 	{
      	 		X = (int)(Math.random()* (900-myDiameter) + myRadius);
      	 		Y = (int)(Math.random()* (900-myDiameter) + myRadius);
      	 	}
      	 	myX = X;
      	 	myY = Y;
      }
      public void draw(Graphics myBuffer) 
      {
         myBuffer.setColor(myColor);
         myBuffer.fillOval((int)(getX() - getRadius()), (int)(getY()-getRadius()), (int)getDiameter(), (int)getDiameter());
         
         
         
      }
   }