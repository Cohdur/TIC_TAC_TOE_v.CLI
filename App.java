import static java.lang.System.*;
import java.util.Scanner;
import java.io.IOException;
 
 public class App extends CPU // modified from Game file
{
    public App(char playerSymbol, char playerSymbol_2)
    {
        super(playerSymbol, playerSymbol_2);
    }

    public static void main(String[] args) throws IOException
    {
        final char YES = 'Y';
        final char NO = 'N';

        CPU game = new CPU('x', 'o'); // modified from Game file
        Scanner in = new Scanner(System.in);

        System.out.println("Choose game mode: ");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs CPU");
        System.out.println("3. CPU vs Human");
        System.out.print("Enter your choice (1 or 3): ");

        String menuChoice;
        char menuChoiceChar;
        
        String game_mode_choice = in.nextLine();
        while(game_mode_choice.length() > 1 || game_mode_choice.charAt(0) < '1' || game_mode_choice.charAt(0) > '3')
        {
            System.out.println("Invalid choice. Please enter 1 or 3.");

            game_mode_choice = in.nextLine();
            
        }

        int game_mode_choice_INT = Integer.parseInt(game_mode_choice);
        switch(game_mode_choice_INT) 
        {
        // Human vs Human
        case 1:

        
        System.out.println("Welcome to Tic Tac Toe!");
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

            String choice = in.nextLine();
            while(choice.length() > 1 || choice.charAt(0) < '1' || choice.charAt(0) > '9')
            {
                System.out.println("Invalid choice. Please enter one number between 1 and 9.");

                out.println();
                game.outPut();
                choice = in.nextLine();
                
            }

            try 
            {
                int choice_INT = Integer.parseInt(choice);
                game.assignChoice(choice_INT);

            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }

            out.println();
            game.outPut();

            if(game.Game_Over == true)
            {
                game.outputResults();
                out.println();
                System.out.print("\nDo you want to play again? (Y/N): ");

                menuChoice = in.nextLine();
                while(menuChoice.length() > 1)
                {
                    out.println("Only a single letter Y/y or N/n");
                    menuChoice = in.nextLine();
                }

                menuChoiceChar = menuChoice.charAt(0);
                menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                
                while(menuChoiceChar != YES && menuChoiceChar != NO)
                {
                    System.out.print("\nInvalid choice. Please enter Y or N: ");

                    menuChoice = in.nextLine();
                    while(menuChoice.length() > 1)
                    {
                        out.println("Only a single letter Y/y or N/n");
                        menuChoice = in.nextLine();
                    }

                    menuChoiceChar = menuChoice.charAt(0);
                    menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                    
                }
                if(menuChoiceChar == YES)
                {
                    game.resetBoard();
                    game.outPut();
                }
                else if(menuChoiceChar == NO)
                {
                    game.outputResults();
                    game.resetBoard();
                    game.write_to_file("Game_Results_Save.txt");
                    System.out.println("Game Results Saved to file.");

                    System.out.print("Do you want to see the past games? (Y/N): ");

                    menuChoice = in.nextLine();
                    while(menuChoice.length() > 1)
                    {
                        out.println("Only a single letter Y/y or N/n");
                        menuChoice = in.nextLine();
                    }

                    menuChoiceChar = menuChoice.charAt(0);
                    menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                    
                    while(menuChoiceChar != YES && menuChoiceChar != NO)
                    {
                        System.out.print("\nInvalid choice. Please enter Y or N: ");

                        menuChoice = in.nextLine();
                        while(menuChoice.length() > 1)
                        {
                            out.println("Only a single letter Y/y or N/n");
                            menuChoice = in.nextLine();
                        }

                        menuChoiceChar = menuChoice.charAt(0);
                        menuChoiceChar = Character.toUpperCase(menuChoiceChar);

                    }

                    switch (menuChoiceChar) 
                    {
                        case YES: // this option can be formatted to a file as well

                        int ROW = 3; // this was modified from Game file
                        int COL = 3; // this was modified from Game file
                            System.out.println("\nPast games:\n\n");
                            for(var out : game.pastGames)
                            {
                                for(var i = 0; i < ROW/*game.ROW */; i++)
                                {
                                    for(var j = 0; j < COL/*game.COL */; j++)
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
        break;

        // Human vs CPU 
        case 2 : 
        //game.set_CPU_Start(false); // initially set to false omit after testing proves to be true
        game.setCPUSymbol(game.getSymbol_2());

        game.set_CPU_Turn(false);

        System.out.println("Welcome to Tic Tac Toe!");
        game.createBoard();
        game.outPut();

        do
        { 
            if(game.GetLossCount_1() > 0  || game.GetWinCount_1() > 0 && game.getAssignWinner() == game.getSymbol_1() )
            {
                game.set_CPU_Start(true); 
                game.assign_choice_CPU(game.getSymbol_2(),game.CPUmove());
                out.println();
                game.outPut();
            }
            
            
            
            if(game.get_CPU_Turn() == false)
            {

            System.out.printf("Player %c, Enter choice (1-9): ", game.getSymbol_1());
            String choice = in.nextLine();

            while(choice.length() > 1 || choice.charAt(0) < '1' || choice.charAt(0) > '9')
            {
                System.out.println("Invalid choice. Please enter one number between 1 and 9.");

                out.println();
                game.outPut();
                choice = in.nextLine();
            }

            try 
            {
                int choice_INT = Integer.parseInt(choice);
                game.assign_choice_CPU(game.getSymbol_1(),choice_INT);
                // How come this is not working? 
                // the error should toggle to true if the player chooses a number that is already taken
                if(game.getCPU_Error() == true) 
                {
                    out.println(game.getCPU_Error());
                    game.set_CPU_Turn(false);
                    choice = in.nextLine();
                    choice_INT = Integer.parseInt(choice);
                    game.assign_choice_CPU(game.getSymbol_1(),choice_INT);
                }
                
                if(game.getCPU_Error() == false)
                {
                   game.set_CPU_Turn(true); 
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }
            out.println();
            game.outPut();
        }//here 
        if(game.get_CPU_Turn() == true)
        {
            
            game.assign_choice_CPU(game.getSymbol_2(),game.CPUmove());
            while(game.getCPU_Error() == true) 
            {
                game.assign_choice_CPU(game.getSymbol_2(),game.CPUmove());
                /*
                 * 
                 if(game.getCPU_Error() == false)
                 {
                    break;
                }
                */ //uneseccary
                
            }

            out.println();
            game.outPut();
            game.set_CPU_Start(false);
          
        }

            if(game.Game_Over == true)
            {
                game.outputResults();
                out.println();
                System.out.print("\nDo you want to play again? (Y/N): ");

                menuChoice = in.nextLine();
                while(menuChoice.length() > 1)
                {
                    out.println("Only a single letter Y/y or N/n");
                    menuChoice = in.nextLine();
                }

                menuChoiceChar = menuChoice.charAt(0);
                menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                
                while(menuChoiceChar != YES && menuChoiceChar != NO)
                {
                    System.out.print("\nInvalid choice. Please enter Y or N: ");

                    menuChoice = in.nextLine();
                    while(menuChoice.length() > 1)
                    {
                        out.println("Only a single letter Y/y or N/n");
                        menuChoice = in.nextLine();
                    }

                    menuChoiceChar = menuChoice.charAt(0);
                    menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                    
                }
                if(menuChoiceChar == YES)
                {
                    game.resetBoard();
                    game.outPut();
                }
                else if(menuChoiceChar == NO)
                {
                    game.outputResults();
                    game.resetBoard();
                    game.write_to_file("Game_Results_Save.txt");
                    System.out.println("Game Results Saved to file.");

                    System.out.print("Do you want to see the past games? (Y/N): ");

                    menuChoice = in.nextLine();
                    while(menuChoice.length() > 1)
                    {
                        out.println("Only a single letter Y/y or N/n");
                        menuChoice = in.nextLine();
                    }

                    menuChoiceChar = menuChoice.charAt(0);
                    menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                    
                    while(menuChoiceChar != YES && menuChoiceChar != NO)
                    {
                        System.out.print("\nInvalid choice. Please enter Y or N: ");

                        menuChoice = in.nextLine();
                        while(menuChoice.length() > 1)
                        {
                            out.println("Only a single letter Y/y or N/n");
                            menuChoice = in.nextLine();
                        }

                        menuChoiceChar = menuChoice.charAt(0);
                        menuChoiceChar = Character.toUpperCase(menuChoiceChar);

                    }

                    switch (menuChoiceChar) 
                    {
                        case YES: // this option can be formatted to a file as well

                        int ROW = 3; // this was modified from Game file
                        int COL = 3; // this was modified from Game file
                            System.out.println("\nPast games:\n\n");
                            for(var out : game.pastGames)
                            {
                                for(var i = 0; i < ROW/*game.ROW */; i++)
                                {
                                    for(var j = 0; j < COL/*game.COL */; j++)
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

        break;

        case 3 :
        game.set_CPU_Start(true);
        game.set_CPU_Turn(true);
        game.setCPUSymbol(game.getSymbol_1());
        
        System.out.println("Welcome to Tic Tac Toe!");
        game.createBoard();
        game.outPut();

        do
        {
            if(/*game.GetLossCount_1() > 0  || game.GetWinCount_1() > 0 &&*/ 
            game.getAssignWinner() == game.getSymbol_1() )
            {
                game.set_CPU_Start(true); 
                game.assign_choice_CPU(game.getSymbol_1(),game.CPUmove());
                out.println();
                game.outPut();
            }

            if(game.get_CPU_Turn() == false)
            {

            System.out.printf("Player %c, Enter choice (1-9): ", game.getSymbol_2());
            String choice = in.nextLine();
            while(choice.length() > 1 || choice.charAt(0) < '1' || choice.charAt(0) > '9')
            {
                System.out.println("Invalid choice. Please enter one number between 1 and 9.");
                if(!(choice.length() > 1) && !(choice.charAt(0) < '1') || !(choice.charAt(0) > '9'))
                {
                    break;
                }
                out.println();
                game.outPut();
                
                choice = in.nextLine();
                
            }

            try 
            {
                int choice_INT = Integer.parseInt(choice);
                game.assign_choice_CPU(game.getSymbol_2(),choice_INT);
                game.set_CPU_Turn(true);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }

            out.println();
            game.outPut();
        }//here 
        if(game.get_CPU_Turn() == true)
        
        {
            game.assign_choice_CPU(game.getSymbol_1(),game.CPUmove());
            while(game.getCPU_Error() == true) // check while instead of if
            {
                game.assign_choice_CPU(game.getSymbol_1(),game.CPUmove());
                /*
                 * 
                 if((game.getCPU_Error() == false))
                 {
                    break; //optional 
                }
                */ //uneseccary
            }
            out.println();
            game.outPut();
            game.set_CPU_Turn(false);
        }

            if(game.Game_Over == true)
            {
                game.outputResults();
                out.println();

                System.out.print("\nDo you want to play again? (Y/N): ");

                menuChoice = in.nextLine();
                while(menuChoice.length() > 1)
                {
                    out.println("Only a single letter Y/y or N/n");
                    menuChoice = in.nextLine();
                }

                menuChoiceChar = menuChoice.charAt(0);
                menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                
                while(menuChoiceChar != YES && menuChoiceChar != NO)
                {
                    System.out.print("\nInvalid choice. Please enter Y or N: ");

                    menuChoice = in.nextLine();
                    while(menuChoice.length() > 1)
                    {
                        out.println("Only a single letter Y/y or N/n");
                        menuChoice = in.nextLine();
                    }

                    menuChoiceChar = menuChoice.charAt(0);
                    menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                    
                }
                if(menuChoiceChar == YES)
                {
                    game.resetBoard();
                    game.outPut();
                }
                else if(menuChoiceChar == NO)
                {
                    game.outputResults();
                    game.resetBoard();
                    game.write_to_file("Game_Results_Save.txt");
                    System.out.println("Game Results Saved to file.");

                    System.out.print("Do you want to see the past games? (Y/N): ");

                    menuChoice = in.nextLine();
                    while(menuChoice.length() > 1)
                    {
                        out.println("Only a single letter Y/y or N/n");
                        menuChoice = in.nextLine();
                    }

                    menuChoiceChar = menuChoice.charAt(0);
                    menuChoiceChar = Character.toUpperCase(menuChoiceChar);
                    
                    while(menuChoiceChar != YES && menuChoiceChar != NO)
                    {
                        System.out.print("\nInvalid choice. Please enter Y or N: ");

                        menuChoice = in.nextLine();
                        while(menuChoice.length() > 1)
                        {
                            out.println("Only a single letter Y/y or N/n");
                            menuChoice = in.nextLine();
                        }

                        menuChoiceChar = menuChoice.charAt(0);
                        menuChoiceChar = Character.toUpperCase(menuChoiceChar);

                    }

                    switch (menuChoiceChar) 
                    {
                        case YES: // this option can be formatted to a file as well

                        int ROW = 3; // this was modified from Game file
                        int COL = 3; // this was modified from Game file
                            System.out.println("\nPast games:\n\n");
                            for(var out : game.pastGames)
                            {
                                for(var i = 0; i < ROW/*game.ROW */; i++)
                                {
                                    for(var j = 0; j < COL/*game.COL */; j++)
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

        break;


    }//switch end 

    } 
}



