//Lee
//Lab 10 - APCS Land
//Make a game where players traverse through APCS Land
//Extensions: input name and winning point

import java.util.*;

public class Lab10_APCSLand {
    String player1 = "", player2 = "";
    int player1Pos = 0, player2Pos = 0, endPoint;

    public static void main (String[] args) {
        Lab10_APCSLand obj = new Lab10_APCSLand();
        obj.mainDriver();
    } // ends method main

    public void mainDriver() {
        Scanner input = new Scanner( System.in );
        System.out.println( "\n=================================================================");
        System.out.println("For odd rounds, only Player A moves; for even rounds, only Player B moves");
        System.out.println("Player A does not move for even rounds; Player B does not move for odd rounds\n");
        System.out.print( "Input endpoint for number of points: ");
        endPoint = input.nextInt();
        System.out.print( "Input Player 1's name: ");
        player1 = input.next();
        System.out.print( "Input Player 2's name: ");
        player2 = input.next();
        playGame();        
    }

    public void playGame() {
        int round = 1;
        System.out.println("\t|\tPlayer One: " + player1 + "\t|\tPlayer Two: " + player2);
        System.out.println("Round\t|\tStart\tRoll\tFinish\t|\tStart\tRoll\tFinish");
        boolean isOver = false, playerATurn = true;
        int positionA = 0, positionB = 0, initialA = 0, initialB = 0;
        while(!isOver) {
            int rollA = rollDice();
            int rollB = rollDice();
            int actualA = 0, actualB = 0;

            if(playerATurn){
                if (rollA == 2 || rollA == 12) actualA = 0;
                else if (rollA == 7) actualA = -7;
                else actualA = rollA;
                positionA += actualA;
                if (positionA < 0) positionA = 0;

                if (positionA == positionB) positionB = 0;
                playerATurn = false;
                System.out.println(round + "\t|\t" + initialA + "\t" + rollA + "\t" + positionA + "\t|\t" + initialB + "\tx\t" + positionB);
            } else{
                if (rollB == 2 || rollB == 12) actualB = 0;
                else if (rollB == 7) actualB = -7;
                else actualB = rollB;
                positionB += actualB;
                if (positionB < 0) positionB = 0;

                if (positionB == positionA) positionA = 0;
                playerATurn = true;
                System.out.println(round + "\t|\t" + initialA + "\tx\t" + positionA + "\t|\t" + initialB + "\t" + rollB + "\t" + positionB);
            }

            if (positionA >= endPoint || positionB >= endPoint) isOver = true;
            round++;
            initialA = positionA;
            initialB = positionB;
        }
        round--;
        System.out.println("");
        if(positionA > positionB) System.out.println(player1 + " won the game on round " + round);
        else System.out.println(player2 + " won the game on round " + round);
    }

    public int rollDice() {
        int firstDice = (int)(Math.random()*6) + 1;
        int secondDice = (int)(Math.random()*6) + 1;
        return firstDice + secondDice;
    }
}