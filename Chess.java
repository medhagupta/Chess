package chess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Chess {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the file name (e.g. abc.txt)");
        String file = reader.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        System.out.println(line);
    }
}
