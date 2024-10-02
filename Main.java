import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {

    // scanner for customer's choice of number of rings
    Scanner userInput = new Scanner(System.in);

    // Variables for ring number and name of rods
    int ringNumber;
    String firstRod = "1";
    String secondRod = "2";
    String thirdRod = "3";

    // Object to call functions in GameSolver class
    GameSolver gameInstructions = new GameSolver();

    // Intro
    System.out.println("\nWelcome to Towers of Hanoi!");
    System.out.println("In this program, the three pegs will be labelled '1' '2' and '3'.");
    System.out.println("Peg '1' will be where the rings are intially and Peg '3' will be where they end up.");
    System.out.println("If at any point you would like to quit, enter '0'.");

    // Main Game loop
    while (true) {
        System.out.print("\nHow many rings would you like to play with?    ");
        // Store user's choice on number of rings
        ringNumber = userInput.nextInt();
        // End Game
        if (ringNumber == 0) 
            break;
        System.out.println("The solution for the minimum number of steps to solve are:\n");
        // Call the solve function and pass the user's choice of number of rings
        gameInstructions.solve(ringNumber, firstRod, secondRod, thirdRod);
        // Call the resetStepNumber function and pass 0 which will be the new initial step number
        gameInstructions.resetStepNumber(0);
        
        
    }//while

    //Goodbye message
    System.out.println("\nThank you for using this program!");
    
  }//main
}//Main