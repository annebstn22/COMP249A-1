
import java.util.Scanner;

public class PlayLadderAndSnake {

    public static void main(String[] args) {

        //loop until player current position = 100
            //loop depending on number of players

        final int NB_PLAYERS_MIN = 2;
        final int NB_PLAYERS_MAX = 4;

        Scanner keyIn = new Scanner(System.in);


        System.out.print("Enter the # of players for your game - Number must be between " 
        + NB_PLAYERS_MIN +" and " + NB_PLAYERS_MAX +" inclusively: ");

        int nbInputAttempts = 0;  
        boolean isValidAttempt = false;  
        int nbPlayers = 0;   
        do {

            nbInputAttempts++;
            int input = keyIn.nextInt(); //change so that we can handle characters etc.
            if (input == 2 || input == 3 || input == 4 ){
                nbPlayers = input;
                isValidAttempt = true;
                System.out.println("Game is played by " + nbPlayers + " players!");
                //break;

            } else {
                System.out.print("\nBad Attempt " + nbInputAttempts);
                if (nbInputAttempts < 4){
                    System.out.print(" - Invalid # of players. Please enter a # between "+ NB_PLAYERS_MIN +
                    " and " + NB_PLAYERS_MAX +" inclusively: "); 
                    continue; 
                } else {
                    System.out.print(" - You have exhausted all your chances. Program will terminate!");
                    System.exit(0);
                }
            }

        }while(!isValidAttempt);

        if (isValidAttempt){
            LadderAndSnake game = new LadderAndSnake(nbPlayers);
        }
        

        //Test flipDice()
        /*
        System.out.println(LadderAndSnake.flipDice());
        System.out.println(LadderAndSnake.flipDice());
        System.out.println(LadderAndSnake.flipDice());
        System.out.println(LadderAndSnake.flipDice());
        System.out.println(LadderAndSnake.flipDice());
        System.out.println(LadderAndSnake.flipDice());
        System.out.println(LadderAndSnake.flipDice());
        System.out.println(LadderAndSnake.flipDice());*/

        //Close Scanner
        keyIn.close();

    }
    
}
