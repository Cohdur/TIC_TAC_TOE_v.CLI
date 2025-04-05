
public class Player
{
    private char symbol;
    private char symbol_2;

    private char start_player;
    private char assign_winner;

    private int winCount_1 = 0;
    private int winCount_2 = 0;
    private int lossCount_1 = 0;
    private int lossCount_2 = 0;
    private int DRAWCOUNT = 0;

    /*
     * Constructor to initialize the player symbols.
     * @param symbol The symbol for player 1 (e.g., 'X')
     */

    Player(char symbol, char symbol_2)
    {
        this.symbol = symbol;
        this.symbol_2 = symbol_2;
    }


    void assign_start_player(char start_player)
    {
        this.start_player = start_player;
    }

    /*
     * Method to check if the current player is the starting player.
     * @return true if the current player is the starting player, false otherwise.
     */
    boolean assign_start_player()
    {
        if(start_player == symbol)
        {
            return true;
        }
        return false;
    }

    void won(char player)
    {
        if(player == symbol)
        {
            assign_winner = symbol;
            winCount_1++;
            lossCount_2++;
        }
        else if(player == symbol_2)
        {
            assign_winner = symbol_2;
            winCount_2++;
            lossCount_1++;
        }
        else if(player =='\n')
        {
            assign_winner = '\n';
            DRAWCOUNT++;
        }
    }
    
    //  Getters
    final char getAssignWinner()
    {
        return assign_winner;
    }
    final char getStartPlayer()
    {
        return start_player;
    }
    final char getSymbol_1()
    {
        return symbol;
    }
    final char getSymbol_2()
    {
        return symbol_2;
    }

    final int GetWinCount_1()
    {
        return winCount_1;
    }
    final int GetWinCount_2()
    {
        return winCount_2;
    }
    final int GetLossCount_1()
    {
        return lossCount_1;
    }
    final int GetLossCount_2()
    {
        return lossCount_2;
    }

    final int GetDrawCount()
    {
        return DRAWCOUNT;
    }

}