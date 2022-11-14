/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jingw
 */
import entities.*;
import View.GameView;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        //create a new game
        Player p = new Player("clark");
        
        
        Game.getInstance();
        Game.getInstance().addPlayer(p);
        
        LetterBag l = Game.getInstance().getLetterBag();
        String[] k = new String[7];
        for(int i=0; i<7; i++) {
            k[i] = l.getRandomTile();
        }
        
        p.setHand(k);
        
        GameView view = new GameView();
        Scanner scan = new Scanner(System.in);
        
        
        boolean quit = false;
        
        while(!quit) {
            view.printState();
            String s = scan.next();
            if(s.equals("1"))
                quit = !quit;
        }
        
        
    }
}
