
//John Link Cole Blackman 5/10/17
import java.awt.Color;

public class Knight extends Piece
{
	public static boolean isValidMoveBlack(int fx, int fy, int sx, int sy)
	{
		for (int i = 0; i < 6; i++)
		{

			if (GUIPanel.b1[sy][sx].getText().equals(Character.toString(GUIPanel.AllBlackPieces[i])))
				return false;
		}
		if (GUIPanel.b1[fy][fx].getText() != "\u265E")
		{
			return false;
		}
		if ((((fx + 1 == sx) || (fx - 1 == sx)) && (fy - 2 == sy))

				|| (((fx + 2 == sx) || (fx - 2 == sx)) && (fy - 1 == sy))
				|| (((fx + 1 == sx) || (fx - 1 == sx)) && (fy + 2 == sy))
				|| (((fx + 2 == sx) || (fx - 2 == sx)) && (fy + 1 == sy)))
			return true;
		else
			return false;

	}

	public static boolean isValidMoveWhite(int fx, int fy, int sx, int sy)
	{

		for (int i = 0; i < 6; i++)
		{

			if (GUIPanel.b1[sy][sx].getText().equals(Character.toString(GUIPanel.AllWhitePieces[i])))
				return false;
		}
		if (GUIPanel.b1[fy][fx].getText() != "\u2658")
		{
			return false;
		}

		if ((((fx + 1 == sx) || (fx - 1 == sx)) && (fy - 2 == sy))

				|| (((fx + 2 == sx) || (fx - 2 == sx)) && (fy - 1 == sy))
				|| (((fx + 1 == sx) || (fx - 1 == sx)) && (fy + 2 == sy))
				|| (((fx + 2 == sx) || (fx - 2 == sx)) && (fy + 1 == sy)))
			return true;
		else
			return false;
	}

	public static void bmove(int fx, int fy, int sx, int sy)
	{

		GUIPanel.b1[sy][sx].setText("\u265E");
		GUIPanel.b1[sy][sx].setForeground(Color.BLACK);
		GUIPanel.b1[fy][fx].setText("");

	}

	public static void wmove(int fx, int fy, int sx, int sy)
	{

		GUIPanel.b1[sy][sx].setText("\u2658");
		GUIPanel.b1[sy][sx].setForeground(Color.WHITE);
		GUIPanel.b1[fy][fx].setText("");

	}
}
