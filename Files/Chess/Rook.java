//John Link Cole Blackman 5/10/17
public class Rook extends Piece 
{
	  public static boolean isValidMoveBlack(int fx, int fy, int sx, int sy)
	  {
		  if(GUIPanel.b1[fy][fx+1].getText().trim().isEmpty() && GUIPanel.b1[fy][fx-1].getText().trim().isEmpty() && GUIPanel.b1[fy+1][fx].getText().trim().isEmpty() && GUIPanel.b1[fy-1][fx].getText().trim().isEmpty())//if the move is valid for a black pawn (it is empty)
		  {
			  if(GUIPanel.b1[sy][sx].getText().trim().isEmpty())
			  {
				  if(GUIPanel.isWhiteTurn == false)
				  {
				  return true;
				  }
				  else
				  {
					  return false;
				  }
			  }
			  else
			  {
				  return false;
			  }
		  }
		  else
		  {
			  return false;
		  }
	  }
		 public static boolean isValidMoveWhite(int fx2, int fy2, int sx2, int sy2)
		  {
			 
			 int g = fx2;
			 while(g <= sx2)
			 {
			 	GUIPanel.b1[fy2][g].getText().trim().isEmpty();
			 	g++;
			 	if(GUIPanel.b1[sy2][sx2].getText().trim().isEmpty())
				  {
					  if(GUIPanel.isWhiteTurn == true)
					  {
					  return true;
					  }
					  else
					  {
						  return false;
					  }
				  }
				  else
				  {
					  return false;
				  }
			  }
			return false;
			  
		  }
	  
	  
}







	
	
	
	