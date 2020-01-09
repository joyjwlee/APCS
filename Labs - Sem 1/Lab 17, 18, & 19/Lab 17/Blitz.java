import java.util.Scanner;
public class Blitz {
    private int oneScore;
    private int twoScore;
    private Card[] oneHand;
    private Card[] twoHand;
    private int cardsLeft;
    private int warPoints;

    //Additional necessary variables
    Scanner scan = new Scanner( System.in );
    private String pause;
    private int onePlay, twoPlay;

    public Blitz() {
        cardsLeft = 26;
        oneHand = new Card[cardsLeft];
        twoHand = new Card[cardsLeft];
        oneScore = 0;
        twoScore = 0;
        warPoints = 1;
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
        System.out.println();
        //Enter code to play the game with outputs as shown
        for(int i = 0; i < cardsLeft; i++){
            drawCard(i);
            if(onePlay != twoPlay){ //Not a tie
                if(onePlay > twoPlay){ //One wins
                    System.out.println("Player one wins!");
                    oneScore++;
                } else {
                    System.out.println("Player two wins!");
                    twoScore++;
                }
                System.out.println("Player one: " + oneScore + "\tPlayer two: " + twoScore);
                pause = scan.nextLine(); //pauses until a button is pressed; last line in loop
            } else { //Tie
                //Draw cards until no longer tie or no  more cards
                while( oneHand[i].getValue() == twoHand[i].getValue() && i <  cardsLeft){
                    i++;
                    drawCard(i);
                    warPoints++;
                }
                if(onePlay > twoPlay){ //One wins
                    System.out.println("Player one wins!");
                    oneScore += warPoints;
                } else {
                    System.out.println("Player two wins!");
                    twoScore += warPoints;
                }
                System.out.println("Player one: " + oneScore + "\tPlayer two: " + twoScore);
                pause = scan.nextLine(); //pauses until a button is pressed; last line in loop
                warPoints = 1;
            }
        }
        //Ouput who won overall game
        System.out.println();
        if(oneScore > twoScore) System.out.println("Player One Won The Game!");
        else if(oneScore < twoScore) System.out.println("Player Two Won The Game!");
        else System.out.println("It's a Tie!");
    }

    public void drawCard(int i){
        onePlay = oneHand[i].getValue(); twoPlay = twoHand[i].getValue();
        System.out.println("Player one plays a " + oneHand[i]);
        System.out.println("Player two plays a " + twoHand[i]);
    }
}