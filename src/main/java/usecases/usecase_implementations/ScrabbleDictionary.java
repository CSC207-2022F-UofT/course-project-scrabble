package usecases.usecase_implementations;
import java.io.File; //the File class
import java.io.FileNotFoundException; //handle errors in File class
import java.util.ArrayList; //the ArrayList class
import java.util.HashMap; //key-value pairs for easy searching
import java.util.List; //the List class
import java.util.Scanner; //to read the files

/**
 * This class is responsible for parsing through a ScrabbleDictionary and getting a HashMap for the dictionary to be
 * used in the game
 * @author Claire
 */

public class ScrabbleDictionary {
    private final String filepath = "src/main/game_resources/CollinsScrabbleWords(2019).txt";
    
    private HashMap<String, ArrayList<String>> dictionary; //made static so that static methods can access
    
    
    public static void main(String[] args) { //apparently I needed this to test it
        ScrabbleDictionary scrabbleDictionary = new ScrabbleDictionary();
    }

    /**
     * Constructor for the ScrabbleDictionary class. Reads the scrabble dictionary file and creates a hashmap for it
     */
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
                this.dictionary.put(String.valueOf(currkey), currlist); //adds last letter to the dictionary
            }
        } catch (FileNotFoundException e) { //if the file can't be found, prints the error and the stack trace
            System.out.println("error: couldn't find the file");
        }

    }

    /**
     * This method is responsible for searching for words in the dictionary
     * @param wordlist list of words that need to be checked
     * @return boolean returns whether the words are in the dictionary
     */
    public boolean inDictionary(List<String> wordlist) { //searches for words in the dictionary
        for (String word : wordlist) {
            String key = String.valueOf(word.charAt(0)); //takes the first letter of the word as the key
            ArrayList<String> dict = this.dictionary.get(key); //an ArrayList of all the words starting with that letter
            if (!dict.contains(word)) {
                return false; //returns false if the word is not in the list
            }
        }
        return true;
    } //after looping through the entire list of words, returns true

}