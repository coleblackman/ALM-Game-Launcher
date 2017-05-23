//John Link Cole Blackman 5/10/17
public class Knight extends Piece {
	public static boolean isValidMoveBlack(int fy, int fx, int sx, int sy)
	{
		if(sy >= 9 || sx >= 9)
		{
			return false;
			
		}
			
		else if(GUIPanel.b1[sx][sy].getText() != "")
		{
			return false;
		}
		else if(   ((fx + 1 == sx) && (fy + 2 == sy || fy - 2 == sy)) 
				|| ((fx + 2 == sx) && (fy + 1 == sy || fy - 1 == sy)) 
				|| ((fx - 1 == sx) && (fy + 2 == sy || fy - 2 == sy)) 
				|| ((fx - 2 == sx) && (fy + 1 == sy || fy - 1 == sy)))
		{
			
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
