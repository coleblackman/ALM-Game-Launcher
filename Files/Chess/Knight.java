import java.awt.Color;

public class Knight extends Piece {
	public static boolean isValidMoveBlack(int fy, int fx, int sx, int sy)
	{
		if(GUIPanel.b1[fy][fx].getText() != "\u265E")
			return false;
		if(GUIPanel.b1[sx][sy].getText() != "" || GUIPanel.b1[sx][sy].getForeground() == Color.BLACK)
		{
			return false;
		}
		
		if(        !(((fy + 1 == sx) && (fx + 2 == sy || fx - 2 == sy)) 
				|| ((fy + 2 == sx) && (fx + 1 == sy || fx - 1 == sy)) 
				|| ((fy - 1 == sx) && (fx + 2 == sy || fx - 2 == sy)) 
				|| ((fy - 2 == sx) && (fx + 1 == sy || fx - 1 == sy))))
		{
			
			return false;
		}
		else
		{
			return true;
		}
	
		
	}
	public static boolean isValidMoveWhite(int fx, int fy, int sx, int sy)
	{
//System.out.println("WOO"+fx+fy+sx+sy + "\u2656" + GUIPanel.b1[fy][fx].getText());
		if(GUIPanel.b1[fy][fx].getText() != "\u2658")
			{
			System.out.println("Yes");
				return false;
			}
		if(GUIPanel.b1[sx][sy].getText() != "" && GUIPanel.b1[sx][sy].getText() != "\u2658" && GUIPanel.b1[sx][sy].getText() != "\u2657" && GUIPanel.b1[sx][sy].getText() != "\u2654" && GUIPanel.b1[sx][sy].getText() != "\u265A" && GUIPanel.b1[sx][sy].getText() != "\u2655" && GUIPanel.b1[sx][sy].getText() != "\u265B")
		{
			//System.out.println("Hello");
			return false;
		}
		
		System.out.println("WOO"+fx+fy+sx+sy + "\u2656" + GUIPanel.b1[fy][fx].getText());
		if(sx != fx - 1 && sx != fx + 1 && sx != fx + 2 && sx != fx - 2	&& sy != fy - 2 && sy != fy + 2 && sy != fy- 1 && sy != fy + 1)
		{
			System.out.println("made it");
			return false;
			
		}				
						
						
						
				
		
	
			return true;
		
	
	}

	public static void bmove(int fx, int fy, int sx, int sy)
	{
		
		GUIPanel.b1[sy][sx].setText("\u265E");
		GUIPanel.b1[fy][fx].setText("");
		
		GUIPanel.b1[fy][fx].setForeground(Color.WHITE);
		
	}
  public static void wmove(int fx, int fy, int sx, int sy)
	{
		
		GUIPanel.b1[sy][sx].setText("\u2658");
		GUIPanel.b1[sy][sx].setForeground(Color.WHITE);
		GUIPanel.b1[fy][fx].setText("");
		
	}
}