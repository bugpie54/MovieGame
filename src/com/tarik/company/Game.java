package com.tarik.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    public Game() {
    }

    public void play(String movieTitle) {

        System.out.println("Welcome to MovieGame, start guessing a letter that might be in the title," +
                "your guesses number depends on the movie title length.");

        if (!movieTitle.isEmpty()) {
            // char[] array = randomMovieTitle.toCharArray();
            int stringCharTotal = movieTitle.length();
            // System.out.println(movieTitle.length());

            try {
                int x = movieTitle.length();
                String title = movieTitle.replaceAll("[a-zA-Z]", "_"); // replace each letter with an "_"
                int index = 0;
                char character = movieTitle.charAt(0);
                for (int Y = 0; Y < x; x--) {
                    Scanner inputScanner = new Scanner(System.in);
                    String userInput = inputScanner.nextLine();

                    // char[] userCharArray = userInput.toCharArray();
                    for (int i = 0; i < stringCharTotal; i++) {
                        character = movieTitle.charAt(i);
                        if (character == userInput.charAt(0)) {
                            System.out.println("Nice! there is a match");
                            index = movieTitle.indexOf(character, i);
                            // newTitle = title.replace(title.charAt(titleIndex), randomMovieTitle.charAt(index));
                            //char titleChar = title.charAt(s);
                            //title = title.replace(titleChar, character);
                            char[] charHidden = title.toCharArray();
                            charHidden[index] = character;
                            title = String.valueOf(charHidden);
                        }
                    }
                    char underscore = '_';
                    boolean noUnderscore = title.indexOf(underscore) == -1;
                    if (noUnderscore) {
                        break;
                    }

                    System.out.println("You have " + x + " guesses");
                    System.out.println(title);
                }
                char underscore = '_';
                boolean noUnderscore = title.indexOf(underscore) == -1;
                if (noUnderscore) {
                    System.out.println("You win! ");
                    System.out.println("The movie is :  " + title);
                } else {
                    System.out.println("You lose! ");
                    System.out.println("The movie is :  " + movieTitle);
                }
                System.out.println(character + " " + " " + index + " " + title);

            } catch (IndexOutOfBoundsException exception) {
                System.out.print("Index is out of bounds");
            } catch (InputMismatchException exception) {
                System.out.print("Input mismatch");
            }
        }
    }
}
