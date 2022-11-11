package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleSimulator {
    public static void main(String[] args)
        throws IOException
    {
        System.out.println("Player Number 1 Name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();

        System.out.println("Player Number 2 Name: ");
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String name2 = reader2.readLine();

        System.out.println("Game Between: " + name1 + " & " + name2);

    }
}
