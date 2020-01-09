import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;

public class SlapFace {
    private int oneScore;
    private int twoScore;
    private Card[] oneHand;
    private Card[] twoHand;
    private int cardsLeft;

    //Additional necessary variables
    Scanner input = new Scanner(System.in);
    private int onePlay, twoPlay;
    private long lastTickTime = System.currentTimeMillis();
    static boolean player1 = false;
    static boolean player2 = false;
    private String name1, name2;

    public SlapFace() {
        cardsLeft = 26;
        oneHand = new Card[cardsLeft];
        twoHand = new Card[cardsLeft];
        oneScore = 0;
        twoScore = 0;
        fillHands();
    }

    //Fill hands for each player
    private void fillHands() {
        Deck deck = new Deck();
        deck.shuffle();
        for(int i = 0; i < cardsLeft; i++){
            oneHand[i] = deck.deal();
            twoHand[i] = deck.deal();
        }
    }

    public void play() {
        //Get names
        getNames();
        
        //Do countdown
        rulesCountDown();
        
        //Welcome players, give rules, provide instructions
        welcomeScreen();
        
        //Countdown to the game
        gameCountDown();
        System.out.println("\n\u000C");
        
        //Play the game
        simulateGame();
        
        //Ouput who won overall game
        printWinner();
    }
    
    public void getNames(){
        System.out.println();
        System.out.println("=========================");
        System.out.println("=========================");
        System.out.println("= Welcome to Slap Face! =");
        System.out.println("=    (Not slapjack!)    =");
        System.out.println("=========================");
        System.out.print("Name of Player 1: ");
        name1 = input.next();
        System.out.println("=========================");
        System.out.print("Name of Player 2: ");
        name2 = input.next();
        System.out.println();
        //All caps
        name1 = name1.toUpperCase();
        name2 = name2.toUpperCase();
    }
        
    public void rulesCountDown(){
        int ctR = 10;
        while(ctR > 0){
            System.out.println("\n\u000C");
            System.out.println("=========================");
            System.out.println("=========================");
            System.out.println("= Welcome to Slap Face! =");
            System.out.println("=    (Not slapjack!)    =");
            System.out.println("=========================");
            System.out.print("Name of Player 1: " + name1);
            System.out.println("\n=========================");
            System.out.print("Name of Player 2: " + name2);
            System.out.println("\n");
            System.out.println("Rules showing up in " + ctR + " seconds");
            ctR--;
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\u000C");
    }
    
    public void welcomeScreen(){
        //Welcome people
        System.out.println("=========================");
        System.out.println("Welcome, " + name1 + " and " + name2 + ".");
        System.out.println("May the better player win.");
        System.out.println("=========================");
        
        //Print how to play
        System.out.println();
        System.out.println("=========================");
        System.out.println("=   Rules of Slapface:  =");
        System.out.println("= Each player is given  =");
        System.out.println("= a random deck. Each   =");
        System.out.println("= take turns placing a  =");
        System.out.println("= card. If a FACE CARD  =");
        System.out.println("= is played, then the   =");
        System.out.println("= player who slaps wins =");
        System.out.println("= the pile. The goal of =");
        System.out.println("= the game is to have   =");
        System.out.println("= more cards by the end.=");
        System.out.println("=========================");
        
        //Print how to slap
        System.out.println();
        System.out.println("=========================");
        System.out.println("=      How to Slap:     =");
        System.out.println("= Player 1 is left      =");
        System.out.println("= Player 2 is right     =");
        System.out.println("= P1 presses \"D\", P2    =");
        System.out.println("= presses \"L\".          =");
        System.out.println("= In the console, the   =");
        System.out.println("= faster player's letter=");
        System.out.println("= would show up first.  =");
        System.out.println("= Then press enter after=");
        System.out.println("= only one letter is in =");
        System.out.println("= the console.          =");
        System.out.println("=========================");

        System.out.println();
        System.out.println("=========================");
        System.out.println("Enter \"ready\" when you are ready");
        String pause = input.next();
    }
    
    public void gameCountDown() {
        int ctG = 15;
        System.out.println("\u000C");
        while(ctG > 0){
            System.out.println("\n\u000C");
            System.out.println("===============================================");
            System.out.println("Ready yourselves, " + name1 + " and " + name2 + ".");
            System.out.println("Game starts in " + ctG + " seconds");
            System.out.println("===============================================");
            asciiArt();
            System.out.println("===============================================");
            System.out.println("=   I hope you appreciate the ascii art >.<   =");
            System.out.println("===============================================");
            ctG--;
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public void asciiArt(){
        System.out.println("=                            _____            =");
        System.out.println("=                    _____  |K  WW|           =");
        System.out.println("=            _____  |Q  ww| |   {)|           =");
        System.out.println("=     _____ |J  ww| |   {(| |(v)%%| _____     =");
        System.out.println("=    |10 v ||   {)| |(v)%%| | v%%%||A_ _ |    =");
        System.out.println("=    |v v v||(v)% | | v%%%| |_%%%>||( v )|    =");
        System.out.println("=    |v v v|| v % | |_%%%O|        | \\ / |    =");
        System.out.println("=    |v v v||__%%[|                |  .  |    =");
        System.out.println("=    |___0I|                       |____V|    =");
        System.out.println("===============================================");
        System.out.println("=                   __                        =");
        System.out.println("=             _..-''--'----_.                 =");
        System.out.println("=           ,''.-''| .---/ _`-._              =");
        System.out.println("=         ,' \\ \\  ;| | ,/ / `-._`-.           =");
        System.out.println("=       ,' ,',\\ \\( | |// /,-._  / /           =");
        System.out.println("=       ;.`. `,\\ \\`| |/ / |   )/ /            =");
        System.out.println("=      / /`_`.\\_\\ \\| /_.-.'-''/ /             =");
        System.out.println("=     / /_|_:.`. \\ |;'`..')  / /              =");
        System.out.println("=     `-._`-._`.`.;`.\\  ,'  / /               =");
        System.out.println("=         `-._`.`/    ,'-._/ /                =");
        System.out.println("=           : `-/     \\`-.._/                 =");
        System.out.println("=           |  :      ;._ (                   =");
        System.out.println("=           :  |      \\  ` \\                  =");
        System.out.println("=            \\         \\   |                  =");
        System.out.println("=             :        :   ;                  =");
        System.out.println("=             |           /                   =");
        System.out.println("=             ;         ,'                    =");
        System.out.println("=            /         /                      =");
        System.out.println("=           /         /                       =");
        System.out.println("=                    / Ascii art credits: SSt =");
    }
    
    public void simulateGame(){
        //Print start
        System.out.println("===============================================");
        System.out.println("= The game begins! Player 1 will play first!  =");
        System.out.println("===============================================");
        
        //Wait 2.5 seconds
        try {
            Thread.sleep(2500);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        //Necessary variables
        int stackSize = 0;
        String playMadeS;
        char playMadeC;
        boolean isOneTurn = true;
        
        //For loop to run through deck
        for(int i = 0; i < cardsLeft*2; i++){
            onePlay = oneHand[i/2].getValue(); twoPlay = twoHand[(i-1)/2].getValue();
            stackSize++;
            if(isOneTurn){
                System.out.println("--> One plays a " + oneHand[i/2]);
                if(onePlay >= 11){
                    playMadeS = input.next();
                    playMadeC = playMadeS.charAt(0);
                    rewardWinner(playMadeC, stackSize);
                    stackSize = 0;
                }
            }
            if(!isOneTurn){
                System.out.println("--> Two plays a " + twoHand[(i-1)/2]);
                if(twoPlay >= 11){
                    playMadeS = input.next();
                    playMadeC = playMadeS.charAt(0);
                    rewardWinner(playMadeC, stackSize);
                    stackSize = 0;
                }
            }
            isOneTurn = !isOneTurn;
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("(these last " + stackSize + " cards go to nobody)");
    }
    
    public void rewardWinner(char playMadeC, int stackSize){
        System.out.println("===============================================");
        System.out.print("This stack had " + stackSize + " cards, and ");
        if(playMadeC == 'D' || playMadeC == 'd'){
            oneScore += stackSize;
            System.out.println(name1 + " won this stack!");
        }
        else if(playMadeC == 'L' || playMadeC == 'l'){
            twoScore += stackSize;
            System.out.println(name2 + " won this stack!");
        }
        System.out.println(name1 + " has " + oneScore + " points!");
        System.out.println(name2 + " has " + twoScore + " points!");
        System.out.println("===============================================");
    }
    
    public void printWinner(){
        System.out.println("\n");
        System.out.println("===============================================");
        System.out.println("=      All of the cards have been drawn!      =");
        System.out.println("===============================================");
        System.out.println("\n");
        System.out.print("\t");
        System.out.println(name1 + " has " + oneScore + " points!");
        System.out.print("\t");
        System.out.println(name2 + " has " + twoScore + " points!");
        if(oneScore > twoScore) System.out.println("\tTherefore " + name1 + " won The Game!");
        else if(oneScore < twoScore) System.out.println("\tTherefore " + name2 + " won The Game!");
        else System.out.println("\tTherefore it's a Tie!");
        System.out.println("\n");
        System.out.println("===============================================");
        System.out.println("=            Thank you for playing!           =");
        System.out.println("===============================================");
    }
}