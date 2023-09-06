package code.gaurav.models;

import code.gaurav.enums.GridState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private List<List<Grid>> board;
    List<HashMap<Character,Integer>> row;
    List<HashMap<Character,Integer>> col;
    List<HashMap<Character,Integer>> diagonal;
    public Board(int dimension){
        board = new ArrayList<>();
        int i=0;
        for(i=0;i<dimension;i++){
            this.board.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                this.board.get(i).add(new Grid(i,j));

            }
        }
        row = new ArrayList<>();
        col = new ArrayList<>();
        diagonal = new ArrayList<>();
        for(i=0;i<board.size();i++){
            row.add(new HashMap<>());
            col.add(new HashMap<>());
            if(i<2){
                diagonal.add(new HashMap<>());
                diagonal.add(new HashMap<>());
            }
        }
    }
    public List<List<Grid>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Grid>> board) {
        this.board = board;
    }

    public List<HashMap<Character, Integer>> getRow() {
        return row;
    }

    public void setRow(List<HashMap<Character, Integer>> row) {
        this.row = row;
    }

    public List<HashMap<Character, Integer>> getCol() {
        return col;
    }

    public void setCol(List<HashMap<Character, Integer>> col) {
        this.col = col;
    }

    public List<HashMap<Character, Integer>> getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(List<HashMap<Character, Integer>> diagonal) {
        this.diagonal = diagonal;
    }
}
