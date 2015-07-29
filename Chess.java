package chess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Chess {
    public static void main(String[] args) throws java.lang.Exception {
        try (Scanner reader = new Scanner(System.in)) {
            System.out.println("Enter the file name (e.g. abc.txt)");
            //String file = reader.nextLine();
            ChessBoard chessBoard = new ChessBoard();
            String file = "chessmoves.txt";
            BufferedReader br = new BufferedReader(new FileReader(".\\src\\chess\\" + file));
            String line = br.readLine();
            System.out.println(line);
            String[] moves = line.replaceAll(" *\\d*[.] *" ," ").split(" ");
            System.out.println(Arrays.toString(moves));
            for (int i=1; i<moves.length ;i+= 2){
                if ( moves[i].matches(".*[a-zA-Z]+.*")) {
                    chessBoard.update(moves[i], moves[i+1]);
                }
            }
        }
        
    }
}
