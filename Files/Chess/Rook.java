import java.awt.Color;

//John Link Cole Blackman 5/10/17
public class Rook extends Piece
{
	public static boolean isValidMoveBlack(int fx, int fy, int sx, int sy)
	{
		if (GUIPanel.b1[fy][fx].getText() != "\u265C")
		{

			return false;
		}
		for (int i = 0; i < 6; i++)
		{ // for loop to iterate through all
			// possible white pieces and makes sure
			// that the second position is not a
			// black piece.
			if (GUIPanel.b1[sy][sx].getText().equals(Character.toString(GUIPanel.AllBlackPieces[i])))
				return false;
		}
		if (fy == sy)// right and left
		{
			if (fx < sx)// right
			{
				for (int i = fx + 1; i <= sx - 1; i++)
				{
					if (GUIPanel.b1[fy][i].getText() != "")
						return false;
				}
			} else
			{
				// left
				for (int u = fx - 1; u >= sx + 1; u = u - 1)
				{
					if (GUIPanel.b1[fy][u].getText() != "")
						return false;
				}
			}
		} else if (fx == sx)
		{
			if (fy < sy)
			{
				for (int y = fy + 1; y <= sy - 1; y++)
				{
					if (GUIPanel.b1[y][fx].getText() != "")
						return false;
				}
			} else
			{
				for (int t = fy - 1; t >= sy + 1; t--)
				{
					if (GUIPanel.b1[t][fx].getText() != "")
						return false;
				}
			}
		} else
		{
			return false;
		}

		return true;

	}

	public static boolean isValidMoveWhite(int fx, int fy, int sx, int sy)
	{
		for (int i = 0; i < 6; i++)
		{ // for loop to iterate through all
			// possible white pieces and makes sure
			// that the second position is not a
			// white piece.
			if (GUIPanel.b1[sy][sx].getText().equals(Character.toString(GUIPanel.AllWhitePieces[i])))
				return false;
		}
		if (fx == sx && fy == sy)
			return false;
		if (GUIPanel.b1[fy][fx].getText() != "\u2656")
		{

			return false;
		}

		if (fy == sy)// right and left
		{
			if (fx < sx)// right
			{
				for (int i = fx + 1; i <= sx - 1; i++)
				{
					if (GUIPanel.b1[fy][i].getText() != "")
						return false;
				}
			} else
			{
				// left
				for (int u = fx - 1; u >= sx + 1; u = u - 1)
				{
					if (GUIPanel.b1[fy][u].getText() != "")
						return false;
				}
			}
		}

		else if (fx == sx)
		{ // up and down

			if (fy < sy)// up
			{
				for (int y = fy + 1; y <= sy - 1; y++)
				{
					if (y == sy)
						return true;
					if (GUIPanel.b1[y - 1][fx].getText() != "")
						return false;

				}
			} else// down
			{
				for (int t = fy - 1; t >= sy + 1; t--)
				{
					if (GUIPanel.b1[t][fx].getText() != "")
						return false;
				}
			}
		}

		else
		{
			return false;
		}

		return true;

	}

	public static void bmove(int fx, int fy, int sx, int sy)
	{

		GUIPanel.b1[sy][sx].setText("\u265C");
		GUIPanel.b1[sy][sx].setForeground(Color.BLACK);
		GUIPanel.b1[fy][fx].setText("");

	}

	public static void wmove(int fx, int fy, int sx, int sy)
	{
		GUIPanel.b1[sy][sx].setText("\u2656");
		GUIPanel.b1[sy][sx].setForeground(Color.WHITE);
		GUIPanel.b1[fy][fx].setText("");

	}

}
