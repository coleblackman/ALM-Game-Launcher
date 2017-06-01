
//John Link Cole Blackman 5/10/17
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GUIPanel extends JPanel implements ActionListener {

	ImageIcon chess = new ImageIcon("chessboard.png");

	public static JButton[][] b1 = new JButton[10][10];
	public static boolean isWhiteTurn = true;
	public static boolean WhiteKingHasMoved = false;
	public static boolean BlackKingHasMoved = false;
	public static char[] AllWhitePieces = new char[] { '\u2654', '\u2655', '\u2656', '\u2657', '\u2658', '\u2659' };
	public static char[] AllBlackPieces = new char[] { '\u265A', '\u265B', '\u265C', '\u265D', '\u265E', '\u265F' };
	Color brown = new Color(181, 136, 99);
	Color beige = new Color(240, 217, 181);
	public boolean hasBeenClicked = false;

	public int fposx, fposy, sposx, sposy;

	public GUIPanel() {

		setLayout(new GridLayout(10, 10));

		int numberInt = 8;
		char[] letterChar = new char[] { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		for (int o = 1; o < 10; o++) // nested for loops to populate the array
										// with x and y values 1,1 to 8,8
		{

			for (int p = 1; p < 10; p++) {

				b1[o][p] = new JButton();
				b1[o][p].setBorderPainted(true);
				b1[o][p].setFocusPainted(false);

				GUIPanel.b1[o][p].addActionListener(this);
				add(b1[o][p]);
				if ((p + o) % 2 == 0) {
					b1[o][p].setBackground(beige);

				} else {
					b1[o][p].setBackground(brown);
				}

				if (o < 9 && p == 1) {
					b1[o][1].setText("" + numberInt);
					if (numberInt > 1)
						numberInt--;
					b1[o][1].setBackground(Color.LIGHT_GRAY);

				}
				if (o == 9 && p > 1) {
					b1[9][p].setText("" + letterChar[p - 1]);
					b1[9][p].setBackground(Color.LIGHT_GRAY);
				}

			}

		}

		SetChessBoard();

		b1[9][1].addActionListener(new Listener());
		b1[9][1].setText("EXIT");
		b1[9][1].setBackground(beige);
	}

	public void SetChessBoard() {
		for (int o = 1; o < 10; o++) // these for loops iterate through every
										// square
		{
			for (int p = 1; p < 10; p++) {
				if (p > 1 && o != 9)
					b1[o][p].setFont(new Font("Noto", Font.PLAIN, 70));
				// BLACK
				// Pawn
				if (o == 2 && p != 1) {
					b1[o][p].setText("\u265F");
				}
				// WHITE
				// PAWN
				if (o == 7 && p != 1) {
					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2659");
				}
				// rook
				// Black
				if ((o == 1 && p == 2) || (o == 1 && p == 9)) {

					b1[o][p].setText("\u265C");

				}
				// rook
				// White
				if ((o == 8 && p == 2) || (o == 8 && p == 9)) {

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2656");

				}
				// Knight
				// Black
				if ((o == 1 && p == 3) || (o == 1 && p == 8)) {

					b1[o][p].setText("\u265E");

				}
				// Knight
				// White
				if ((o == 8 && p == 3) || (o == 8 && p == 8)) {

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2658");

				}
				// Bishop
				// Black
				if ((o == 1 && p == 4) || (o == 1 && p == 7)) {

					b1[o][p].setText("\u265D");

				}
				// Bishop
				// White
				if ((o == 8 && p == 4) || (o == 8 && p == 7)) {

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2657");

				}
				// King
				// White
				if (o == 8 && p == 6) {

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2654");

				}
				// Queen
				// Black
				if (o == 1 && p == 5) {

					b1[o][p].setText("\u265B");
				}
				// Queen
				// White
				if (o == 8 && p == 5) {

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2655");

				}
				// King
				// Black
				if (o == 1 && p == 6) {

					b1[o][p].setText("\u265A");
				}
			}
		}
	}

	private class Listener implements ActionListener // listener 1
	{
		public void actionPerformed(ActionEvent e) {

			System.exit(0);
		}
	}

	public void actionPerformed(ActionEvent e) {
		// black pawn
		if (hasBeenClicked) {

			sposx = (((JButton) e.getSource()).getLocationOnScreen().x) / 142 + 1;
			sposy = (((JButton) e.getSource()).getLocationOnScreen().y) / 102 + 1;

			if (Pawn.isValidMoveBlack(fposx, fposy, sposx, sposy)) {

				Pawn.bmove(fposx, fposy, sposx, sposy);
				// isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (Pawn.isValidMoveWhite(fposx, fposy, sposx, sposy)) {
				System.out.println("wmove");
				Pawn.wmove(fposx, fposy, sposx, sposy);
				
				hasBeenClicked = false;
			}

			else if (Rook.isValidMoveBlack(fposx, fposy, sposx, sposy)) {

				Rook.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (Rook.isValidMoveWhite(fposx, fposy, sposx, sposy)) {

				Rook.wmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = false;
				hasBeenClicked = false;
				System.out.println("TRUE");
			} else if (Knight.isValidMoveBlack(fposx, fposy, sposx, sposy)) {
				Knight.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (Knight.isValidMoveWhite(fposx, fposy, sposx, sposy)) {

				Knight.wmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = false;
				hasBeenClicked = false;
				System.out.println("TRUE");
			} else if (King.isValidMoveBlack(fposx, fposy, sposx, sposy)) {
				King.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (King.isValidMoveWhite(fposx, fposy, sposx, sposy)) {

				King.wmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = false;
				hasBeenClicked = false;
				System.out.println("TRUE");
			}

			else {
				hasBeenClicked = false;
			}

		} else {

			fposx = (((JButton) e.getSource()).getLocationOnScreen().x) / 142 + 1;
			fposy = (((JButton) e.getSource()).getLocationOnScreen().y) / 102 + 1;
			System.out.println("" + fposx + fposy);
			sposx = 0;
			sposy = 0;
			if (((JButton) e.getSource()).getText() != "") {
				hasBeenClicked = true;

			}

		}

	}

}
