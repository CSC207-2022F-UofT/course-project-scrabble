package gui;

public class ScrabbleApp {
    static void generateStartUpPage() {
        StartupPage startupPage = new StartupPage();
        startupPage.createStartupPage();
    }

    public static void main(String[] args) {
        generateStartUpPage();
    }
}
