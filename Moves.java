import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by test on 7/29/2015.
 */
public class Moves {



    public static boolean isvalidQueenMove(String start,String end,Map<String,String> ChessBoard)
    {


        return true;
    }


    public static boolean isvalidKingMove(String s1,String s2,Map<String,String> ChessBoard)
    {
        return true;
    }

    public static boolean isvalidKightMove(String start,String end,Map<String,String> ChessBoard)
    {


        if(Math.abs(start.charAt(0) - end.charAt(0)) == 1 && Math.abs(start.charAt(1) - end.charAt(1)) == 2)
        {
            return true;
        }

        if(Math.abs(start.charAt(0) - end.charAt(0)) == 2 && Math.abs(start.charAt(1) - end.charAt(1)) == 1)
        {
            return true;
        }

        return true;
    }

    public static boolean isvalidBishopMove(String start,String end, Map<String,String> ChessBoard){

        // Camel

        if(Math.abs(start.charAt(0) - end.charAt(0)) == Math.abs(start.charAt(1) - end.charAt(1)))
        {
            return true;
        }

        return false;
    }

    public static ArrayList<String> findIntermediatePositions(String start,String end){

        ArrayList<String> Positions=new ArrayList<String>();

        if(start.charAt(0)>end.charAt(0))
        {
            String temp =start;
            start =end;
            end=temp;
        }

        while (start.charAt(0)<end.charAt(0)) {

            char P = (char) (start.charAt(0) + 1);
            start = P + "" + start.charAt(1);
            Positions.add(start);
        }

        return Positions;


    }

    public static boolean isvalidRookMove(String start,String end,Map<String,String> ChessBoard){

        // Elephant

        if (start.charAt(0)!=end.charAt(0) && start.charAt(1)!=end.charAt(1))
        {
            return false;
        }


        if (start.charAt(1)==end.charAt(1))
        {

            ArrayList<String> Intermediate_Positions = findIntermediatePositions(start,end);


           for (String position:Intermediate_Positions)
           {
               if(ispawnpresent(position,ChessBoard))
               {
                   return false;
               }
           }

        }

        else {
            int minimum = Math.min(Character.getNumericValue(start.charAt(1)), Character.getNumericValue(end.charAt(1)));
            int maximum = Math.min(Character.getNumericValue(start.charAt(1)), Character.getNumericValue(end.charAt(1)));

            String Position;
            for (int i = minimum + 1; i < maximum; i++) {
                Position = start.charAt(0) + Integer.toString(i);
                if (ispawnpresent(Position,ChessBoard)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isValidPawnMove(String start,String end,Map<String,String> ChessBoard){

        if ( Math.abs(start.charAt(0)-end.charAt(0)) > 1 )
        {
            return false;
        }

        if ( Math.abs(start.charAt(1)-end.charAt(1)) != 1 )
        {
            return false;
        }

        if(ispawnpresent(end,ChessBoard))
        {   // cross move
            if(Math.abs(start.charAt(0)-end.charAt(0)) == 1)
                return true;
            return false;
        }
        else
        {
            if (Math.abs(start.charAt(0) - end.charAt(0)) == 0)
                return true;
        }

            return false;
    }

    public static boolean ispawnpresent(String Position, Map<String,String> ChessBoard)
    {
        /*
        if ( ChessBoard.containsValue(Position))
        {
            return true;
        }
        return false;
        */
        return true;
    }

    public static void main(String args[]) {
        Map<String,String> chessBoard = new HashMap<String,String>();


            chessBoard.put("Rw1","a1");
            chessBoard.put("Nw1","b1");
            chessBoard.put("Bw1","c1");
            chessBoard.put("Qw","d1");
            chessBoard.put("Kw","e1");
            chessBoard.put("Bw2","f1");
            chessBoard.put("Nw2","g1");
            chessBoard.put("Rw2","h1");
            chessBoard.put("Pw1","a2");
            chessBoard.put("Pw2","b2");
            chessBoard.put("Pw3","c2");
            chessBoard.put("Pw4","d2");
            chessBoard.put("Pw5","e2");
            chessBoard.put("Pw6","f2");
            chessBoard.put("Pw7","g2");
            chessBoard.put("Pw8","h2");

            chessBoard.put("Rb1","a8");
            chessBoard.put("Nb1","b8");
            chessBoard.put("Bb1","c8");
            chessBoard.put("Qb","d8");
            chessBoard.put("Kb","e8");
            chessBoard.put("Bb2","f8");
            chessBoard.put("Nb2","g8");
            chessBoard.put("Rb2","h8");
            chessBoard.put("Pb1","a7");
            chessBoard.put("Pb2","b7");
            chessBoard.put("Pb3","c7");
            chessBoard.put("Pb4","d7");
            chessBoard.put("Pb5","e7");
            chessBoard.put("Pb6","f7");
            chessBoard.put("Pb7","g7");
            chessBoard.put("Pb8","h7");

        System.out.print(isValidPawnMove("b2","b3",chessBoard));


}

}
