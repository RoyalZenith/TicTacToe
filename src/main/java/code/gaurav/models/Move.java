package code.gaurav.models;

public class Move {
    private Player player;
    private Grid grid;

    public Move(Player player, Grid grid){
        this.player = player;
        this.grid = grid;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
