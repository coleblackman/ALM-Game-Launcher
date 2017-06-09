
import java.awt.*;

public class Bumper {
	private int myX;
	private int myY;
	private int myYWidth;
	private int myXWidth;
	private Color myColor;

	public Bumper() {
		myX = 20;
		myY = 20;
		myYWidth = 100;
		myXWidth = 50;
		myColor = Color.BLUE;
	}

	public Bumper(int x, int y, int mx, int my) {
		myX = x;
		myY = y;
		myYWidth = mx;
		myXWidth = my;
		myColor = Color.BLUE;
	}

	public Bumper(int x, int y, int mx, int my, int zzz) {
		myX = x;
		myY = y;
		myYWidth = mx;
		myXWidth = my;
		myColor = Color.DARK_GRAY;
	}

	public int getX() {
		return myX;
	}

	public int getY() {
		return myY;
	}

	public int getYWidth() {
		return myYWidth;
	}

	public int getXWidth() {
		return myXWidth;
	}

	public Color getColor() {
		return myColor;
	}

	public void setX(int x) {
		myX = x;
	}

	public void setY(int y) {
		myY = y;
	}

	public void setColor(Color c) {
		myColor = c;
	}

	public void setYWidth(int yWidth) {
		myYWidth = yWidth;
	}

	public void setXWidth(int xWidth) {
		myXWidth = xWidth;
	}

	public void draw(Graphics myBuffer) {
		myBuffer.setColor(getColor());
		myBuffer.fillRect(getX(), getY(), (int) getXWidth(), (int) getYWidth());
	}

	public boolean inBumper(Pacman pm) {
		for (int x = (int) getX(); x <= (int) getX() + (int) getXWidth(); x++)
			for (int y = (int) getY(); y <= (int) getY() + (int) getYWidth(); y++)
				if (distance(x, y, pm.getX(), pm.getY()) <= pm.getLength())
					return true;
		return false;
	}

	public boolean inBumper(Ghost gt) {
		for (int x = (int) getX(); x <= (int) getX() + (int) getXWidth(); x++)
			for (int y = (int) getY(); y <= (int) getY() + (int) getYWidth(); y++)
				if (distance(x, y, gt.getX(), gt.getY()) <= gt.getLength())
					return true;
		return false;
	}

	private double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}
