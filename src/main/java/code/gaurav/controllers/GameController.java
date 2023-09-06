package code.gaurav.controllers;

import code.gaurav.enums.GridState;
import code.gaurav.exceptions.InvalidGridInput;
import code.gaurav.exceptions.InvalidMoveException;
import code.gaurav.models.*;
import code.gaurav.services.BoardService;
import code.gaurav.services.PlayerService;

import java.util.*;

public class GameController {
    Scanner sc;
    int dimension;
    List<Player> players;
    String isBotInclude;
    Map<Character, Integer> mp;

    BoardService boardService;
    ValidateController validateController;

    public GameController() {
        this.sc = new Scanner(System.in);
        this.dimension = 3;
        this.players = new ArrayList<>();
        this.isBotInclude = "N";
        this.mp = new HashMap<>();
        validateController = new ValidateController();
        boardService = new BoardService();
    }
    public void takePlayerInput() {
        System.out.println("Enter the valid Game board dimension");
        this.dimension  = sc.nextInt();
        onBoardPlayers(dimension-1);
    }

    private void onBoardPlayers(int noOfPlayersToOnboard) {
        PlayerService playerService = new PlayerService();
        playerService.onBoardPlayers(noOfPlayersToOnboard,players);
        System.out.println("Please Wait, your game is starting...");
    }

    public Game BuildGame() {
        return Game.getBuilder().setDimension(this.dimension).setPlayers(this.players).build();
    }

    public void displayBoard(Game game) {
        boardService.printBoard(game.getBoard());
    }

    public void takeMoveInput(Game game) {
        Player player = players.get(game.getCurrPlayerIdx());
        int[] arr = takeGridInput(player);
        try {
            validateController.validateMove(arr[0],arr[1],game);
        } catch (InvalidMoveException | InvalidGridInput e) {
            takeMoveInput(game);
            return;
        }
        //fill that grid
        Grid grid = game.getBoard().getBoard().get(arr[0]).get(arr[1]);
        grid.setGridState(GridState.FILLED);
        grid.setPlayer(player);
        game.getMoves().add(new Move(player,grid));
    }
    public int[] takeGridInput(Player player){
        int[] arr = new int[2];
        System.out.println(player.getName()+", Please Enter row : ");
        arr[0] = sc.nextInt();
        arr[0]--;

        System.out.println(player.getName()+", Please Enter col : ");
        arr[1] = sc.nextInt();
        arr[1]--;
        return arr;
    }

    public void getRandomEmptyCellAndFill(Game game) {
        boardService.getRandomEmptyCellAndFill(game);
    }

    public void updateGame(Game game) {
        boardService.updateAndCheckGameStatus(game);
    }
}
