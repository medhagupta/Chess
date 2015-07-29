# Chess
In a game of chess with given the moves from begining of the game in PGN format, Assuming the standard first move is of White's side we have to find the final position of all the chess pieces.

Design :
ChessBoard :
Contains the current state of the chess board and an update function which updates the chess board according to the move in the pgn file
Moves :
Validates a move for each chess piece
Chess:
Wrapper class which parses the pgn file and calles update function of ChessBoard

Medha : Responsible for ChessBoard.java
Naresh : Responsible for Moves.java
Rajat : Responsible for Chess.java


