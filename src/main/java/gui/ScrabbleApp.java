package gui;

import gui.pages.StartupPage;

public class ScrabbleApp {

    /**
     * Generates the startup page. Aka the welcome page or the first page we see
     */
    static void generateStartUpPage() {
        StartupPage startupPage = new StartupPage();
        startupPage.createStartupPage();
    }

    /**
     * Run this to test and run the code
     */
    public static void main(String[] args) {
        generateStartUpPage();
    }
}
