
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;

public class treat {
	private int myX;
	private int myY;
	private double myDiameter;
	private Color myColor;
	private double myRadius;
	private static final Color white = new Color(255, 255, 255);
	public ImageIcon board = new ImageIcon("board.png");
	public static BufferedImage myImage2 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
	public static Graphics myBuffer2;

	public void draw2()
	{
		myBuffer2 = myImage2.getGraphics();
		myBuffer2.drawImage(board, 0, 0, 1000, 1000, null);
	}

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
		
		if (PanelPac.myImage.getRGB(x, y) != -16777216 || PanelPac.myImage.getRGB(x, y) == -16776961 || PanelPac.myImage.getRGB(x, y) == -12566464) {

			return true;
		} else
			return false;
	}

	public void jump(int x, int y) 
	{
		System.out.println(PanelPac.myImage.getRGB(500, 500));
		do
		{
		int a = (int) (Math.random() * 870 + 100);
		int b = (int) (Math.random() * 870 + 100);
		myX = a;
		myY = b;
		System.out.println(a + " " + b);
		System.out.println(PanelPac.myImage.getRGB(myX, myY));
		
		}while(isColliding(myX, myY));
		}

	public void draw(Graphics myBuffer) {
		myBuffer.setColor(myColor);
		myBuffer.fillOval((int) (getX() - getRadius()), (int) (getY() - getRadius()), (int) getDiameter(),
				(int) getDiameter());

	}
}