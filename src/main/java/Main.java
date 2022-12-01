/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import gui.pages.StartupPage;

/**
 * The Main is the application that runs the Scrabble Game.
 * @author Victor Zheng
 * @version 1.0
 * @since 2022-11-19
 */

public class Main {
    /**
     * Generates the startup page. Aka the welcome page or the first page we see
     */
    static void generateStartUpPage() {
        StartupPage startupPage = new StartupPage();
        startupPage.createStartupPage();
    }

    public static void main(String[] args) {
        generateStartUpPage();
    }
}
