# ALM-Game-Launcher

ALM includes 3 games: 
<ul> <li> Chess </li>
<li> PacMan </li>
<li> PacGHOST </li>

Feature list
  <p style='color:red'>
  Chess Board
  Pawn 
  Bishop
  Queen
  King
  Rook
  Knight
  


FIlES
  - Piece
  - Knight
  - Rook
  - Bishop
  - Queen
  - Pawn
  - King
  - Driver
  - GUIPanel a layout with a grid of buttons and listeners each. custom color and size. On mouseover, changes color. The buttons(pieces) have ♔♕♖ icons from unicode to identify them. 64 buttons, some have a label, some don't. The text size of that will be large. Background image will be a chess board that the buttons lay on top of.
  
  Nested array x, y positions
  Each instantiation of a piece has a x and y integer, a boolean for black and white, a boolean isAlive, and has methods.
  The individual pieces override and extend the piece class.
  
Each button has a listener. 
  Upon click,
    1. Determine if that is a valid piece for the person who's turn it is.
    2. If yes, listen for next button press. 
    3. Now, determine if that is a valid move:
        algorithm varies based on piece and if the selected moving slot has a piece already. If it does have a piece of the same color, invalid. If it has a piece of the other color, continue to individual piece algorithms. MUST take into account that a bishop cannot travel through another piece on its way. Therefore, must map out the path the piece will travel(except knight). Must know inital starting position for weird rules like pawn movement and castle king/queen side.
 
 win conditions- test every possible move for the king and for the other pieces. Must be done from beginning of game. Every turn, check if king is in danger.
</p>
