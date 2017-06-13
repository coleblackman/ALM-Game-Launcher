
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;

public class treat
{
	private int myX;
	private int myY;
	private double myDiameter;
	private Color myColor;
	private double myRadius;
	public static Graphics myBuffer2;
	private static final Color white = new Color(255, 255, 255);
	private BufferedImage myImage2 = new BufferedImage(PanelPac.FRAME, PanelPac.FRAME, BufferedImage.TYPE_INT_RGB);

	public treat()
	{
		myX = 200;
		myY = 200;
		myDiameter = 25;
		myColor = Color.RED;
		myRadius = myDiameter / 2;

	}

	public treat(int x, int y)
	{
		myX = x;
		myY = y;
		myDiameter = 12;
		myColor = white;
		myRadius = 6;
		PanelPac.bumpermaker();
		myBuffer2 = myImage2.getGraphics();
		myBuffer2.setColor(Color.BLACK);
		myBuffer2.fillRect(0, 0, PanelPac.FRAME, PanelPac.FRAME);
		for (int g = 0; g < 36; g++)
		{
			PanelPac.b1[g].draw(myBuffer2);
		}
		myBuffer2 = myImage2.getGraphics();
	}
	/** Accessor methods*/
	public int getX()
	{
		return myX;
	}

	public int getY()
	{
		return myY;
	}

	public double getDiameter()
	{
		return myRadius * 2;
	}

	public Color getColor()
	{
		return myColor;
	}

	public double getRadius()
	{
		return myRadius;
	}

	/** modifier methods */
	public void setX(int x)
	{
		myX = x;
	}

	public void setY(int y)
	{
		myY = y;
	}

	public void setColor(Color c)
	{
		myColor = c;
	}
	/** Instance methods*/
	private boolean isColliding(int x, int y)//uses color values to determine if there is a collision
	{

		if (myImage2.getRGB(x, y) != -16777216 || myImage2.getRGB(x, y) == -16776961//these are color values, we use getRGB for all collision analysis
				|| myImage2.getRGB(x, y) == -12566464)
		{

			return true;
		} else
			return false;
	}

	public void jump(int x, int y)
	{
		do
		{
			int a = (int) (Math.random() * 870 + 100);
			int b = (int) (Math.random() * 870 + 100);
			myX = a;
			myY = b;
		} while (isColliding(myX, myY));
	}

	public void draw(Graphics myBuffer)
	{
		myBuffer.setColor(myColor);
		myBuffer.fillOval((int) (getX() - getRadius()), (int) (getY() - getRadius()), (int) getDiameter(),
				(int) getDiameter());

	}
}