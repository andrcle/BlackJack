package blackjack;

import java.util.*;

public class Player {
    
    private Hand hand;
    private final static int LIMIT = 21;
    
    public Player() {
        hand = new Hand();
    }
    
    public void addCardToHand(Card c) {
        hand.addCard(c);
    }
        
    public boolean bust() {
        return hand.getPoints() > LIMIT;
    }
    
    public int getTotalPoints() {
        return hand.getPoints();
    }
    
    public boolean check21() {
        return getTotalPoints() == 21;
    }
    
    public String handToString() {
        return hand.toString();
    }
}
