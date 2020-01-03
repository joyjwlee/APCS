import java.util.Random;
public class Deck {
    private int top;
    private int numCards;
    private Card[] cards;
    
    public Deck() {
        numCards = 52;
        cards = new Card[numCards];
        top = 0;
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 2; value <= 14; value++) {
                cards[top] = new Card(value, suits[suit]);
                top++;
            }
        }
        top = 0;
    }
    
    public void print() {
        for (int i = top; i < numCards; i++) {
           if (i % 10 == 0) System.out.println();
           System.out.print(cards[i] + "\t");
        }
    }
    
    public Card deal() {
        Card answer = cards[top];
        top++;
        return answer;
    }
    
    //Randomly shuffle array
    public void shuffle() {
        for(int i = 0; i < cards.length; i++){
            int randSwap = (int)(Math.random()*cards.length);
            Card temp = cards[randSwap];
            cards[randSwap] = cards[i];
            cards[i] = temp;
        }
    }
    
    public boolean hasCards() {
        return (top != numCards);
    }
    
    public int getSize() {
        return numCards;
    }
}