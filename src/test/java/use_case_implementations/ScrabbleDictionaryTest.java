package use_case_implementations;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import usecases.usecase_implementations.ScrabbleDictionary;

import java.util.ArrayList;
import java.util.List;

public class ScrabbleDictionaryTest {
    ScrabbleDictionary dictionary = new ScrabbleDictionary();
    /**
     * Test ScrabbleDictionary for happy flow when there is only one word to check.
     * Using inDictionary method, asserts true for a valid word
     */
    @Test
    public void checkOneValidWord() {
        List<String> word = new ArrayList<String>();
        word.add("WORD");

        Assertions.assertTrue(dictionary.inDictionary(word));
    }
    /**
     * Test ScrabbleDictionary for happy flow when there are multiple words to check.
     * Using inDictionary method, asserts true for valid words
     */
    @Test
    public void checkMultipleValidWord() {
        List<String> word = new ArrayList<String>();
        word.add("HERE");
        word.add("ARE");
        word.add("MORE");
        word.add("WORDS");

        Assertions.assertTrue(dictionary.inDictionary(word));
    }
    /**
     * Test ScrabbleDictionary for unhappy flow when there is only one word to check.
     * Using inDictionary method, asserts false for an invalid valid word
     */
    @Test
    public void checkOneInvalidWord() {
        List<String> word = new ArrayList<String>();
        word.add("AGDHN");

        Assertions.assertFalse(dictionary.inDictionary(word));
    }
    /**
     * Test ScrabbleDictionary for unhappy flow when there are multiple words to check.
     * Checks for invalid word at the beginning of the list
     * Using inDictionary method, asserts false for an invalid word
     */
    @Test
    public void checkListStartInvalidWord() {
        List<String> word = new ArrayList<String>();
        word.add("AHDHJIKS");
        word.add("THESE");
        word.add("ARE");
        word.add("VALID");

        Assertions.assertFalse(dictionary.inDictionary(word));
    }
    /**
     * Test ScrabbleDictionary for unhappy flow when there are multiple words to check.
     * Checks for invalid word in the middle of the list
     * Using inDictionary method, asserts false for an invalid word
     */
    @Test
    public void checkListMidInvalidWord() {
        List<String> word = new ArrayList<String>();
        word.add("THIS");
        word.add("HAS");
        word.add("AN");
        word.add("XJSOJD");
        word.add("INVALID");
        word.add("WORD");

        Assertions.assertFalse(dictionary.inDictionary(word));
    }
    /**
     * Test ScrabbleDictionary for unhappy flow when there are multiple words to check.
     * Checks for invalid word at the end of the list
     * Using inDictionary method, asserts false for an invalid word
     */
    @Test
    public void checkListEndInvalidWord() {
        List<String> word = new ArrayList<String>();
        word.add("ZEBRA");
        word.add("XYLOPHONE");
        word.add("YAK");
        word.add("AHSKDJC");

        Assertions.assertFalse(dictionary.inDictionary(word));
    }
}
