package code.gaurav.controllers;

import code.gaurav.enums.GridState;
import code.gaurav.exceptions.*;
import code.gaurav.models.Game;
import code.gaurav.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateController {

        public void validatePlayerSymbol(List<Player> players) throws InvalidDuplicatePlayerSymbolException {
            Map<Character, Integer> mp = new HashMap<>();
            for(int i=0;i<players.size();i++){
                Character ch =  players.get(i).getSymbol();
                if(mp.get(ch) == null){
                    mp.put(ch,i+1);
                }else{
                    String currPlayerName = players.get(i).getName();
                    String prevPlayerName = players.get(mp.get(ch)-1).getName();
                    System.out.println(currPlayerName+", This Symbol "+ ch +" already occupied by "+ prevPlayerName);
                    throw new InvalidDuplicatePlayerSymbolException("Each player Symbol Should be Unique");
                }
            }
        }

        public void validatePlayer(List<Player> players, int dimension) throws InvalidNoOfPlayerException {
            if(players.size() != dimension-1){
                throw new InvalidNoOfPlayerException("No of Players should be one less than dimension");
            }
        }

        public void validateDimension(int dimension) throws InvalidDimentionException {
            if(dimension < 3){
                throw new InvalidDimentionException("Dimensions is Invalid");
            }

        }

    public void validateMove(int row, int col, Game game) throws InvalidMoveException, InvalidGridInput {
            int size = game.getDimension();
            if(row < 0 || row>=size || col<0 || col>=size){
                System.out.println("Invalid Move, Please enter valid moves, your game board size is "+game.getDimension());
                throw new InvalidMoveException("Invalid move");
            }
            if(game.getBoard().getBoard().get(row).get(col).getGridState() != GridState.EMPTY){
                throw new InvalidGridInput("Invalid Grid input");
            }
    }
}
