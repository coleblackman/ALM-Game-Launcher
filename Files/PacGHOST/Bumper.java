
import java.awt.*;

public class Bumper
{
	private int myX;
	private int myY;
	private int myYWidth;
	private int myXWidth;
	private Color myColor;

	public Bumper()  /** Creates a default bumper*/
	{
		myX = 20;
		myY = 20;
		myYWidth = 100;
		myXWidth = 50;
		myColor = Color.BLUE;
	}

	public Bumper(int x, int y, int mx, int my)  /** creates a blue bumper at the specified location for the specified width and length!*/
	{
		myX = x;
		myY = y;
		myYWidth = mx;
		myXWidth = my;
		myColor = Color.BLUE;
	}

	public Bumper(int x, int y, int mx, int my, int zzz)  /** for the gray bumper in the middle, just add a comma 1 at the end to make it gray*/
	{
		myX = x;
		myY = y;
		myYWidth = mx;
		myXWidth = my;
		myColor = Color.DARK_GRAY;
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

	public int getYWidth()
	{
		return myYWidth;
	}

	public int getXWidth()
	{
		return myXWidth;
	}

	public Color getColor()
	{
		return myColor;
	}
	/** modifier methods*/
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

	public void setYWidth(int yWidth)
	{
		myYWidth = yWidth;
	}

	public void setXWidth(int xWidth)
	{
		myXWidth = xWidth;
	}
	/** Instance methods*/
	public void draw(Graphics myBuffer) //the method to draw the bumpers
	{
		myBuffer.setColor(getColor());
		myBuffer.fillRect(getX(), getY(), (int) getXWidth(), (int) getYWidth());
	}
	
}
