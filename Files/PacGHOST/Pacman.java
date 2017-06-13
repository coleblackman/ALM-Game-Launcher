import java.awt.*;

//import javax.swing.*;
public class Pacman extends Polkadot
{

	private double myX;//private fields
	private double myY;
	private double myWidth;
	private double myLength;
	private Color myColor;

	public Pacman()
	{
		myX = 10;
		myY = 10;
		myWidth = 25;
		myLength = 25;

	}

	public Pacman(int x, int y, int d, Color c) /**  creates a pacman object of any color at any position*/
	{
		myX = x;
		myY = y;
		myLength = d;
		myWidth = d;
		myColor = c;
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

	public double getLength()
	{
		return myLength;
	}

	public double getWidth()
	{
		return myWidth;
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

	public void setLength(double d)
	{
		myLength = d;
	}

	public void setWidth(double d)
	{
		myWidth = d;
	}
}