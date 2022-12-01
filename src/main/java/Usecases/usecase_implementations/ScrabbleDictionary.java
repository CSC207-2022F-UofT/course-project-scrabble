package Usecases.usecase_implementations;
import entities.GameBoard;

import java.io.File; //the File class
import java.io.FileNotFoundException; //handle errors in File class
import java.util.ArrayList; //the ArrayList class
import java.util.HashMap; //key-value pairs for easy searching
import java.util.List; //the List class
import java.util.Scanner; //to read the files


public class ScrabbleDictionary {
    private final String filepath = "src/main/game_resources";
    
    private HashMap<String, ArrayList<String>> dictionary; //made static so that static methods can access
    public static void main(String[] args) { //apparently I needed this to test it
        ScrabbleDictionary scrabbleDictionary = new ScrabbleDictionary();
    }

    public ScrabbleDictionary() {
        try { //if the file can be found, this happens
            this.dictionary = new HashMap<>();
            File wordlist = new File(filepath);
            try (Scanner fileReader = new Scanner(wordlist)) {
                char currkey = 'A'; // initial character to serve as first key
                ArrayList<String> currlist = new ArrayList<>(); // empty array to be filled with words
                String line = fileReader.nextLine();//first line
                while (fileReader.hasNextLine()) {
                    if (line.charAt(0) == currkey) { //if the word starts with the key
                        currlist.add(line); //adds the current word to the array
                    } else { //if the word doesn't start with they key
                        this.dictionary.put(String.valueOf(currkey), currlist); // adds the key/value pair to the HashMap
                        currkey = line.charAt(0); //sets the new key
                        currlist = new ArrayList<>(); //creates a new empty array
                        currlist.add(line);
                    }
                    line = fileReader.nextLine(); //moves on to the next line
                }
                //closes the file
            } // initial character to serve as first key
        } catch (FileNotFoundException e) { //if the file can't be found, prints the error and the stack trace
            System.out.println("error: couldn't find the file");
        }

    }

    public boolean inDictionary(ArrayList<List<List<Integer>>> move, GameBoard board) { //searches for words in the dictionary
        List<String> wordlist = wordParser(move, board); //calls wordParser to return a list of words
        for (String word : wordlist) {
            String key = String.valueOf(word.charAt(0)); //takes the first letter of the word as the key
            ArrayList<String> dict = this.dictionary.get(key); //an ArrayList of all the words starting with that letter
            if (!dict.contains(word)) {
                return false; //returns false if the word is not in the list
            }
        }
        return true;
    } //after looping through the entire list of words, returns true

    private static List<String> wordParser(ArrayList<List<List<Integer>>> move, GameBoard board) { //determines words from tile coordinates
        List<String> wordlist = new ArrayList<>(); //the list of all words made from a move
        for (List<List<Integer>> word : move) { //for each separate word in the list
            StringBuilder newword = new StringBuilder();
            for (List<Integer> letter: word) { //for each letter in the word
                newword.append(board.getBoardCellValue(letter.get(0), letter.get(1))); //appends the letter to the current string
            }
            wordlist.add(newword.toString()); //adds the string to the wordlist
        }
        return wordlist;
    }


}