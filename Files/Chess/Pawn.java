//John Link Cole Blackman 5/10/17
public class Pawn extends Piece {
	  public boolean isValidMoveBlack(int fx, int fy, int sx, int sy)
	  {
		  if(GUIPanel.b1[fx][fy+1].getText().trim().isEmpty())//if the move is valid for a black pawn (it is empty)
		  {
			  return true;
		  }
		  else
			  return false;
	  }
}