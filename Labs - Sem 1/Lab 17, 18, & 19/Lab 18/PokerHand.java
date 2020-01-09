import java.util.Scanner;
import java.util.Arrays;
public class PokerHand {
    private Card[] hand;
    private int cardsLeft;

    public PokerHand() {
        cardsLeft = 5;
        hand = new Card[cardsLeft];
        fillHands();
    }

    private void fillHands() {
        Deck deck = new Deck();
        deck.shuffle();
        for(int i = 0; i < cardsLeft; i++){
            hand[i] = deck.deal();
        }
    }

    public void evaluateHand() {
        //Arrays.sort(hand);
        //Make own sort function (bubble sort for ease of implementation):
        sortArray();
        
        System.out.print("\n=================\n");
        System.out.print("Hand Evaluation:");
        System.out.println("\n=================\n");
        
        //OP deck, for testing purposes
        /*
        Card first = new Card(10, "Spades");
        Card second = new Card(11, "Spades");
        Card third = new Card(12, "Spades");
        Card fourth = new Card(13, "Spades");
        Card fifth = new Card(14, "Spades");
        hand[0] = first;
        hand[1] = second;
        hand[2] = third;
        hand[3] = fourth;
        hand[4] = fifth;
        */
       
        printHand();
        
        System.out.print("\nEvaluation: ");
        if( isFlush() && isStraight() ) System.out.println("Straight Flush!");
        else if( isFourOfAKind() ) System.out.println("Four of a Kind!");
        else if( isFullHouse() ) System.out.println("Full House!");
        else if( isFlush() ) System.out.println("Flush!");
        else if( isStraight() ) System.out.println("Straight!");
        else if( isThreeOfAKind() ) System.out.println("Three of a Kind!");
        else if( isTwoPair() ) System.out.println("Two Pair!");
        else if( isOnePair() ) System.out.println("One Pair!");
        else System.out.println("High Card!");
    }
    
    //Bubble sort to sort hand array
    public void sortArray(){
        int n = hand.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if ( hand[j].getValue() > hand[j+1].getValue() ){
                    Card temp = hand[j];
                    hand[j] = hand[j+1];
                    hand[j+1] = temp;
                }
            }
        }
    }

    public void printHand(){
        System.out.println("\nPlayer's Hand: ");
        for(int i = 0; i < cardsLeft; i++){
            System.out.println(hand[i]);
        }
    }

    //Returns if it's four of a kind or not
    public boolean isFourOfAKind() {
        boolean left, right;
        left = hand[0].getValue() == hand[1].getValue() && hand[1].getValue() == hand[2].getValue() && hand[2].getValue() == hand[3].getValue();
        right = hand[1].getValue() == hand[2].getValue() && hand[2].getValue() == hand[3].getValue() && hand[3].getValue() == hand[4].getValue() ;
        return left || right;
    }

    //Returns if it's a full house or not
    public boolean isFullHouse(){
        int firstVal = hand[0].getValue();
        int firstValues = 1;
        int secondVal = hand[cardsLeft - 1].getValue();
        int secondValues = 1;
        for(int i = 1; i < cardsLeft - 1; i++){
            if (hand[i].getValue() == firstVal)
                firstValues++;
            if (hand[i].getValue() == secondVal)
                secondValues++;
        }
        if ( (firstValues == 3 && secondValues == 2) || (firstValues == 2 && secondValues == 3) )
            return true;
        return false;
    }
    
    //Returns if it's flush or not
    public boolean isFlush(){
        String suit = hand[0].getSuit();
        for (int i = 1; i < cardsLeft; i++) {
            if (suit != hand[i].getSuit()) return false;
        }
        return true;
    }

    //Returns if it's straight or not
    public boolean isStraight(){
        for(int i = 0; i < cardsLeft - 1; i++){
            if (hand[i].getValue()+1 != hand[i+1].getValue()) return false;
        }
        return true;
    }

    //Returns if it's three of a kind or not
    public boolean isThreeOfAKind(){
        int counter = 0;
        for(int i = 0; i < cardsLeft; i++){
            for(int j = i+1; j < cardsLeft; j++){
                if(hand[i].getValue() == hand[j].getValue()){
                    counter++;
                }
                if(j == cardsLeft-1 && counter!= 2){
                    counter = 0;
                }
                else if(j== cardsLeft-1 && counter >= 2){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Returns if it's two pairs or not
    public boolean isTwoPair(){
        boolean left, mid, right;
        left = hand[0].getValue() == hand[1].getValue() && hand[2].getValue() == hand[3].getValue();
        mid = hand[0].getValue() == hand[1].getValue() && hand[3].getValue() == hand[4].getValue();
        right = hand[1].getValue() == hand[2].getValue() && hand[3].getValue() == hand[4].getValue();
        return left || mid || right;
    }
    
    //Returns if it's one pair or not
    public boolean isOnePair(){
        for(int i = 0; i < cardsLeft-1; i++){
            if(hand[i].getValue() == hand[i+1].getValue()) return true;
        }
        return false;
    }
}