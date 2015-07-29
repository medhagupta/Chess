package chess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Chess {
    public static void main(String[] args) throws java.lang.Exception {
        try (Scanner reader = new Scanner(System.in)) {
            System.out.println("Enter the file name (e.g. abc.txt)");
            String file = reader.nextLine();
            BufferedReader br = new BufferedReader(new FileReader(".\\src\\chess\\" + file));
            String line = br.readLine();
            System.out.println(line);
            String[] moves = line.replaceAll("\\.", " ").split("\\s+");
            for (int i=0; i<moves.length ;i++){
                if (i%3 != 0 && moves[i].matches(".*[a-zA-Z]+.*")) {
                    System.out.print("  " + moves[i]);
                }
            }            
        }
        
    }
}
