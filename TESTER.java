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


    
}
