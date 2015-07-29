import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
			
			this.chessBoard.put("Rb1","a8");
			this.chessBoard.put("Nb1","b8");
			this.chessBoard.put("Bb1","c8");
			this.chessBoard.put("Qb","d8");
			this.chessBoard.put("Kb","e8");
			this.chessBoard.put("Bb2","f8");
			this.chessBoard.put("Nb2","g8");
			this.chessBoard.put("Rb2","h8");
			this.chessBoard.put("Pb1","a7");
			this.chessBoard.put("Pb2","b7");
			this.chessBoard.put("Pb3","c7");
			this.chessBoard.put("Pb4","d7");
			this.chessBoard.put("Pb5","e7");
			this.chessBoard.put("Pb6","f7");
			this.chessBoard.put("Pb7","g7");
			this.chessBoard.put("Pb8","h7");
			
			
			
		}
		
		public void update(String whiteMove , String blackMove){
			updateColour(whiteMove,'w');
			updateColour(blackMove,'b');
		}
		
		private void kill(String finalPosition){
			
		}
		
		private void updateColour(String finalPosition,char colour){
			
			if(finalPosition.contains("x")){
				kill(finalPosition);
				return;
			}
			else{
				String initialPosition = findInitialPosition(finalPosition,colour);
				boolean isPawn = finalPosition.length()==2;
				boolean isKing = finalPosition.charAt(0)=='K';
				boolean isQueen = finalPosition.charAt(0)=='Q';
				String position;
				String piece;
				if(isPawn){
					for(int i=1;i<=8;i++){
						if(colour=='w'){
							piece = "P"+"w"+Integer.toString(i);
							position = chessBoard.get(piece);
							
						}
						else{
							piece = "P"+"b"+Integer.toString(i);
							position = chessBoard.get(piece);
						}
						if(position == initialPosition){
							chessBoard.put(piece,finalPosition);
							break;
						}
					}
				}
				else{
					for(int i=1;i<=2;i++){ 
						if(colour == 'w'){
							piece = Character.toString(finalPosition.charAt(0))+"w" + Integer.toString(i);
							position = chessBoard.get(piece);
						}
						else{
							piece = Character.toString(finalPosition.charAt(0))+"b" + Integer.toString(i);
							position = chessBoard.get(piece);
						}
						
						if(position!=null && position==initialPosition){
							chessBoard.put(piece,finalPosition.substring(1));
						}
					}
				
				
				}
			
			}
		}
		
		public  void print(){
			for(Entry<String,String> e : chessBoard.entrySet()){
				System.out.println(e.getKey() + "  "+e.getValue());
			}
		}
		
		private String findInitialPosition(String finalPosition,char Colour){
			String initialPosition;
			boolean isPawn = finalPosition.length()==2;
			boolean isQueen = finalPosition.charAt(0)=='Q';
			boolean isKing = finalPosition.charAt(0)=='K';
			boolean isBishop = finalPosition.charAt(0)=='B';
			boolean isKnight = finalPosition.charAt(0)=='N';
			boolean isRook = finalPosition.charAt(0)=='R';
			String piece;
			String position;
			if(isPawn){
				for(int i=1;i<9;i++){
					piece = "P"+Colour+Integer.toString(i);
					position = chessBoard.get(piece);
					if(Moves.isValidPawnMove(position,finalPosition.substring(1))){
						return position;
					}
				}	
			}
			
			else {
				for(int i =1; i<=2;i++){
					piece = Character.toString(finalPosition.charAt(0))+Character.toString(Colour) + Integer.toString(i);
					position = chessBoard.get(piece);
					if(isBishop && Moves.isValidBishopMove(position, finalPosition.substring(1))){
						return position;
					}
					if(isKnight && Moves.isValidKnightMove(position, finalPosition.substring(1))){
						return position;
					}
					if(isRook && Moves.isValidRookMove(position, finalPosition.substring(1))){
						return position;
					}
					
					if(isKing && Moves.isValidKingMove(position,finalPosition.substring(1))){
						return position;
					}
					
				}
				
				if(isQueen ){
					piece = Character.toString(finalPosition.charAt(0)) + Colour;
					position = chessBoard.get(piece);
					if(Moves.isValidQueenMove(position, finalPosition.substring(1))){
						return position;
					}
				}
				if(isKing){
					piece = Character.toString(finalPosition.charAt(0)) + Colour;
					position = chessBoard.get(piece);
					if(Moves.isValidQueenMove(position, finalPosition.substring(1))){
						return position;
					}
				}
			}
			
			return null;
		}
		
		
		
		/*private String findInitialPosition(String finalPosition,char Colour){
			return "b1";
		}*/
		public static void main(String args[]){
			ChessBoard chessBoard = new ChessBoard();
			chessBoard.update("Nc3","Nc6");
			chessBoard.print();
		}
}


