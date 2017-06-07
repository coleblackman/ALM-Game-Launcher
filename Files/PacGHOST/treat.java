
import java.awt.*;
import java.awt.image.BufferedImage;

public class treat {
	private int myX;
	private int myY;
	private double myDiameter;
	private Color myColor;
	private double myRadius;
	private static final Color white = new Color(255, 255, 255);
	private BufferedImage myImage;
	private Graphics myBuffer;

	public treat() {
		myX = 200;
		myY = 200;
		myDiameter = 25;
		myColor = Color.RED;
		myRadius = myDiameter / 2;
	}

	public treat(int x, int y) {
		myX = x;
		myY = y;
		myDiameter = 12;
		myColor = white;
		myRadius = 6;
	}

	public int getX() {
		return myX;
	}

	public int getY() {
		return myY;
	}

	public double getDiameter() {
		return myRadius * 2;
	}

	public Color getColor() {
		return myColor;
	}

	public double getRadius() {
		return myRadius;
	}

	// modifier methods
	public void setX(int x) {
		myX = x;
	}

	public void setY(int y) {
		myY = y;
	}

	public void setColor(Color c) {
		myColor = c;
	}

	private boolean isColliding(int x, int y) {
		//myImage = new BufferedImage(900, 900, BufferedImage.TYPE_INT_RGB);
		//myBuffer = myImage.getGraphics();
		
		if (myImage.getRGB(x, y) != -16777216 || myImage.getRGB(x, y) == -16776961 || myImage.getRGB(x, y) == -12566464) {

			return true;
		} else
			return false;
	}

	public void jump(int x, int y) 
	{
		
		int a = (int) (Math.random() * 870 + 100);
		int b = (int) (Math.random() * 870 + 100);
		System.out.println(a + " " + b);
		myImage = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		
		while(isColliding(a, b)) // the color of black is -16777216 and blue = -16776961
		{
			a = (int) (Math.random() * 870 + 100);
			b = (int) (Math.random() * 870 + 100);
			System.out.println(a + " " + b);
			myX = a;
			myY = b;
		}
		myX = a;
		myY = b;

	}

	public void draw(Graphics myBuffer) {
		myBuffer.setColor(myColor);
		myBuffer.fillOval((int) (getX() - getRadius()), (int) (getY() - getRadius()), (int) getDiameter(),
				(int) getDiameter());

	}
}