package guessinggame;

import javax.swing.*;

public class GuessingGame {
    //main method 
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random()*100 + 1); //generate random num
        int userAnswer = 0; //initialize
        // log correct answer to console for verification
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1; //initialize
        // Display input dialog until the user guesses the correct number 
        while (userAnswer != computerNumber)
        {
            String response = JOptionPane.showInputDialog(null, 
                "Enter a guess between 1 and 100", "Guessing Game", 3); // display initial input dialog to user
            userAnswer = Integer.parseInt(response); //convert string to int for use in check method below
            //pass userAnswer and the Computer gen number along with guess count to method
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber, count)); 
            count++; //increment number of tries for each attempt
        }  
    }
    
    //Determine guess function to check how close number is to generated number and display try count
    public static String determineGuess(int userAnswer, int computerNumber, int count){
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == computerNumber ){
            return "Correct!\nTotal Guesses: " + count;
        }
       else if (computerNumber-userAnswer<=3 && 0<computerNumber-userAnswer) {
            return "You are little low try again.\nTry Number: " + count;
        }
       else if (userAnswer-computerNumber<=3 && 0<userAnswer-computerNumber){
            return "You are little high close try again.\nTry Number: " + count;
        }
        else if (userAnswer - computerNumber>3) {

            return "Your guess is too high, try again.\nTry Number: " + count;
        }
        else if (computerNumber-userAnswer >3 ) {

            return "Your guess is too low, try again.\nTry Number: " + count;
        }
        else {
            return "Your guess is incorrect\nTry Number: " + count;
            
        }
        System.setOut();
    }
}
