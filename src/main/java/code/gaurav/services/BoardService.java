package code.gaurav.services;

import code.gaurav.enums.GameState;
import code.gaurav.enums.GridState;
import code.gaurav.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BoardService {

    public void printBoard(Board board) {
        for(int i=0;i<board.getBoard().size();i++){
            for(int j=0;j<board.getBoard().size();j++){
                Grid currGrid = board.getBoard().get(i).get(j);
                if(GridState.EMPTY.equals(currGrid.getGridState())){
                    System.out.print("| ");
                }else{
                    System.out.print("|"+currGrid.getPlayer().getSymbol());
                }
            }
            System.out.println("|");
        }
    }
    public void getRandomEmptyCellAndFill(Game game) {
        Board board = game.getBoard();

        List<Grid> gridList = new ArrayList<>();
        for(int i=0;i<board.getBoard().size();i++){
            for(int j=0;j<board.getBoard().size();j++){
                if(board.getBoard().get(i).get(j).getGridState().name().equalsIgnoreCase(GridState.EMPTY.name())){
                    gridList.add(board.getBoard().get(i).get(j));
                }
            }
        }
        int min = 0;
        int max = gridList.size()-1;
        int i = min + (int)(Math.random() * ((max - min) + 1));

        int col = gridList.get(i).getCol();
        int row = gridList.get(i).getRow();
        Grid currGrid = game.getBoard().getBoard().get(row).get(col);
        Player currPlayer = game.getPlayers().get(game.getCurrPlayerIdx());
        currGrid.setPlayer(currPlayer);
        currGrid.setGridState(GridState.FILLED);
        //add move
        game.getMoves().add(new Move(currPlayer,currGrid));
        return;

    }

    public void updateAndCheckGameStatus(Game game){
        List<HashMap<Character,Integer>> row = game.getBoard().getRow();
        List<HashMap<Character,Integer>> col = game.getBoard().getCol();
        List<HashMap<Character,Integer>> diagonal = game.getBoard().getDiagonal();
        Board board = game.getBoard();

        int moveSize = game.getMoves().size()-1;
        Move currMove = game.getMoves().get(moveSize);

        char symbol = currMove.getPlayer().getSymbol();

        int rowToChecked = currMove.getGrid().getRow();
        int colToChecked = currMove.getGrid().getCol();

        row.get(rowToChecked).put(symbol,row.get(rowToChecked).get(symbol)==null?1:row.get(rowToChecked).get(symbol)+1);
        col.get(colToChecked).put(symbol,col.get(colToChecked).get(symbol)==null?1:col.get(colToChecked).get(symbol)+1);
        if(rowToChecked == colToChecked){
            // diagonal 1
            diagonal.get(0).put(symbol,diagonal.get(0).get(symbol)==null?1:diagonal.get(0).get(symbol)+1);
            if(diagonal.get(0).get(symbol) == game.getDimension()){
                game.setGameState(GameState.ENDED);
                game.setWinner(game.getPlayers().get(game.getCurrPlayerIdx()));
                return;
            }
        }
        if(rowToChecked+colToChecked == game.getDimension()-1){
            // diagonal 2
            diagonal.get(1).put(symbol,diagonal.get(1).get(symbol)==null?1:diagonal.get(1).get(symbol)+1);
            if(diagonal.get(1).get(symbol) == game.getDimension()){
                game.setGameState(GameState.ENDED);
                game.setWinner(game.getPlayers().get(game.getCurrPlayerIdx()));
                return;
            }
        }
        // row and column check
        if(row.get(rowToChecked).get(symbol) == game.getDimension() || col.get(colToChecked).get(symbol) == game.getDimension()){
            game.setGameState(GameState.ENDED);
            game.setWinner(game.getPlayers().get(game.getCurrPlayerIdx()));
            return;
        }


    }
}
