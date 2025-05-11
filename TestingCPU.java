import static org.junit.jupiter.api.Assertions.assertTrue; 
import org.junit.jupiter.api.Test;

public class TestingCPU {
    
    @Test
    public void testPlayerCPU() {
        CPU game = new CPU('X', 'O'); // Create a new game instance

        game.setCPUSymbol('X'); // Set CPU symbol

        assertTrue(game.getCPUSymbol() == 'X'); 
        assertTrue(game.getOtherSymbol() == 'O'); 
    }

}
