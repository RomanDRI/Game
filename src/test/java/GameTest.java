import game.Game;
import model.Monster;
import model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {


    @Test
    void winTest(){
        Player player = new Player("Игрок", 14, 20, 100, 5, 11);
        Monster monster = new Monster("Монстр", 11, 18, 180, 6, 14);
        Game game = new Game(player, monster);
        Assertions.assertEquals(game.startGame(), "Выиграл игрок");
    }


}
