package blackjack;

import java.util.*;

public class Deck {
    
    private List<Card> deck = new ArrayList<Card>();
    
    public Deck() {
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public Card drawCard() {
        Card c = deck.get(0);
        deck.remove(0);
        return c;
    }
}
