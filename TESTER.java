import static org.junit.jupiter.api.Assertions.assertTrue; // Import JUnit assertion
import org.junit.jupiter.api.Test;
public class TESTER 
{
    @Test
    public void testingWin()
    {
        Game game = new Game('x','o');
        game.createBoard();
        
        game.assignChoice(1); // W
        game.assignChoice(2);
        game.assignChoice(5); // W
        game.assignChoice(3);
        game.assignChoice(9); // W

        assertTrue(game.isGameOver(), "Game should be over after a player wins.");
    }

    @Test
    public void playerSwitch()
    {
        Game game = new Game('x','o');
        game.createBoard(); // assigned start player

        assertTrue(game.getStartPlayer() == 'x', "Is x");
        
        game.assignChoice(1); // W
        game.assignChoice(2);
        game.assignChoice(5); // W
        game.assignChoice(3);
        game.assignChoice(9); // W

        game.resetBoard();
        
        assertTrue(game.getAssignWinner() == 'x', "x won so the start plaer should be o"); // handled in won()
        assertTrue(game.getStartPlayer() == 'o', "Is o now"); 

        game.assignChoice(1); // W
        game.assignChoice(2);
        game.assignChoice(5); // W
        game.assignChoice(3);
        game.assignChoice(9); // W

        assertTrue(game.getAssignWinner() == 'o', "x won so the start plaer should be o");
        game.resetBoard();
        
        assertTrue(game.getStartPlayer() == 'x', "Is x now"); // handled in won()
    }
    
}
