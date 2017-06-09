import java.awt.Color;

//John Link Cole Blackman 5/10/17
public class Queen
{
	public static boolean isValidMoveBlack(int fx, int fy, int sx, int sy)
	{
		if(sx <= 1 || sy >= 9)
			return false;
		if (GUIPanel.b1[fy][fx].getText() != "\u265B")
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
		if (QueenRBlack(fx, fy, sx, sy) || QueenBBlack(fx, fy, sx, sy))
		{
			return true;
		}
		return false;
	}

	public static boolean isValidMoveWhite(int fx, int fy, int sx, int sy)
	{
		if(sx <= 1 || sy >= 9)
			return false;
		if (GUIPanel.b1[fy][fx].getText() != "\u2655")
		{

			return false;
		}
		for (int i = 0; i < 6; i++)
		{ // for loop to iterate through all
			// possible white pieces and makes sure
			// that the second position is not a
			// white piece.
			System.out.println(GUIPanel.b1[sy][sx].getText() + " " + Character.toString(GUIPanel.AllWhitePieces[i]));
			if (GUIPanel.b1[sy][sx].getText().equals(Character.toString(GUIPanel.AllWhitePieces[i])))
				return false;
		}
		if (QueenRWhite(fx, fy, sx, sy) || QueenBWhite(fx, fy, sx, sy))
			return true;

		return false;
	}

	public static boolean QueenRWhite(int fx, int fy, int sx, int sy)
	{

		if (fx == sx && fy == sy)
			return false;
		if (fy == sy)// right and left
		{
			if (fx < sx)// right
			{
				for (int i = fx + 1; i <= sx; i++)
				{
					if (GUIPanel.b1[fy][i].getText() != "")
						return false;
				}
			} else
			{
				// left
				for (int u = fx - 1; u >= sx; u = u - 1)
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
				for (int y = fy + 1; y <= sy; y++)
				{
					if (y == sy)
						return true;
					if (GUIPanel.b1[y - 1][fx].getText() != "")
						return false;

				}
			} else// down
			{
				for (int t = fy - 1; t >= sy + 2; t--)
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

	public static boolean QueenRBlack(int fx, int fy, int sx, int sy)
	{
		if (fy == sy)// right and left
		{
			if (fx < sx)// right
			{
				for (int i = fx + 1; i <= sx + 1; i++)
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

	public static boolean QueenBWhite(int fx, int fy, int sx, int sy)
	{
		if (Math.abs(sy - fy) != Math.abs(sx - fx))
			return false;

		return true;
	}

	public static boolean QueenBBlack(int fx, int fy, int sx, int sy)
	{
		if (Math.abs(sy - fy) != Math.abs(sx - fx))
			return false;
		return true;
	}

	public static void bmove(int fx, int fy, int sx, int sy)
	{

		GUIPanel.b1[sy][sx].setText("\u265B");
		GUIPanel.b1[sy][sx].setForeground(Color.BLACK);
		GUIPanel.b1[fy][fx].setText("");

	}

	public static void wmove(int fx, int fy, int sx, int sy)
	{
		System.out.println("wmove");
		GUIPanel.b1[sy][sx].setText("\u2655");
		GUIPanel.b1[sy][sx].setForeground(Color.WHITE);
		GUIPanel.b1[fy][fx].setText("");

	}

}