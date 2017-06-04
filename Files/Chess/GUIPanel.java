
//John Link Cole Blackman 5/10/17
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUIPanel extends JPanel implements ActionListener
{
	boolean notitle = false;
	JLabel label;
	public static JButton[][] b1 = new JButton[10][10];// instantiates a nested
														// array of JButtons
	public static boolean isWhiteTurn = true; // global boolean to allow turn
												// restriction
	public static char[] AllWhitePieces = new char[]
	{ '\u2654', '\u2655', '\u2656', '\u2657', '\u2658', '\u2659' };// definite arrays of chars including every unicode value for both black and white chess pieces
	public static char[] AllBlackPieces = new char[]
	{ '\u265A', '\u265B', '\u265C', '\u265D', '\u265E', '\u265F' };
	Color brown = new Color(181, 136, 99); // creates two new colors chosen by
											// us for the ui
	Color beige = new Color(240, 217, 181);
	public boolean hasBeenClicked = false;// instantiates a boolean to determine
											// if the user has already clicked a
											// button

	public int fposx, fposy, sposx, sposy;// declares integers including two x,y
											// coordinates

	public GUIPanel()
	{

		setLayout(new GridLayout(10, 10));// creates the mainly used Layout as a
											// Gridlayout of size 10 by 10
		int numberInt = 8;// an integer that is the maximum boundary for use in
							// the if statements
		char[] letterChar = new char[]
		{ ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' }; // a definite array of all the letters used for the border of the button array, including one blank
															// spot for the exit button
		for (int o = 1; o < 10; o++) // nested for loops to populate the array
										// with x and y values 1,1 to 8,8
		{
			for (int p = 1; p < 10; p++)
			{
				b1[o][p] = new JButton(); // populate with Jbuttons
				b1[o][p].setBorderPainted(true);// settings for each Jbutton
				b1[o][p].setFocusPainted(false);
				GUIPanel.b1[o][p].addActionListener(this);
				add(b1[o][p]);
				if ((p + o) % 2 == 0)// Color the alternating chessboard pattern
				{
					b1[o][p].setBackground(brown);

				} else
				{
					b1[o][p].setBackground(beige);
				}

				if (o < 9 && p == 1)// populate the edges with labels
				{
					b1[o][1].setText("" + numberInt);
					if (numberInt > 1)
						numberInt--;
					b1[o][1].setBackground(Color.LIGHT_GRAY);

				}
				if (o == 9 && p > 1)
				{
					b1[9][p].setText("" + letterChar[p - 1]);
					b1[9][p].setBackground(Color.LIGHT_GRAY);
				}

			}

		}

		SetChessBoard();// calls the method SetChessBoard in order to populate the board with the starting positions
		b1[9][1].addActionListener(new Listener());// sets up the exit button in the bottom left corner
		b1[9][1].setText("EXIT");
		b1[9][1].setBackground(beige);
	}

	public void SetChessBoard()
	{
		for (int o = 1; o < 10; o++) // these for loops iterate through every square of the board
		{
			for (int p = 1; p < 10; p++)
			{
				if (p > 1 && o != 9) // adds all starting positions of pieces for a normal board
					b1[o][p].setFont(new Font("Noto", Font.PLAIN, 70));
				// BLACK
				// Pawn
				if (o == 2 && p != 1)
				{
					b1[o][p].setText("\u265F");
				}
				// WHITE
				// PAWN
				if (o == 7 && p != 1)
				{
					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2659");
				}
				// rook
				// Black
				if ((o == 1 && p == 2) || (o == 1 && p == 9))
				{

					b1[o][p].setText("\u265C");

				}
				// rook
				// White
				if ((o == 8 && p == 2) || (o == 8 && p == 9))
				{

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2656");

				}
				// Knight
				// Black
				if ((o == 1 && p == 3) || (o == 1 && p == 8))
				{

					b1[o][p].setText("\u265E");

				}
				// Knight
				// White
				if ((o == 8 && p == 3) || (o == 8 && p == 8))
				{

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2658");

				}
				// Bishop
				// Black
				if ((o == 1 && p == 4) || (o == 1 && p == 7))
				{

					b1[o][p].setText("\u265D");

				}
				// Bishop
				// White
				if ((o == 8 && p == 4) || (o == 8 && p == 7))
				{

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2657");

				}
				// King
				// White
				if (o == 8 && p == 6)
				{

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2654");

				}
				// Queen
				// Black
				if (o == 1 && p == 5)
				{

					b1[o][p].setText("\u265B");
				}
				// Queen
				// White
				if (o == 8 && p == 5)
				{

					b1[o][p].setForeground(Color.WHITE);
					b1[o][p].setText("\u2655");

				}
				// King
				// Black
				if (o == 1 && p == 6)
				{

					b1[o][p].setText("\u265A");
				}
			}
		}
	}

	private class Listener implements ActionListener // Listener for exit
	{
		public void actionPerformed(ActionEvent e)
		{

			System.exit(0);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		// black pawn
		if (hasBeenClicked)
		{

			// Border emptyBorder = BorderFactory.createEmptyBorder();

			b1[fposy][fposx].setBorder(javax.swing.BorderFactory.createEmptyBorder());
			sposx = (((JButton) e.getSource()).getLocationOnScreen().x) / 142 + 1;
			sposy = (((JButton) e.getSource()).getLocationOnScreen().y) / 102 + 1;

			if (Pawn.isValidMoveBlack(fposx, fposy, sposx, sposy))
			{
				Pawn.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (Pawn.isValidMoveWhite(fposx, fposy, sposx, sposy))
			{
				Pawn.wmove(fposx, fposy, sposx, sposy);

				hasBeenClicked = false;
			}

			else if (Rook.isValidMoveBlack(fposx, fposy, sposx, sposy))
			{

				Rook.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (Rook.isValidMoveWhite(fposx, fposy, sposx, sposy))
			{

				Rook.wmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = false;
				hasBeenClicked = false;

			} else if (Knight.isValidMoveBlack(fposx, fposy, sposx, sposy))
			{
				Knight.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (Knight.isValidMoveWhite(fposx, fposy, sposx, sposy))
			{

				Knight.wmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = false;
				hasBeenClicked = false;
			} else if (King.isValidMoveBlack(fposx, fposy, sposx, sposy))
			{
				King.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (King.isValidMoveWhite(fposx, fposy, sposx, sposy))
			{

				King.wmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = false;
				hasBeenClicked = false;

			} else if (Bishop.isValidMoveBlack(fposx, fposy, sposx, sposy))
			{
				Bishop.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (Bishop.isValidMoveWhite(fposx, fposy, sposx, sposy))
			{

				Bishop.wmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = false;
				hasBeenClicked = false;

			} else if (Queen.isValidMoveBlack(fposx, fposy, sposx, sposy))
			{
				Queen.bmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = true;
				hasBeenClicked = false;
			} else if (Queen.isValidMoveWhite(fposx, fposy, sposx, sposy))
			{

				Queen.wmove(fposx, fposy, sposx, sposy);
				isWhiteTurn = false;
				hasBeenClicked = false;
			} else
			{
				hasBeenClicked = false;
			}

		} else
		{
			
			fposx = (((JButton) e.getSource()).getLocationOnScreen().x) / 142 + 1;
			fposy = (((JButton) e.getSource()).getLocationOnScreen().y) / 102 + 1;
			sposx = 0;
			sposy = 0;
			if (((JButton) e.getSource()).getText() != "")
			{
				hasBeenClicked = true;
				b1[fposy][fposx].setBorder(BorderFactory.createLineBorder(Color.cyan, 4));
			}

		}

	}

}
