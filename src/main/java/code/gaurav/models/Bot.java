package code.gaurav.models;

import code.gaurav.enums.PlayerType;

public class Bot extends Player{
//    private BotDifficultyLevel botDifficultyLevel;
    public Bot(String name, char symbol) {
        super(name, symbol);
        this.playerType = PlayerType.BOT;
    }
}
