import java.util.ArrayList;

public class Player {
    private final String name;
    public Deck deck;
    private PlayingCard currentCard;

    @Override
    public String toString() {
        return "Player{" +
                "deck=" + deck +
                '}';
    }

    public Player(String name) {
        this.name = name;
        deck = new Deck();
        deck.emptyDeck();
        currentCard = null;
    }

    public boolean drawCard() {
        if(this.deck.getSize() > 0) {
            this.currentCard = this.deck.drawCard();
            return true;
        }
        return false;
    }

    public PlayingCard getCurrentCard() {
        return currentCard;
    }

    public void addCards(ArrayList<PlayingCard> cards) {
        for(PlayingCard card : cards) {
            deck.addCard(card);
        }
    }

    public void addCard(PlayingCard card) {
        deck.addCard(card);
    }

    public int getDeckSize() {
        return deck.getSize();
    }
}
