//John Link Cole Blackman 5/10/17
import java.awt.Color;

import javax.swing.JComponent;
public class Pawn extends Piece {
	  public static boolean isValidMoveBlack(int fy, int fx, int sx, int sy)
	  {
		  if((fy+1 == sy) || (sy == 4))//if the move is valid for a black pawn (it is a one move)
		  {
			  if(GUIPanel.b1[fx][fy].getText() == "\u265F" && ((sx == fx) && (GUIPanel.b1[sx][sy].getText() == "" )) 
					  || (((fx-1 == sx) || fx +1 == sx)
							  && (fy + 1 == sy)
							  && (GUIPanel.b1[sx][sy].getText() != "")))//&& GUIPanel.isWhiteTurn != true
				  return true;
			  else
				  return false;
		  }
		  else
			  return false;
	  }
	  public static boolean isValidMoveWhite(int fx, int fy, int sx, int sy)
	  {
		 
		  
		  if((fy-1 == sy) || (sy == 5))//if the move is valid for a black pawn (it is a one move)
		  {
			  if((GUIPanel.b1[fy][fx].getText() == "\u2659") && ((sx == fx) && (GUIPanel.b1[sy][sx].getText() == "" )) 
					  || (((fx+1 == sx) || fx -1 == sx) 
							  && (fy-1 == sy) 
							  && (GUIPanel.b1[sy][sx].getText() != "")))//&& GUIPanel.isWhiteTurn 
				return true;
			  else
				  return false;
		  }
		  else
			  return false;
	  }
	  public static void bmove(int fx, int fy, int sx, int sy)
		{
			
			GUIPanel.b1[sy][sx].setText("\u265F");
			GUIPanel.b1[fy][fx].setText("");
			
		}
	  public static void wmove(int fx, int fy, int sx, int sy)
		{
			
			GUIPanel.b1[sy][sx].setText("\u2659");
			GUIPanel.b1[sy][sx].setForeground(Color.WHITE);
			GUIPanel.b1[fy][fx].setText("");
			
		}
}