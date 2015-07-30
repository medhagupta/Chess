import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by test on 7/29/2015.
 */
public class MovesTest extends TestCase {

    Map<String,String> chessBoard;
    public void setUp() throws Exception {
        super.setUp();
        chessBoard = new HashMap<String,String>();

        chessBoard.put("Rw1", "a1");
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

    }

    public void testIsValidQueenMove() throws Exception {

    }

    public void testIsValidKingMove() throws Exception {

    }

    public void testIsValidKnightMove() throws Exception {
        assertEquals(Moves.isValidKnightMove("b8", "c5", chessBoard),false);
        assertEquals(Moves.isValidKnightMove("b8", "d7", chessBoard),true);
        assertEquals(Moves.isValidKnightMove("b8", "c6", chessBoard),true);
    }

    public void testIsValidBishopMove() throws Exception {
        assertEquals(Moves.isValidBishopMove("b1", "f6", chessBoard),false);
        assertEquals(Moves.isValidBishopMove("c8", "h3", chessBoard),true);
    }

    public void testIsValidRookMove() throws Exception {
        assertEquals(Moves.isValidRookMove("a1", "a5", chessBoard),false);
        assertEquals(Moves.isValidRookMove("b5", "g5", chessBoard),true);
    }

    public void testIsValidPawnMove() throws Exception {

        assertEquals(Moves.isValidPawnMove("e2", "e4", chessBoard),true);
        assertEquals(Moves.isValidPawnMove("b5", "g5", chessBoard),false);
    }

    public void testMain() throws Exception {

    }
}