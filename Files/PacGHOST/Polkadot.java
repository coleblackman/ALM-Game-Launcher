
// version: 7.25.2007
// updated by Phil Ero 16NOV07

import java.awt.*;

public class Polkadot
{
	private double myX; /** */
	private double myY; /** */
	private double myDiameter; /** */
	private Color myColor; /** */
	private double myRadius; /** */
 
	/** */
	public Polkadot() /** */
	{
		myX = 200;
		myY = 200;
		myDiameter = 25;
		myColor = Color.RED;
		myRadius = myDiameter / 2;
	}

	public Polkadot(double x, double y, double d, Color c) /** */
	{
		myX = x;
		myY = y;
		myDiameter = d;
		myColor = c;
		myRadius = d / 2;
	}

	/** Accessor methods*/
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

	/** modifier methods*/
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

	public void setDiameter(double d)
	{
		myDiameter = d;
		myRadius = d / 2;
	}

	public void setRadius(double r)
	{
		myRadius = r;
		myDiameter = 2 * r;
	}

	/** Instance methods*/
	public void draw(Graphics myBuffer)//draws ghost and pacman because they extend this class
	{
		myBuffer.setColor(myColor);
		myBuffer.fillOval((int) (getX() - getRadius()), (int) (getY() - getRadius()), (int) getDiameter(),
				(int) getDiameter());

	}
}