//John Link Cole Blackman 5/10/17
public class Piece
{
	public static void move(int fx, int fy, int sx, int sy)
	{
		GUIPanel.b1[sx][sy].setText(GUIPanel.b1[fx][fy].getText());
		GUIPanel.b1[fx][fy].setText("");
		
		
	}
	
}