import java.awt.Color;

//Chris Link Cole Blackman 5/10/17
public class King extends Piece {
	public static boolean isValidMoveWhite(int fy, int fx, int sx, int sy)
	{
		if(!(sy >9) || !(sx >= 9))
		{
			return false;
			
		}
			
		else if(GUIPanel.b1[sx][sy].getText() != "" ||  GUIPanel.b1[sx][sy].getForeground() == Color.black)
		{
			return false;
		}
	}
}
