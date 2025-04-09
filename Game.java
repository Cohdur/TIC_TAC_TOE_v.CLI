import java.util.ArrayList;
import static java.lang.System.*;
import java.io.FileWriter;
import java.io.IOException;

public class Game extends Player
{
    protected ArrayList<char[][]> pastGames = new ArrayList<char[][]>(); // keep track of old boards??

    boolean Game_Over = false;
    boolean Starting_Player_Turn = true;

    final int ROW = 3;
    final int COL = 3;
    

    private char[][] board = new char[ROW][COL];

    /*
     * USED FOR TESTING PURPOSES ONLY
     */
    boolean isGameOver()
    {
        return Game_Over;
    }
    //////////////////////////////////
    
    
    public Game(char PlayerSymbol, char PlayerSymbol_2) 
    { 
        super(PlayerSymbol, PlayerSymbol_2); 
    }


    void write_to_file(String fileName) throws IOException
    {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write("Player: " + getSymbol_1() + " Won: " + GetWinCount_1() + " / Loss: " + GetLossCount_1() + "\n");
        writer.write("Player: " + getSymbol_2() + " Won: " + GetWinCount_2() + " / Loss: " + GetLossCount_2() + "\n");
        writer.write("Draw Count: " + GetDrawCount() + "\n\n\n");
        writer.close();
    }


    void createBoard()
    {
        char n = '1';

        assign_start_player(getSymbol_1());

        for(var itr = 0; itr < ROW; itr++)
        {
            for(var itr2 = 0; itr2 < COL; itr2++)
            {
                board[itr][itr2] = n;
                n++;
            }
        }
    }

    void saveGameResult() 
    {
        
        char[][] boardCopy = new char[ROW][COL];
        for (int i = 0; i < ROW; i++) 
        {
            System.arraycopy(board[i], 0, boardCopy[i], 0, COL);
        }
    
        pastGames.add(boardCopy);
    }

    void resetBoard()
    {
        saveGameResult();

        if(getAssignWinner() == getSymbol_1())
        {
            assign_start_player(getSymbol_2());
        }
        else if(getAssignWinner() == getSymbol_2())
        {
            assign_start_player(getSymbol_1());
        }
        else if(getAssignWinner() == '\n')
        {
            assign_start_player(getSymbol_1());
        }


        char n = '1';
        for(var itr = 0; itr < ROW; itr++)
        {
            for(var itr2 = 0; itr2 < COL; itr2++)
            {
                board[itr][itr2] = n;
                n++;
            }
        }

        Game_Over = false;
    }

    void Player_Has_Won()
    {
        char A = getSymbol_1();
        char B = getSymbol_2();

        if(board[0][0] == A && board[0][0] == board[0][1] && board[0][1] == board[0][2])
        {
            won(A);
            Game_Over = true;
        }

        if(board[0][0] == B && board[0][0] == board[0][1] && board[0][1] == board[0][2])
        {
           won(B);
            Game_Over = true;
        }

        if(board[1][0] == A && board[1][0] == board[1][1] && board[1][1] == board[1][2])
        {
           won(A);
           Game_Over = true;
        }

        if(board[1][0] == B && board[1][0] == board[1][1] && board[1][1] == board[1][2])
        {
            won(B);
            Game_Over = true;
        }

        if(board[2][0] == A && board[2][0] == board[2][1] && board[2][1] == board[2][2])
        {
           won(A);
           Game_Over = true;
        }

        if(board[2][0] == B && board[2][0] == board[2][1] && board[2][1] == board[2][2])
        {
           won(B);
           Game_Over = true;
        }

        if(board[0][0] == A && board[0][0] == board[1][0] && board[1][0] == board[2][0])
        {
            won(A);
            Game_Over = true;
        }

        if(board[0][0] == B && board[0][0] == board[1][0] && board[1][0] == board[2][0])
        {
            won(B);
            Game_Over = true;
        }

        if(board[0][1] == A && board[0][1] == board[1][1] && board[1][1] == board[2][1])
        {
            won(A);
            Game_Over = true;
        }

        if(board[0][1] == B && board[0][1] == board[1][1] && board[1][1] == board[2][1])
        {
            won(B);
            Game_Over = true;
        }

        if(board[0][2] == A && board[0][2] == board[1][2] && board[1][2] == board[2][2])
        {
            won(A);
            Game_Over = true;
        }

        if(board[0][2] == B && board[0][2] == board[1][2] && board[1][2] == board[2][2])
        {
            won(B);
            Game_Over = true;
        }

        if(board[0][0] == A && board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            won(A);
            Game_Over = true;
        }

        if(board[0][0] == B && board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            won(B);
            Game_Over = true;
        }

        if(board[0][2] == A && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            won(A);
            Game_Over = true;
        }

        if(board[0][2] == B && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            won(B);
            Game_Over = true;
        }

        else
        {
            int index = 0;
            for( var check : board)
            {
                for(var check2 : check)
                {
                    index++;
                    if(check2 == getSymbol_1() || check2 == getSymbol_2())
                    {
                        if(index == 9)
                        {
                            won('\n');
                            Game_Over = true;
                        }
                    }
                    else if(check2 != getSymbol_1() && check2 != getSymbol_2())
                    {
                        break;
                    }
                }
            }
        } 
    }

    void assignChoice(int choice)
    {
            for(var itr = 0; itr < ROW; itr++)
            {
                for(var itr2 = 0; itr2 < COL; itr2++)
                {
                    if(board[itr][itr2] != getSymbol_1() && board[itr][itr2] != getSymbol_2())
                    {
                        if( (board[itr][itr2] - '0') == choice   && Starting_Player_Turn)
                        {
                            board[itr][itr2] = getSymbol_1();
                            Player_Has_Won();
                            Starting_Player_Turn = false;

                            assign_start_player(getSymbol_2());
                            
                            
                            break;
                        }
                        else if((board[itr][itr2] - '0') == choice  && !Starting_Player_Turn)
                        {
                            board[itr][itr2] = getSymbol_2();
                            Player_Has_Won();
                            Starting_Player_Turn = true;

                            assign_start_player(getSymbol_1());
                        
                            break;
                        }
                    }
                    else if((board[itr][itr2] - '0') == choice )
                    {
                        if(board[itr][itr2] == getSymbol_1() || board[itr][itr2] == getSymbol_2())
                        {
                           System.out.println("Invalid Move! Try Again.");
                           
                           break;
                        }
                    } 
                }
            }
        
    }

    void outPut()
    {
        System.out.println();

        for(var itr = 0; itr < ROW; itr++)
        {
            for(var itr2 = 0; itr2 < COL; itr2++)
            {
            
                if(itr2 == 1)
                {
                    System.out.printf("  |    %c    |  ", board[itr][itr2]);
                }
                else
                {
                    System.out.printf("     %c    ", board[itr][itr2]);
                }
            }
            if(itr == 1 || itr == 0)
            {
                System.out.println();
                System.out.println("     -------+---------+----------       ");
            }
        }

    }

    void outputResults()
    {
        System.out.println("\n\nGAME OVER - RESULTS:\n\n");
        System.out.printf("Player: %c Won: %d / Loss: %d%n%n", getSymbol_1() , GetWinCount_1() , GetLossCount_1());   
        System.out.printf("Player: %c Won: %d / Loss: %d%n%n", getSymbol_2() , GetWinCount_2() , GetLossCount_2());
        System.out.printf("Draw Count: %d%n%n", GetDrawCount());   
    }
    

}
