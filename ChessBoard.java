import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
		Map<String,String> chessBoard = new HashMap<String,String>();
		
		ChessBoard(){
			this.chessBoard.put("Rw1","a1");
			this.chessBoard.put("Nw1","b1");
			this.chessBoard.put("Bw1","c1");
			this.chessBoard.put("Qw","d1");
			this.chessBoard.put("Kw","e1");
			this.chessBoard.put("Bw2","f1");
			this.chessBoard.put("Nw2","g1");
			this.chessBoard.put("Rw2","h1");
			this.chessBoard.put("Pw1","a2");
			this.chessBoard.put("Pw2","b2");
			this.chessBoard.put("Pw3","c2");
			this.chessBoard.put("Pw4","d2");
			this.chessBoard.put("Pw5","e2");
			this.chessBoard.put("Pw6","f2");
			this.chessBoard.put("Pw7","g2");
			this.chessBoard.put("Pw8","h2");
			
			this.chessBoard.put("Rg1","a8");
			this.chessBoard.put("Ng1","b8");
			this.chessBoard.put("Bg1","c8");
			this.chessBoard.put("Qg","d8");
			this.chessBoard.put("Kg","e8");
			this.chessBoard.put("Bg2","f8");
			this.chessBoard.put("Ng2","g8");
			this.chessBoard.put("Rg2","h8");
			this.chessBoard.put("Pg1","a7");
			this.chessBoard.put("Pg2","b7");
			this.chessBoard.put("Pg3","c7");
			this.chessBoard.put("Pg4","d7");
			this.chessBoard.put("Pg5","e7");
			this.chessBoard.put("Pg6","f7");
			this.chessBoard.put("Pg7","g7");
			this.chessBoard.put("Pg8","h7");
			
			
			
		}
		
		public void update(String move){
			//takes in a move that contains initial and final position and updates the chess board
		}
		
		private String findInitialPosition(String finalMove){
			return null;
		}
	
	
}
