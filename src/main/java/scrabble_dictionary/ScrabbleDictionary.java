package scrabble_dictionary;
import java.io.File; //the File class
import java.io.FileNotFoundException; //handle errors in File class
import java.util.ArrayList; //the ArrayList class
import java.util.HashMap; //key-value pairs for easy searching
import java.util.List; //the List class
import java.util.Scanner; //to read the files


public class ScrabbleDictionary {
    private static HashMap<String, ArrayList<String>> dictionary; //made static so that static methods can access

    public static void main(String [] args) { //apparently I needed this to test it
        new ScrabbleDictionary();
    }

    public ScrabbleDictionary() {
        this.dictionary = new HashMap<String, ArrayList<String>>();
        try { //if the file can be found, this happens
            File wordlist = new File("src/main/java/ScrabbleDictionary/CollinsScrabbleWords(2019).txt");
            Scanner fileReader = new Scanner(wordlist);
            char currkey = 'A'; // initial character to serve as first key
            ArrayList<String> currlist = new ArrayList<String>(); // empty array to be filled with words
            String line = fileReader.nextLine();//first line
            while (fileReader.hasNextLine()) {
                if (line.charAt(0) == currkey) { //if the word starts with the key
                    currlist.add(line); //adds the current word to the array
                } else { //if the word doesn't start with they key
                    dictionary.put(String.valueOf(currkey), currlist); // adds the key/value pair to the HashMap
                    currkey = line.charAt(0); //sets the new key
                    currlist = new ArrayList<String>(); //creates a new empty array
                    currlist.add(line);
                }
                line = fileReader.nextLine(); //moves on to the next line
            }
            fileReader.close(); //closes the file
        } catch (FileNotFoundException e) { //if the file can't be found, prints the error and the stack trace
            System.out.println("error: couldn't find the file");
            e.printStackTrace();
        }

    }
    public static boolean inDictionary(List<String> wordlist) { //searches for words in the dictionary
        for (String word: wordlist) {
            String key = String.valueOf(word.charAt(0)); //takes the first letter of the word as the key
            ArrayList<String> dict = dictionary.get(key); //an ArrayList of all the words starting with that letter
            if (!dict.contains(word)) {
                return false; //returns false if the word is not in the list
            }
        }
        return true;} //after looping through the entire list of words, returns true

    }

