package guessinggame;
import javax.swing.*;
import java.util.Random;

public class GuessingGame

{
    public static void main(String[] args)
    {
        Random random = new Random();
        
        int input = 0;
        int computerNumber = 0;
        int userGuess = 0;
        int moves = 3;
        
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Desktop\\download1.png");
        ImageIcon icon1 = new ImageIcon("C:\\Users\\hp\\Desktop\\download2.png");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\hp\\Desktop\\download3.png");
        ImageIcon icon3 = new ImageIcon("C:\\Users\\hp\\Desktop\\download4.png");
        String[] options = {"        --Select--       ","Easy","Medium","Hard"};
        try
        {
            while(input==0)
            {
                int counter1 = 1;
                int counter2 = 1;
                int counter3 = 1;
                String response1 = (String)JOptionPane.showInputDialog(null,"Select difficulty level..   \n", "Guessing Game", JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
                if(response1.equals("Easy"))
                {
                    computerNumber = random.nextInt(10) + 1;
                }
                else if(response1.equals("Medium"))
                {
                    computerNumber = random.nextInt(100) + 1;
                }
                else if(response1.equals("Hard"))
                {
                    computerNumber = random.nextInt(1000) + 1;
                }
                else if(response1.equals("        --Select--       "))
                {
                    JOptionPane.showMessageDialog(null, "Please select one difficulty level to start the game.");
                }
                System.out.println("The correct guess would be " + computerNumber);
        
                while ((userGuess != computerNumber) && counter1<=moves && counter2<=moves && counter3<=moves)
                {
                    if (response1.equals("Easy"))
                    {
                        String response2 = (String)JOptionPane.showInputDialog(null,"Enter a guess between 1 and 10\nYou have " + (moves-counter1+1) + " move(s).", "Guessing Game", JOptionPane.QUESTION_MESSAGE, icon1, null, null);
                        userGuess = Integer.parseInt(response2);
                        JOptionPane.showMessageDialog(null, ""+ determineGuess(response1, userGuess, computerNumber, counter1, moves), "Result", JOptionPane.INFORMATION_MESSAGE);
                        counter1++;
                    }
                    else if (response1.equals("Medium"))
                    {
                        String response3 = (String)JOptionPane.showInputDialog(null,"Enter a guess between 1 and 100\nYou have " + (moves-counter2+1) + " move(s).", "Guessing Game", JOptionPane.QUESTION_MESSAGE, icon2, null, null);
                        userGuess = Integer.parseInt(response3);
                        JOptionPane.showMessageDialog(null, ""+ determineGuess(response1, userGuess, computerNumber, counter2, moves), "Result", JOptionPane.INFORMATION_MESSAGE);
                        counter2++;
                    }
                    else if (response1.equals("Hard"))
                    {
                        String response4 = (String)JOptionPane.showInputDialog(null,"Enter a guess between 1 and 1000\nYou have " + (moves-counter3+1) + " move(s).", "Guessing Game", JOptionPane.QUESTION_MESSAGE, icon3, null, null);
                        userGuess = Integer.parseInt(response4);
                        JOptionPane.showMessageDialog(null, ""+ determineGuess(response1, userGuess, computerNumber, counter3, moves), "Result", JOptionPane.INFORMATION_MESSAGE);
                        counter3++;
                    }
                    if((userGuess!=computerNumber) && (counter1==moves+1 || counter2==moves+1 || counter3==moves+1))
                    {
                        
                        JOptionPane.showMessageDialog(null, "You are out of moves!\nYou lost the game!\nThe correct guess was "+computerNumber, "Result", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(response1!="        --Select--       ")
                {
                    input = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION);
                }
            }
        }
        catch(NumberFormatException e){} 
        catch(NullPointerException e1){}
    }
    public static String determineGuess(String response1, int userGuess, int computerNumber, int counter, int moves)
    {
        if (response1.equals("Easy"))
        {
            if (userGuess <= 0 || userGuess > 10) 
            {
                return "Your guess is invalid";
            }
            else if (userGuess == computerNumber )
            {
                return "Correct!\nYou won the game!\nTotal Moves Used: " + counter;
            }
            else if (userGuess > computerNumber) 
            {
                return "Your guess is incorrect\nIt is high, try again.\nMoves Used: " + counter + "\nRemaining Moves: " + (moves-counter);
            }
            else if (userGuess < computerNumber) 
            {
                return "Your guess is incorrect\nIt is low, try again.\nMoves Used: " + counter + "\nRemaining Moves: " + (moves-counter);
            }
        }
        if (response1.equals("Medium"))
        {
            if (userGuess <= 0 || userGuess > 100) 
            {
                return "Your guess is invalid";
            }
            else if (userGuess == computerNumber )
            {
                return "Correct!\nYou won the game!\nTotal Moves Used: " + counter;
            }
            else if (userGuess > computerNumber) 
            {
                return "Your guess is incorrect\nIt is high, try again.\nMoves Used: " + counter + "\nRemaining Moves: " + (moves-counter);
            }
            else if (userGuess < computerNumber) 
            {
                return "Your guess is incorrect\nIt is low, try again.\nMoves Used: " + counter + "\nRemaining Moves: " + (moves-counter);
            }
        }
        if (response1.equals("Hard"))
        {
            if (userGuess <= 0 || userGuess > 1000) 
            {
                return "Your guess is invalid";
            }
            else if (userGuess == computerNumber )
            {
                return "Correct!\nYou won the game!\nTotal Moves Used: " + counter;
            }
            else if (userGuess > computerNumber) 
            {
                return "Your guess is incorrect\nIt is high, try again.\nMoves Used: " + counter + "\nRemaining Moves: " + (moves-counter);
            }
            else if (userGuess < computerNumber) 
            {
                return "Your guess is incorrect\nIt is low, try again.\nMoves Used: " + counter + "\nRemaining Moves: " + (moves-counter);
            }
        }
        return "";
    }
}