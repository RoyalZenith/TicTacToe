package code.gaurav.services;

import code.gaurav.models.Bot;
import code.gaurav.models.Player;

import java.util.List;
import java.util.Scanner;

public class PlayerService {
    Scanner sc;

    public PlayerService(){
        sc = new Scanner(System.in);
    }


    public void onBoardPlayers(int noOfPlayersToOnboard, List<Player> players) {
        System.out.println("Do you want to play with BOT: y/n");
        String isBotInclude = sc.next();
        if("Y".equalsIgnoreCase(String.valueOf(isBotInclude.charAt(0)))){
            noOfPlayersToOnboard--;
            players.add(new Bot("John",'#'));
            System.out.println("John will play with you having symbol '#'");
        }
        System.out.println("Enter "+noOfPlayersToOnboard + " player/s details");
        for(int i=0;i<noOfPlayersToOnboard;i++){
            System.out.println("Enter player name :");
            String name = sc.next();
            System.out.println(name+", Please enter your game symbol :");
            String symbol = sc.next();
            players.add(new Player(name,symbol.charAt(0)));
        }
    }
}
