package code.gaurav;

import code.gaurav.controllers.GameController;
import code.gaurav.enums.GameState;
import code.gaurav.enums.PlayerType;
import code.gaurav.models.Game;
import code.gaurav.models.Player;

public class TicTacToe {
    public static void main(String args[]) {

        System.out.println("Welcome to Tic-tac-toe Game");
        System.out.println("We need some input to Build the Game");
        GameController gameController = new GameController();
        gameController.takePlayerInput();
        Game game = gameController.BuildGame();
        System.out.println("This is your Board to Play your moves : ");
        gameController.displayBoard(game);
        //start taking input for board
        int size=game.getDimension()-1;
        while(GameState.IN_PROGRESS.equals(game.getGameState())){
            Player player = game.getPlayers().get(game.getCurrPlayerIdx());
            if(player.getPlayerType() == PlayerType.HUMAN) {
                System.out.println(player.getName() + ", Your turn now...");
                gameController.takeMoveInput(game);
            }else{
                System.out.println("Your Bot is playing their turn...");
                gameController.getRandomEmptyCellAndFill(game);
            }
            gameController.updateGame(game);
            gameController.displayBoard(game);
            game.setCurrPlayerIdx((game.getCurrPlayerIdx()+1)%size);
        }
        if(GameState.DRAWN.equals(game.getGameState())){
            System.out.println("Game is Draw.");
        }else if(GameState.ENDED.equals(game.getGameState())){
            System.out.println("Congratulations " + game.getWinner().getName() + ",  You are the Winner of the Game");
        }

//        System.out.println("Do you want to play again: y/n");
//        String userInputForStartNewGame = new Scanner(System.in).next();
//
//        if("Y".equalsIgnoreCase(String.valueOf(userInputForStartNewGame.charAt(0)))){
//            TicTacToe.main();
//        }

    }
}