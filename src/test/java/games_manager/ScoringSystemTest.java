package games_manager;

import entities.Cell;
import entities.Game;
import entities.GameBoard;
import entities.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class ScoringSystemTest {

    // following tests are for word scores
    @Test
    public void noMultipliers (){
        Game game = new Game();
        // creating letter cells
        Cell c0 = new Cell("C", 3, 1);
        Cell c1 = new Cell("A", 1, 1);
        Cell c2 = new Cell("R", 1, 1);

        // initializing board state and adding letters
        GameBoard board = game.getGameBoard();
        BoardManager.SetBoardCell(0, 4, c0, board);
        BoardManager.SetBoardCell(0, 5, c1, board);
        BoardManager.SetBoardCell(0, 6, c2, board);

        ArrayList<List<Integer>> pos = new ArrayList<>(); // creating 2d position arraylist of new word

        ArrayList<Integer> pos1 = new ArrayList<>(); // adding individual coordinates of word to arraylist
        pos1.add(0);
        pos1.add(4);
        ArrayList<Integer> pos2 = new ArrayList<>();
        pos2.add(0);
        pos2.add(5);
        ArrayList<Integer> pos3 = new ArrayList<>();
        pos3.add(0);
        pos3.add(6);

        pos.add(pos1); // combining the coordinates arraylists into the pos arraylist
        pos.add(pos2);
        pos.add(pos3);
        ScoringSystem scorer = new ScoringSystem();
        Assertions.assertEquals(5, scorer.calculateWordScore(game, pos));
    }

    @Test
    public void withMultipliers (){
        Game game = new Game();
        // creating letter cells
        Cell c0 = new Cell("V", 4, 3);
        Cell c1 = new Cell("A", 1, 1);
        Cell c2 = new Cell("L", 1, 1);
        Cell c3 = new Cell("U", 1, 1);
        Cell c4 = new Cell("E", 1, 2);

        // initializing board state and adding letters
        GameBoard board = game.getGameBoard();
        BoardManager.SetBoardCell(0, 0, c0, board);
        BoardManager.SetBoardCell(0, 1, c1, board);
        BoardManager.SetBoardCell(0, 2, c2, board);
        BoardManager.SetBoardCell(0, 3, c3, board);
        BoardManager.SetBoardCell(0, 4, c4, board);


        ScoringSystem scorer = new ScoringSystem();
        ArrayList<List<Integer>> pos = new ArrayList<>(); // creating 2d position arraylist of new word

        ArrayList<Integer> pos1 = new ArrayList<>(); // adding individual coordinates of word to arraylist
        pos1.add(0);
        pos1.add(0);
        ArrayList<Integer> pos2 = new ArrayList<>();
        pos2.add(0);
        pos2.add(1);
        ArrayList<Integer> pos3 = new ArrayList<>();
        pos3.add(0);
        pos3.add(2);
        ArrayList<Integer> pos4 = new ArrayList<>();
        pos4.add(0);
        pos4.add(3);
        ArrayList<Integer> pos5 = new ArrayList<>();
        pos5.add(0);
        pos5.add(4);

        pos.add(pos1); // combining the coordinates arraylists into the pos arraylist
        pos.add(pos2);
        pos.add(pos3);
        pos.add(pos4);
        pos.add(pos5);
        Assertions.assertEquals(17, scorer.calculateWordScore(game, pos));
    }

    @Test
    public void checkBingo(){
        Game game = new Game();
        Cell c0 = new Cell("Z", 10, 1);
        Cell c1 = new Cell("O", 1, 1);
        Cell c2 = new Cell("M", 3, 1);
        Cell c3 = new Cell("B", 3, 1);
        Cell c4 = new Cell("I", 1, 1);
        Cell c5 = new Cell("F", 4, 1);
        Cell c6 = new Cell("Y", 4, 1);

        // initializing board state and adding letters
        GameBoard board = game.getGameBoard();

        BoardManager.SetBoardCell(0, 0, c0, board);
        BoardManager.SetBoardCell(0, 1, c1, board);
        BoardManager.SetBoardCell(0, 2, c2, board);
        BoardManager.SetBoardCell(0, 3, c3, board);
        BoardManager.SetBoardCell(0, 4, c4, board);
        BoardManager.SetBoardCell(0, 5, c5, board);
        BoardManager.SetBoardCell(0, 6, c6, board);

        ScoringSystem scorer = new ScoringSystem();
        ArrayList<List<Integer>> pos = new ArrayList<>(); // creating 2d position arraylist of new word

        ArrayList<Integer> pos1 = new ArrayList<>(); // adding individual coordinates of word to arraylist
        pos1.add(0);
        pos1.add(0);
        ArrayList<Integer> pos2 = new ArrayList<>();
        pos2.add(0);
        pos2.add(1);
        ArrayList<Integer> pos3 = new ArrayList<>();
        pos3.add(0);
        pos3.add(2);
        ArrayList<Integer> pos4 = new ArrayList<>();
        pos4.add(0);
        pos4.add(3);
        ArrayList<Integer> pos5 = new ArrayList<>();
        pos5.add(0);
        pos5.add(4);
        ArrayList<Integer> pos6 = new ArrayList<>();
        pos6.add(0);
        pos6.add(5);
        ArrayList<Integer> pos7 = new ArrayList<>();
        pos7.add(0);
        pos7.add(6);

        pos.add(pos1); // combining the coordinates arraylists into the pos arraylist
        pos.add(pos2);
        pos.add(pos3);
        pos.add(pos4);
        pos.add(pos5);
        pos.add(pos6);
        pos.add(pos7);

        Assertions.assertEquals(99, scorer.calculateWordScore(game, pos));
    }
    @Test
    public void multiScoreTest(){
        Game game = new Game();
        // creating letter cells
        Cell c0 = new Cell("V", 4, 1);
        Cell c1 = new Cell("A", 1, 1);
        Cell c2 = new Cell("L", 1, 1);
        Cell c3 = new Cell("U", 1, 1); // not including e twice since the words are connected with it

        Cell w0 = new Cell("C", 3, 1);
        Cell w1 = new Cell("A", 1, 1);
        Cell w2 = new Cell("R", 1, 1);
        Cell w3 = new Cell("E", 1, 1);

        // initializing board state and adding letters
        GameBoard board = game.getGameBoard();

        BoardManager.SetBoardCell(0, 0, c0, board);
        BoardManager.SetBoardCell(0, 1, c1, board);
        BoardManager.SetBoardCell(0, 2, c2, board);
        BoardManager.SetBoardCell(0, 3, c3, board);

        BoardManager.SetBoardCell(3, 4, w0, board);
        BoardManager.SetBoardCell(2, 4, w1, board);
        BoardManager.SetBoardCell(1, 4, w2, board);
        BoardManager.SetBoardCell(0, 4, w3, board);

        ScoringSystem scorer = new ScoringSystem();
        ArrayList<List<List<Integer>>> pos = new ArrayList<>(); // creating 3d position arraylist of new words

        ArrayList<List<Integer>> word1 = new ArrayList<>(); // stores coordinates of first word
        ArrayList<Integer> pos1 = new ArrayList<>(); // adding individual coordinates of word to arraylist
        pos1.add(0);
        pos1.add(0);
        ArrayList<Integer> pos2 = new ArrayList<>();
        pos2.add(0);
        pos2.add(1);
        ArrayList<Integer> pos3 = new ArrayList<>();
        pos3.add(0);
        pos3.add(2);
        ArrayList<Integer> pos4 = new ArrayList<>();
        pos4.add(0);
        pos4.add(3);
        ArrayList<Integer> pos5 = new ArrayList<>();
        pos5.add(0);
        pos5.add(4);
        // adding coordinates to word
        word1.add(pos1);
        word1.add(pos2);
        word1.add(pos3);
        word1.add(pos4);
        word1.add(pos5);

        ArrayList<List<Integer>> word2 = new ArrayList<>(); // stores coordinates of second word
        ArrayList<Integer> coord1 = new ArrayList<>(); // adding individual coordinates of word to arraylist
        coord1.add(3);
        coord1.add(4);
        ArrayList<Integer> coord2 = new ArrayList<>();
        coord2.add(2);
        coord2.add(4);
        ArrayList<Integer> coord3 = new ArrayList<>();
        coord3.add(1);
        coord3.add(4);
        word2.add(coord1);
        word2.add(coord2);
        word2.add(coord3);
        word2.add(pos5);

        pos.add(word1);
        pos.add(word2);

        Assertions.assertEquals(23, scorer.calculateMultiWordScore(game, pos));
    }

    // following tests are for hand scores
    @Test
    public void calculateEmptyHandUnplacedLetters(){
        Game game = new Game();
        Player p = new Player("Jeff");
        game.addPlayer(p);
        ScoringSystem scorer = new ScoringSystem();

        Assertions.assertEquals(0, scorer.calculateUnplacedLetters(game));
    }

    @Test
    public void calculateUnplacedLettersTest(){
        Game game = new Game();
        Player p = new Player("Jeff");
        game.addPlayer(p);
        // creating letter cells
        Cell c0 = new Cell("V", 4, 1);
        Cell c1 = new Cell("A", 1, 1);
        Cell c2 = new Cell("L", 1, 1);
        Cell c3 = new Cell("U", 1, 1);
        Cell[] hand = {c0, c1, c2, c3};
        PlayerManager.setHand(hand, p);
        ScoringSystem scorer = new ScoringSystem();

        Assertions.assertEquals(7, scorer.calculateUnplacedLetters(game));
    }

    @Test
    public void initializeCellScoreTest(){
        Cell c0 = new Cell("V", 1);
        ScoringSystem scorer = new ScoringSystem();
        scorer.initializeCellScore(c0);
        Assertions.assertEquals(4, BoardManager.GetCellScore(c0));

    }
}
