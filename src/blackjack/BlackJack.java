package blackjack;

import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack!\n");
        gameLoop();
    }
    
    public static void gameLoop() {
        Scanner sc = new Scanner(System.in);
        Deck newDeck = new Deck();
        newDeck.shuffle();
        Player dealer = new Player();
        Player human = new Player();
        for (int i = 0; i < 2; i++) {
            human.addCardToHand(newDeck.drawCard());
            dealer.addCardToHand(newDeck.drawCard());
        }
        gameStatus(dealer, human);
        while (true) { 
            if (human.check21()) {
                break;
            }
            System.out.print("Stay or hit?: ");
            String input = sc.nextLine();
            System.out.println();
            if (input.equalsIgnoreCase("stay")) {
                break;
            } 
            else {
                human.addCardToHand(newDeck.drawCard());
                gameStatus(dealer, human);
                if (human.bust()) {
                    System.out.println("You busted by going over 21! You lost");
                    System.out.println("Dealer wins with " + dealer.getTotalPoints() + " points.");
                    System.exit(0);
                }
                else if (human.check21()) {
                    System.out.println("You hit 21!");
                    break;
                }
            }
        }
        while (dealer.getTotalPoints() < 17) {
            gameStatus(dealer, human);
            dealer.addCardToHand(newDeck.drawCard());
        }
        gameStatus(dealer, human);
        if (dealer.getTotalPoints() > 21) {
            System.out.println("Dealer busted!");
            System.out.println("You win with " + human.getTotalPoints() + " points.");
        }
        else if (dealer.getTotalPoints() > human.getTotalPoints()) {
            System.out.println("Dealer wins with " + dealer.getTotalPoints() + " points.");
        }
        else if (dealer.getTotalPoints() < human.getTotalPoints()) {
            System.out.println("You win with " + human.getTotalPoints() + " points.");
        }
        else if (dealer.getTotalPoints() == human.getTotalPoints()) {
            System.out.println("Tie game.");
        }
        
    }
    
    public static void gameStatus(Player dealer, Player human) {
        System.out.println("Dealer hand: " + dealer.handToString());
        System.out.println("Dealer points: " + dealer.getTotalPoints());
        System.out.println("Player hand: " + human.handToString());
        System.out.println("Player points: " + human.getTotalPoints());
        System.out.println();
    }
    
}
