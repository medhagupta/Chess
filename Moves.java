import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by test on 7/29/2015.
 */
public class Moves {



    public static boolean isvalidQueen(String start,String end,Map<String,String> ChessBoard)
    {


        return true;
    }


    public static boolean isvalidKing(String s1,String s2,Map<String,String> ChessBoard)
    {
        return true;
    }

    public static boolean isvalidKight(String start,String end,Map<String,String> ChessBoard)
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

    public static boolean isvalidBishop(String start,String end, Map<String,String> ChessBoard){

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

    public static boolean isvalidRook(String start,String end,Map<String,String> ChessBoard){

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
                if (ChessBoard.containsValue(Position)) {
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
        if ( ChessBoard.containsValue(Position))
        {
            return true;
        }
        return false;
    }

}
