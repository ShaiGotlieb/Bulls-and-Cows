package mmn11_q1;
import javax.swing.JOptionPane;
/**
 * @author Shai Gotlieb
 * Question 1 , Maman 11 , 29/03/2018
 */
public class Mmn11_Q1 {
//start main
    public static void main(String[] args) {
        int count = 0;//count number of guesses
        String str = "";
        GameLogic game = new GameLogic();//creating a new game by calling the constructor
        String printMessage;//the message that will be printing
        String userInput = JOptionPane.showInputDialog("Enter 4 digits number");
//run this loop while the user didn't guess the right number
while(game.getBull() != 4 )
{
    //check the length of the input
    while(userInput.length() != 4){
        JOptionPane.showMessageDialog(null,"Please Insert 4 digits number");
        userInput = JOptionPane.showInputDialog(str + "Bad Input!" + '\n');
    }
    //call a method from GameLogic class which check the user answer according to the generated number
    printMessage = game.checkUserAnswer(userInput);
    //game-over (succeed) - ask user if to play another game
    if(game.getBull()==4)
    {
        int reply = JOptionPane.showConfirmDialog(null, str + "Good Job!!" + '\n' + "You Have Guessed the number: " + game.getNumber() + " in " + count + " tries!" + '\n' + "Would you like to play again?", "BUL-PGIA!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            //replay - user clicked 'YES'
            main(new String[0]);
        }
        else {
            //exit program - user clicked 'NO'
            System.exit(0);
        }
        //printing the history of inputs with a compliment when user winning
        JOptionPane.showInputDialog(null, str + '\n' + '\n' + "Good Job!!" + '\n' + '\n'+ "You Have Guessed the number: " + game.getNumber() + " in " + count + " tries!"+ '\n');
        return;
    }
    str += printMessage + '\n';
    //printing the history of inputs
    userInput = JOptionPane.showInputDialog(str);
    count++;
}
    }//end of main
}//end of class

