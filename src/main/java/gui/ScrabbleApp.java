package gui;

import gui.pages.StartupPage;

/**
 * The ScrabbleApp is the application that runs the Scrabble Game. 
 * @author Victor Zheng
 * @version 1.0
 * @since 2022-11-19
 */

public class ScrabbleApp {

    /**
     * Generates the startup page. Aka the welcome page or the first page we see
     */
    static public void run() {
        StartupPage startupPage = new StartupPage();
        startupPage.createStartupPage();
    }

}
