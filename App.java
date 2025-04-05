import static java.lang.System.*;
import java.util.Scanner;
import java.io.IOException;
 
 public class App extends Game
{
    public App(char playerSymbol, char playerSymbol_2)
    {
        super(playerSymbol, playerSymbol_2);
    }

    

    public static void main(String[] args) throws IOException
    {
        final char YES = 'Y';
        final char NO = 'N';

        App game = new App('x', 'o');
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");
        char menuChoice;
        

        game.createBoard();
        game.outPut();

        do
        {
            if(game.getStartPlayer() == game.getSymbol_1())
            {
                System.out.printf("\nPlayer %c, please enter your choice (1-9): ", game.getSymbol_1());
            }
            else
            {
                System.out.printf("\nPlayer %c, please enter your choice (1-9): ", game.getSymbol_2());
            }

            int choice = in.nextInt();
            while(choice < 1 || choice > 9)
            {
                System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                choice = in.nextInt();
                if(choice > 1 && choice < 9)
                {
                    break;
                }
                
            }
            game.assignChoice(choice);
            out.println();
            game.outPut();

            if(game.Game_Over == true)
            {
                System.out.print("\nDo you want to play again? (Y/N): ");
                menuChoice = in.next().charAt(0);
                menuChoice = Character.toUpperCase(menuChoice);

                while(menuChoice != YES && menuChoice != NO)
                {
                    System.out.print("\nInvalid choice. Please enter Y or N: ");
                    menuChoice = in.next().charAt(0);
                    menuChoice = Character.toUpperCase(menuChoice);
                }
                if(menuChoice == YES)
                {
                    game.resetBoard();
                    game.outPut();
                }
                else if(menuChoice == NO)
                {
                    game.outputResults();
                    game.resetBoard();
                    game.write_to_file(" WRITE THE PATH FILE HERE");
                    System.out.println("Game Results Saved to file.");

                    System.out.print("Do you want to see the past games? (Y/N): ");
                    menuChoice = in.next().charAt(0);
                    menuChoice = Character.toUpperCase(menuChoice);
                    while(menuChoice != YES && menuChoice != NO)
                    {
                        System.out.print("\nInvalid choice. Please enter Y or N: ");
                        menuChoice = in.next().charAt(0);
                        menuChoice = Character.toUpperCase(menuChoice);
                    }

                    switch (menuChoice) 
                    {
                        case YES: // this option can be formatted to a file as well 
                            System.out.println("\nPast games:\n\n");
                            for(var out : game.pastGames)
                            {
                                for(var i = 0; i < game.ROW; i++)
                                {
                                    for(var j = 0; j < game.COL; j++)
                                    {
                                        System.out.print(out[i][j] + " ");
                                    }
                                    System.out.println();
                                }
                                System.out.println();
                            }
                            break;

                        case NO:
                            System.out.println("Thanks for playing!");
                            break;

                    }

                    in.close();
                    break;
                }
            }

        }while(game.Game_Over == false);


    }
}



