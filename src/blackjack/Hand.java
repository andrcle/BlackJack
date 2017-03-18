package blackjack;

import java.util.*;

public class Hand {
    
    private List<Card> hand;
    private int points = 0;
    
    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    public void addCard(Card c) {
        hand.add(c);
        points += rankToPoints(c.getRank());
    }
    
    public String toString() {
        String cards = "";
        for (int i = 0; i < hand.size(); i ++) {
            cards += hand.get(i).toString() + " ";
        }
        return cards;
    }
    
    public int getPoints() {
        return points;
    }
    
    private int rankToPoints(Rank rank) {
        switch (rank) {
            case TWO: 
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case ACE:
                return (points + 11 <= 21) ? 11 : 1;
            default:
                return 10;
        }
    }
   
}
