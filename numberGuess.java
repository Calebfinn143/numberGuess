import java.util.Scanner;
import java.util.ArrayList;

public class numberGuess {
    public static void main(String[] args) {
        boolean playGame = true; // Set game to play

        intro();
        // Play the game until user decides to stop.
        do {
          ArrayList<Integer> guesses = new ArrayList<Integer>();
          int maxGuess = setUp();
          int randomNumber = randomGenerator(maxGuess);
          int numOfGuesses = guess(maxGuess,randomNumber, guesses);
          playGame = promptPlayAgain(numOfGuesses, playGame, guesses);
        } while (playGame);
      }

      static void intro() {
        // Introduce the game.
        System.out.println("Welcome to the Guess The Number Game!");
        System.out.println("\nYour goal will be to guess the correct number as fast as possible.");
        System.out.println("Don't worry, hints will be given to help you out.");
      }

      static int setUp() {
        int maxGuess = 0;   // Initialize maxGuess within scope of method
        System.out.println("First, choose how hard you wish the game to be.");
        System.out.println("Choose between Level 1 - 10. Be warned, level difficulty increases greatly after level 5.\n");

        // Take input from user
        Scanner myObj = new Scanner(System.in);
        int inputLevel = myObj.nextInt();
        System.out.println();

        // Determine level based on user input
        switch (inputLevel) {
          case 1:
            maxGuess = 10;
            break;
          case 2:
            maxGuess = 20;
            break;
          case 3:
            maxGuess = 30;
            break;
          case 4:
            maxGuess = 40;
            break;
          case 5:
            maxGuess = 50;
            break;
          case 6:
            maxGuess = 80;
            break;
          case 7:
            maxGuess = 150;
            break;
          case 8:
            maxGuess = 250;
            break;
          case 9:
            maxGuess = 500;
            break;
          case 10:
            maxGuess = 1000;
            break;
          default:
            maxGuess = 100;
            break;
        }
        return maxGuess;
      }

      static int randomGenerator(int maxGuess) {
        // Genarate a random number within the level range chosen by user
        int randomNumber = (int)(Math.random() * maxGuess);
        return randomNumber;
      }

      static int guess(int maxGuess, int randomNumber, ArrayList<Integer> guesses) {
        System.out.println("Guess a number between 0 and " + maxGuess + "\n");
        int guess = -1;
        int numOfGuesses = 0;
        
        // Give hints to the user on whether to guess higher or lower
        while (guess != randomNumber) {
          Scanner myObj = new Scanner(System.in);
          guess = myObj.nextInt();
          if (guess < randomNumber) {
            System.out.println("\nToo low! Guess again.");
          } else if (guess > randomNumber) {
            System.out.println("\nToo high! Guess again.");
          }
          guesses.add(guess);   // Add guesses to arrayList
          numOfGuesses += 1;    // Add count to total number of guesses
        }
        System.out.println("\nCongrats! You found the correct answer!");
        return numOfGuesses;
      }

      static boolean promptPlayAgain(int numOfGuesses, boolean playGame, ArrayList<Integer> guesses) {
        // Display to the user the number of guess attempts and list of attempts.
        System.out.println("It took you " + numOfGuesses + " try/tries.");
        System.out.println("Your guesses were: ");
        for (int i : guesses) {
          if (i == guesses.size()) {
            System.out.print("and " + i);
          } else {
            System.out.print(i + ", ");
          }
        }
        // Prompt the User to continue playing.
        System.out.println("\n \nCare to try again? Yes/No");
        Scanner myObj = new Scanner(System.in);
        String continuePlaying = myObj.nextLine();

        // Prompt user if they want to play again
        if (continuePlaying.equalsIgnoreCase("yes")) {
          playGame = true;
        } else {
          playGame = false;
        }
        return playGame;
      }
}