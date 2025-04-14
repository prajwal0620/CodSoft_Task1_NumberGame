package com.game;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        playMultipleRounds();
    }

    public static boolean playGame() {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int attemptsLeft = 10;
        boolean guessedCorrectly = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have 10 attempts to guess it.");

        while (attemptsLeft > 0 && !guessedCorrectly) {
            System.out.print("Enter your guess (attempts left: " + attemptsLeft + "): ");
            int guess = scanner.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly.");
            }

            attemptsLeft--;

            if (attemptsLeft == 0 && !guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }
        }

        return guessedCorrectly;
    }

    public static void playMultipleRounds() {
        int roundsPlayed = 0;
        int roundsWon = 0;
        int totalAttempts = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            roundsPlayed++;
            System.out.println("\nRound " + roundsPlayed);
            boolean guessedCorrectly = playGame();

            if (guessedCorrectly) {
                roundsWon++;
                totalAttempts += (10 - 1);
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("y")) {
                break;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Attempts Used: " + totalAttempts);
        System.out.println("Your score is " + roundsWon + " out of " + roundsPlayed + " rounds won!");
    }
}