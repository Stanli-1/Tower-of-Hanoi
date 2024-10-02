// This program takes in the number of rings, the name of the three pegs, and prints the instructions to solve the puzzle in the minimum amount of moves. To show how this program works, lets use 3 as the ring number. Since 3 is not equal to 0, it will go to line 17. This line will then recursively call itself, decrementing the number of rings each time. The first time, it will move ring number 2 (3-1) by switching the targetPeg and sparePeg. This results in ring 2 moving to the middle peg (assuming the targetPeg is the right-most peg and the source is the left-most peg). Then, the program is called again with ring number 1 (to top-most ring), and is moved to the right-most peg because the sparePeg and targetPeg are switched again. The third time, ring one is moved to the middle peg to allow ring three to move to the targetPeg. Additionally, the steps are printed back up the calling chain since recursion uses the call stack. This means the instructions will print in the correct order rather than how the computer solved the puzzle. At this point, n == 0, so the program returns and n is now 3, which allows the program to print the isntructions to move ring 3. Now the computer is on line 21, which repeats the instructians above but this time switching the sourcePeg to be the middle peg, as thats where the rings are starting this time (rather than the left-most peg originally). The result of this is that n-1 rings will now move to the peg with the largest ring.

class GameSolver {

    // Keeps track of step number
    int stepNumber = 0;

    // Pass in the number of rings, and the names of the 3 rods
    // The source peg is the one where rings start on
    //    targetPeg is where the rings will be be on at the end of the solution
    //    sparePeg is the other peg that is used to help transfer the rings
    public void solve( int ringNumber, String source, String sparePeg, String targetPeg ) {
        if (ringNumber == 0) {
            return;
        }
        else {
            solve(ringNumber - 1, source, targetPeg, sparePeg);
            // Increment the stepNumber
            stepNumber++;
            System.out.println(stepNumber + ") Move Ring " + ringNumber + " from Peg " + source + " to Peg " + targetPeg);
            solve(ringNumber - 1, sparePeg, source, targetPeg);   
        }
    }//solve

    // Call this function after every solution to reset the step number for next time
    public void resetStepNumber( int newStepNumber) {
        stepNumber = newStepNumber;
    }
    
}//GameSolver