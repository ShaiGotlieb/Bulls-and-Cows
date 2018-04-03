package mmn11_q1;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 * @author Shai Gotlieb
 */
public class GameLogic {
    private int number;
    private int bull;
    int[] comNumArr = new int[4];
    //constructor
    public GameLogic(){
        number = validRandomNumber();
    }
    //generate a random 4 digits number
    public int validRandomNumber(){
        Random r = new Random();
        int[] tempArr = new int[10];
        int num = r.nextInt(10);
        int tempNum;
        //filling array with numbers 0 to 9
        for(int i=0; i<tempArr.length; i++)
            tempArr[i] = i;
        //swaping cells of random index and decreasing the number of i in order to save the right numbers (on the right side of the array)
        for(int i = tempArr.length-1; i >= 0; i--)
        {
            tempNum = tempArr[i];
            tempArr[i] = tempArr[num];
            tempArr[num] = tempNum;
            num = r.nextInt(i+1);
        }
        //return the right number after multiple it in order to get 4 digits number
        return (tempArr[9]*1000) + (tempArr[8]*100) + (tempArr[7]*10) + (tempArr[6]);
    }
    
    public int getBull(){
        return bull;
    }
    
    public int getNumber(){
        return number;
    }
    //check the answer from user input
    public String checkUserAnswer(String userVal){
        bull = 0;
        int hit = 0;
        int userNum;
        //check if user input is only digits
        for (int i = 0; i < 4; i++){
            if (!Character.isDigit(userVal.charAt(i)))
            {
                JOptionPane.showMessageDialog(null,"Please Insert only digits");
                return "Bad Input";
            }
            
        }
        //conver user input from string to int
        userNum = Integer.parseInt(userVal);
        int[] userNumArr = new int[4];
        int temp = number;
        
        //Inser numbers from user into array
        for(int i = 3; i >= 0; i-- )
        {
            userNumArr[i] = userNum%10;
            userNum /= 10;
        }
        //while user input is uncorrectly with no repeated digits - show message
        while(isRepeatingNumber(userNumArr))
        {
            JOptionPane.showMessageDialog(null,"Please Insert number with no repeating digits");
            return "Bad Input";
        }
        //Inser numbers from Random generator into array
        for(int i = 3; i >= 0; i-- )
        {
            comNumArr[i] = temp%10;
            temp /= 10;
        }
        
        //run through array to check hits or bulls
        for(int j = 0; j < comNumArr.length; j++)
        {
            //check bulls
            if(userNumArr[j] == comNumArr[j])
            {
                bull++;
            }
            else
            {   //check hits
                for(int i = 0; i<comNumArr.length; i++ )
                {
                    if(userNumArr[j] == comNumArr[i])
                        hit++;
                }
            }
        }
        return "Your Guess is: " + userVal + "| Bull: " + bull + "| hit: " + hit + "| miss: " + (4-(bull+hit));
    }
    //method to check repeated digit from user input
    public boolean isRepeatingNumber(int[] userNumArr)
    {
        for (int i = 0; i < userNumArr.length; i++)
        {
            for (int j = i + 1; j < userNumArr.length; j++)
            {
                if (userNumArr[i] == userNumArr[j]){
                    return true;
                }
            }
        }
        return false;
    }
}//end of class GameLogic


    