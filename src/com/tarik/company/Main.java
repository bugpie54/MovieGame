package com.tarik.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        ArrayList<String> list = new ArrayList<>();
        try {
            File moviesfile = new File("movieslist.txt");
            Scanner scanner = new Scanner(moviesfile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
            System.out.println(list.size() + " Movies Title: " + list);
        } catch (FileNotFoundException e) {
            System.out.println("Problem wit file" + e);
        }

        int randomNumber = (int) (Math.random() * list.size());
        System.out.println((randomNumber + 1) + " " + list.get(randomNumber));

        String randomMovieTitle = list.get(randomNumber);
        Game game = new Game();

        game.play(randomMovieTitle);

    }
}
