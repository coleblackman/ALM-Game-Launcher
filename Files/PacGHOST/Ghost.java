import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Ghost extends Polkadot
{

   private double myX;   
   private double myY;
   private double myLength;
   private double myWidth;
   private Color myColor;
   
   public Ghost()
   {
      myX = 10;
      myY = 10;
      myLength = 25;
     
      
   }
   public Ghost(int x, int y, int d)
   {
      myX = x;
      myY = y;
      myWidth = d;
      myLength = d;
   }
   
   
   public double getX() 
      { 
         return myX;
      }
      public double getY()      
      { 
         return myY;
      }
     public double getWidth() 
     { 
        return myWidth;
     }
      public Color getColor() 
      { 
         return myColor;
      }
      public double getLength() 
      { 
         return myLength;
      }
      
      
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
      public void setWidth(double d)
      {
         myWidth = d;
        // myRadius = d/2;
      }
   // public void setRadius(double r)
     // {
        // myRadius = r;
        // myWidth = 2*r;
     // }
      
     }