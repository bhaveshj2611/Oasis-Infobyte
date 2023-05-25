package com.bhavesh.projects;

import java.util.Scanner;
import java.util.Random;

public class guess_the_num {
    public static void main(String[] args) {
        System.out.println("      *******************");
        System.out.println("        GUESS THE NUMBER ;)");
        System.out.println("      *******************");
        GameDisplay.gameMenu();
    }
}

class GameDisplay {
    static int choice;
    static int point;
    
    static void gameMenu() {
        Scanner inp1 = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Play");
        System.out.println("2. Quit");
        System.out.print("What would you like to do (1/2): ");
        choice = inp1.nextInt();
        
        switch (choice) {
            case 1 -> play();
            case 2 -> System.exit(1);
        }
    }

    static void play() {
        Scanner inp2 = new Scanner(System.in);
        System.out.println("Which mode you would like to play: ");
        System.out.println("1. Challenge Mode");
        System.out.println("2. Score Mode");
        int mode = inp2.nextInt();
        
        switch (mode) {
            case 1 -> challenge();
            case 2 -> score();
        }
    }

    static void challenge() {
        Scanner inp5 = new Scanner(System.in);
        Random random = new Random();
        int rd = random.nextInt(100);
        System.out.println("-------Game Begins-------");
        System.out.println("A random number has been generated");
        System.out.println("You will have 6 attempts to guess it right, else YOU LOSE ");
        System.out.println("Enter your guessed number that has been generated :- ");
        int count = 0;
        int guess;
        while (count < 6) {
            guess = inp5.nextInt();
            count++;
            if (guess < rd) {
                System.out.println("Guess is pretty low, go higher");

            } else if (guess > rd) {
                System.out.println("Guess is higher, go lower ;)");
                
            } else {
                System.out.println("Congratulations!, You completed the challenge ^_^");
                playagain();
            }
        }
        System.out.println("You could not guess it , YOU LOSE ");
        playagain();
    }

    static void score() {
        Scanner inp4 = new Scanner(System.in);
        Random random = new Random();
        int rd = random.nextInt(100);
        System.out.println("-------Game Begins-------");
        System.out.println("A random number has been generated");
        System.out.println("Faster you guess better score you get");
        System.out.println("Enter your guessed number that has been generated :- ");
        int count = 0;
        int guess = 0;

        while (guess != rd) {
            guess = inp4.nextInt();
            count++;
            if (guess < rd) {
                System.out.println("Guess is pretty low, go higher");
            } else if (guess > rd) {
                System.out.println("Guess is higher, go lower ;)");
            } else {
                System.out.println("Congratulations!, You guessed the number correctly ^_^");
            }
        }
        System.out.println("You guessed it correctly in " + count + " attempts");
        System.out.println("Hence your score is " + count);
        point = count;
        playagain();
    }
    static void playagain() {
        Scanner inp3 = new Scanner(System.in);
        System.out.println("Would you like to play again?");
        System.out.println("1.Yes");
        System.out.println("2.No");
        int again = inp3.nextInt();
        switch (again) {
            case 1 -> play();
            case 2 -> gameMenu();
        }
    }
}
