package code.gaurav.models;

import code.gaurav.enums.PlayerType;

public class Player {
    String name;
    char symbol;
    PlayerType playerType;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
        this.playerType = PlayerType.HUMAN;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
