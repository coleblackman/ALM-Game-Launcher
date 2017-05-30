//John Link Cole Blackman 5/10/17
import java.awt.Color;
public class King extends Piece {
		
	  public static boolean isValidMoveBlack(int fy, int fx, int sx, int sy)
	  {
		return false;
	  }
	  public static boolean isValidMoveWhite(int fx, int fy, int sx, int sy)
	  {
		  if(GUIPanel.b1[fy][fx].getText() != "\u2654")
			{
				return false;
			}
		for (int i = 0; i < 6; i++) { //for loop to iterate through all possible white pieces and makes sure that the second position is not a white piece.
			System.out.println(GUIPanel.b1[sy][sx].getText() + " " + Character.toString(GUIPanel.AllWhitePieces[i]));
			if (GUIPanel.b1[sy][sx].getText().equals(Character.toString(GUIPanel.AllWhitePieces[i])))
				return false;
		}
		  
		  
		  if(Math.abs(sx - fx) != 1 && Math.abs(sy - fy) != 1)
			  return false;
		  
		  
		  
		  GUIPanel.WhiteKingHasMoved = true;
		  return true;
		  
		
	  }
	  public static void bmove(int fx, int fy, int sx, int sy)
		{
			
			GUIPanel.b1[sy][sx].setText("\u265A");
			GUIPanel.b1[fy][fx].setText("");
			
		}
	  public static void wmove(int fx, int fy, int sx, int sy)
		{
			
			GUIPanel.b1[sy][sx].setText("\u2654");
			GUIPanel.b1[sy][sx].setForeground(Color.WHITE);
			GUIPanel.b1[fy][fx].setText("");
			
		}
}
