package game;

import model.Monster;
import model.Player;

public class Game {
    private Player player;
    private Monster monster;

    public Game(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public String startGame() {
        String whoWin;
        while (player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            if (monster.isAlive()) {
                monster.attack(player);
            }
            player.heal();
            System.out.println();
        }

        if (player.isAlive()) {
            whoWin = "Выиграл игрок";
        } else {
            whoWin = "Выиграл монстр";
        }
        return whoWin;
    }
}
