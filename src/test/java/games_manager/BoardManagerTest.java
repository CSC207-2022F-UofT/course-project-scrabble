package games_manager;

import entities.Game;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardManagerTest {
    @Test
    public void checkLetterTestValid(){
        Game game = new Game();
        BoardManager b_manager = new BoardManager();
        int[] coordinates = new int[]{7,3};
        String letter = new String("A");
        b_manager.checkLetter(coordinates, letter, game);
        Assertions.assertEquals(game.getGameBoard().getBoardCellValue(7,3), "A");
    }
    @Test
    public void checkLetterTestOverlap(){
        Game game = new Game();
        BoardManager b_manager = new BoardManager();
        int[] coordinates = new int[]{7,3};
        String letter1 = new String("A");
        String letter2 = new String("B");
        b_manager.checkLetter(coordinates, letter1, game);
        Assertions.assertFalse(b_manager.checkLetter(coordinates, letter2, game));
    }
    @Test
    public void checkWordTest(){
        Game game = new Game();
        BoardManager b_manager = new BoardManager();
        int[] coordinates1 = new int[]{7,5};
        int[] coordinates2 = new int[]{7,6};
        int[] coordinates3 = new int[]{7,7};
        int[] coordinates4 = new int[]{7,8};
        int[] coordinates5 = new int[]{7,9};
        ArrayList<Integer> coordinatesA = new ArrayList<Integer>();
        coordinatesA.add(0,7);
        coordinatesA.add(1,5);
        ArrayList<Integer> coordinatesB = new ArrayList<Integer>();
        coordinatesB.add(0,7);
        coordinatesB.add(1,6);
        ArrayList<Integer> coordinatesC = new ArrayList<Integer>();
        coordinatesC.add(0,7);
        coordinatesC.add(1,7);
        ArrayList<Integer> coordinatesD = new ArrayList<Integer>();
        coordinatesD.add(0,7);
        coordinatesD.add(1,8);
        ArrayList<Integer> coordinatesE = new ArrayList<Integer>();
        coordinatesE.add(0,7);
        coordinatesE.add(1,9);
        String letter1 = new String("H");
        String letter2 = new String("E");
        String letter3 = new String("L");
        String letter4 = new String("L");
        String letter5 = new String("O");
        b_manager.checkLetter(coordinates1, letter1, game);
        b_manager.checkLetter(coordinates2, letter2, game);
        b_manager.checkLetter(coordinates3, letter3, game);
        b_manager.checkLetter(coordinates4, letter4, game);
        b_manager.checkLetter(coordinates5, letter5, game);
        ArrayList<List<List<Integer>>> list_of_words = new ArrayList<List<List<Integer>>>();
        list_of_words.add(List.of(new ArrayList[]{coordinatesA, coordinatesB, coordinatesC, coordinatesD, coordinatesE}));
        Assertions.assertEquals(b_manager.checkWord(game), list_of_words);
    }

    @Test
    public void resetMovesTest(){
        Game game = new Game();
        BoardManager b_manager = new BoardManager();
    }
}
