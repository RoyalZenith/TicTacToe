package code.gaurav.models;

import code.gaurav.enums.GridState;

public class Grid {
    private int row;
    private int col;
    private Player player;

    private GridState gridState;

    public Grid(int row, int col){
        this.row = row;
        this.col = col;
        this.gridState= GridState.EMPTY;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GridState getGridState() {
        return gridState;
    }

    public void setGridState(GridState gridState) {
        this.gridState = gridState;
    }
}
