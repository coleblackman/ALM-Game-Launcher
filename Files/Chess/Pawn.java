
//John Link Cole Blackman 5/10/17
import java.awt.Color;

public class Pawn extends Piece {
	public static boolean isValidMoveBlack(int fx, int fy, int sx, int sy) {
		System.out.println("fx" + fx + "fy" + fy + "sx" + sx + "sy" + sy);
		for (int i = 0; i < 6; i++) { // for loop to iterate through all
										// possible white pieces and makes sure
										// that the second position is not a
				
			// white piece.
			if (GUIPanel.b1[sy][sx].getText().equals(Character.toString(GUIPanel.AllBlackPieces[i])))
			{
				
				return false;
			}
		}
		System.out.println("fx" + fx + "fy" + fy);
		if (GUIPanel.b1[fy][fx].getText() != "\u265F") {
			System.out.println("false");
			return false;
		}
		if (sy <= fy) // Pawns can only move forwards
		{
			
			return false;
		}
		

		if ((fy + 1 == sy) || (sy == 4)) {
			if (((sx == fx) && (GUIPanel.b1[sy][sx].getText() == ""))
					|| (((fx + 1 == sx) || fx - 1 == sx) && (fy + 1 == sy) && (GUIPanel.b1[sy][sx].getText() != "")))

				return true;
			else
				return false;
		} else
			return false;

	}

	public static boolean isValidMoveWhite(int fx, int fy, int sx, int sy) {
		for (int i = 0; i < 6; i++) { // for loop to iterate through all
										// possible white pieces and makes sure
										// that the second position is not a
										// white piece.
			if (GUIPanel.b1[sy][sx].getText().equals(Character.toString(GUIPanel.AllWhitePieces[i])))
				return false;
		}
		if (GUIPanel.b1[fy][fx].getText() != "\u2659") {
			return false;
		}
		if (sy >= fy) // Pawns can only move forwards
			return false;

		if ((fy - 1 == sy) || (sy == 5))

		{
			if (((sx == fx) && (GUIPanel.b1[sy][sx].getText() == ""))
					|| (((fx + 1 == sx) || fx - 1 == sx) && (fy - 1 == sy) && (GUIPanel.b1[sy][sx].getText() != "")))

				return true;
			else
				return false;
		} else
			return false;

	}

	public static void bmove(int fx, int fy, int sx, int sy) {

	//	GUIPanel.b1[sy][sx].setText("\u265F");
	//	GUIPanel.b1[fy][fx].setText("");
		if (sy == 8) {
			GUIPanel.b1[sy][sx].setText("\u265B");
			GUIPanel.b1[sy][sx].setForeground(Color.BLACK);
			GUIPanel.b1[fy][fx].setText("");

		} else {

			GUIPanel.b1[sy][sx].setText("\u265F");
			GUIPanel.b1[sy][sx].setForeground(Color.BLACK);
			GUIPanel.b1[fy][fx].setText("");
		}

	}

	public static void wmove(int fx, int fy, int sx, int sy) {
System.out.println("wmove");
		if (sy == 1) {
			GUIPanel.b1[sy][sx].setText("\u2655");
			GUIPanel.b1[sy][sx].setForeground(Color.WHITE);
			GUIPanel.b1[fy][fx].setText("");

		} else {

			GUIPanel.b1[sy][sx].setText("\u2659");
			GUIPanel.b1[sy][sx].setForeground(Color.WHITE);
			GUIPanel.b1[fy][fx].setText("");

		}

	}
}
