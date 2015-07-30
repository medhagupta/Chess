import java.util.HashMap;
import java.util.Iterator;
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
		
		private void kill(String finalPosition,char colour){
			boolean isPawn = Character.isLowerCase(finalPosition.charAt(0));
			if(isPawn){
				String pieceToKill = findPieceAtPosition(finalPosition.substring(2,4));
				chessBoard.put(pieceToKill, "deleted");
				if(colour=='w'){
					String position = finalPosition.substring(0, 1)+Integer.toString(Integer.parseInt(finalPosition.substring(3, 4))-1);
					String pieceToMove = findPieceAtPosition(position);
					chessBoard.put(pieceToMove, finalPosition.substring(2, 4));
					
				}
				else{
					String position = finalPosition.substring(0, 1)+Integer.toString(Integer.parseInt(finalPosition.substring(3, 4))+1);
					String pieceToMove = findPieceAtPosition(position);
					chessBoard.put(pieceToMove, finalPosition.substring(2, 4));
				}
			}
			else{
				String pieceToKill = findPieceAtPosition(finalPosition.substring(2,4));
				chessBoard.put(pieceToKill, "deleted");
				String initialPosition = findInitialPosition(finalPosition,colour);
				System.out.println("999999999999999999 "+initialPosition);
				String pieceToBeMoved = findPieceAtPosition(initialPosition);
				chessBoard.put(pieceToBeMoved, finalPosition.substring(2, 4));
			}
			
		}
		
		
		
		private String resolveConflicts(String finalPosition , char colour){
				System.out.println("$$$$$$$$$"+ " "+finalPosition);
				for(int i=1;i<=2;i++){
					String key = finalPosition.substring(0,1)+colour+Integer.toString(i);
					String rowOrColumn = finalPosition.substring(1, 2);
					String position = chessBoard.get(key);
					if(position.contains(rowOrColumn)){
						return position;
					}
					
				}
			
				return null;
		}
		
		private void kingSideCasling(char colour){
				String keyKing = "K"+colour;
				String keyRook = "R"+colour+"2";
				if(colour == 'w'){
					chessBoard.put(keyKing,"g1");	
					chessBoard.put(keyRook, "f1");
				}
				else{
					chessBoard.put(keyKing,"g8");	
					chessBoard.put(keyRook, "f8");
				}
		}
		
		private void queenSideCasling(char colour){
			String keyKing = "K"+colour;
			String keyRook = "R"+colour+"2";
			if(colour == 'w'){
				chessBoard.put(keyKing,"c1");	
				chessBoard.put(keyRook, "d1");
			}
			else{
				chessBoard.put(keyKing,"c8");	
				chessBoard.put(keyRook, "d8");
			}
	}
		
		private String findPieceAtPosition(String position){
			String x="";
			for( Entry<String, String> e : chessBoard.entrySet()){
				if(e.getValue().equals(position)){
					x=e.getKey();
					return x;
					
				}
			}
			return x;
		}
		
		private void updateColour(String finalPosition,char colour){
			
			if(finalPosition.contains("x")){
				kill(finalPosition,colour);
				return;
			}
			
			if(finalPosition.equals("O-O")){
				kingSideCasling(colour);
				return;
			}
			
			if(finalPosition.equals("O-O-O")){
				queenSideCasling(colour);
				return;
			}
		
			
			else{
				String initialPosition="";
				if(finalPosition.length()>3){
					 initialPosition = resolveConflicts(finalPosition,colour);
					// System.out.println("initialPosition");
				}
				else{
					initialPosition = findInitialPosition(finalPosition,colour);
				}
				boolean isPawn = finalPosition.length()==2;
				String position="";
				String piece="";
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
					
					if(finalPosition.contains("Q")||finalPosition.contains("K")){
						piece = Character.toString(finalPosition.charAt(0))+colour;
						position = chessBoard.get(piece);
						
					
					
						chessBoard.put(piece,finalPosition.substring(finalPosition.length()-2));
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
							chessBoard.put(piece,finalPosition.substring(finalPosition.length()-2));
						}
					}
				}
				
				}
			
				}
				
		}
		
		
		public  void print(){
			String[][] board = new String[8][8];
			
			
			
			for(Entry<String,String> e : chessBoard.entrySet()){
				int index[] = new int[2];
				if(!e.getValue().contains("deleted")){
					index = valueToIndex(e.getValue());
					board[index[0]][index[1]] = e.getKey();
				}
				
			}
			
			for(int j=7;j>=0;j--){
				for(int i=0;i<8;i++){
					if(board[i][j]!=null)
						System.out.print(board[i][j]+"  ");
					else
						System.out.print("___  ");
				}
				System.out.println("");
			}
			
		}
		
		private int[] valueToIndex(String value){
			int index[] = new int[2];
			index[0] = value.charAt(0)-'a';
			index[1] = value.charAt(1)-'1';
			return index;
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
					if(Moves.isValidPawnMove(position,finalPosition,chessBoard)){
						return position;
					}
				}	
			}
			
			else {
				int end = finalPosition.length();
				if(isQueen ){
					piece = Character.toString(finalPosition.charAt(0)) + Colour;
					position = chessBoard.get(piece);
					if(Moves.isValidQueenMove(position, finalPosition.substring(end-2,end),chessBoard)){
						return position;
					}
				}
				if(isKing){
					piece = Character.toString(finalPosition.charAt(0)) + Colour;
					position = chessBoard.get(piece);
					if(Moves.isValidKingMove(position, finalPosition.substring(end-2,end),chessBoard)){
						return position;
					}
				}
				for(int i =1; i<=2;i++){
					piece = Character.toString(finalPosition.charAt(0))+Character.toString(Colour) + Integer.toString(i);
					position = chessBoard.get(piece);
					if(isBishop && Moves.isValidBishopMove(position, finalPosition.substring(end-2,end),chessBoard)){
						return position;
					}
					if(isKnight && Moves.isValidKnightMove(position, finalPosition.substring(end-2,end),chessBoard)){
						return position;
					}
					if(isRook && Moves.isValidRookMove(position, finalPosition.substring(end-2,end),chessBoard)){
						return position;
					}
					
					if(isKing && Moves.isValidKingMove(position,finalPosition.substring(end-2,end),chessBoard)){
						return position;
					}
					
				}
				
				
			}
			
			return null;
		}
		
		
		
		
		
		
}


