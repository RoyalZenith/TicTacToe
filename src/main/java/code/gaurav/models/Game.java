package code.gaurav.models;

import code.gaurav.controllers.ValidateController;
import code.gaurav.enums.GameState;
import code.gaurav.exceptions.InvalidDimentionException;
import code.gaurav.exceptions.InvalidDuplicatePlayerSymbolException;
import code.gaurav.exceptions.InvalidNoOfPlayerException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private List<Move> moves;
    private List<Player> players;
    private Board board;

    private Player winner;

    private GameState gameState;

    private int currPlayerIdx;
    private int dimension;
    private Game(){};

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getCurrPlayerIdx() {
        return currPlayerIdx;
    }

    public void setCurrPlayerIdx(int currPlayerIdx) {
        this.currPlayerIdx = currPlayerIdx;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;

        public Builder(){

        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build() {
            //validation
            ValidateController validateController = new ValidateController();
            //validate dimension
            try {
                validateController.validateDimension(dimension);
            } catch (InvalidDimentionException e) {
                System.out.println(e.getMessage());
            }
            //validate player
            try {
                validateController.validatePlayer(players,dimension);
            } catch (InvalidNoOfPlayerException e) {
                System.out.println(e.getMessage());
            }

            //validate Player Symbols
            try {
                validateController.validatePlayerSymbol(players);
            } catch (InvalidDuplicatePlayerSymbolException e) {
                System.out.println(e.getMessage());
            }


            //Create Game class object and return
            Game game = new Game();
            game.gameState =  GameState.IN_PROGRESS;
            Collections.shuffle(this.players);
            game.players =this.players;
            game.board = new Board(this.dimension);
            game.moves = new ArrayList<>();
            game.currPlayerIdx = 0;
            game.dimension = this.dimension;
            return game;

        }
    }
}
