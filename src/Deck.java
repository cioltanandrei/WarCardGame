import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<PlayingCard> deck;

    public void addCard(PlayingCard card) {
        deck.add(card);
    }

    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    public Deck() {
        deck = new ArrayList<PlayingCard>();
        for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
            for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
                PlayingCard card = new PlayingCard(rank, suit);
                addCard(card);
            }
        }
    }

    public Deck(ArrayList<PlayingCard> newDeck) {
        this.deck = newDeck;
    }

    public void emptyDeck() {
        deck = new ArrayList<PlayingCard>();
    }

    public int getSize() {
        return deck.size();
    }

    public PlayingCard drawCard() {
        PlayingCard card = deck.get(0);
        this.deck.remove(0);
        return card;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }

    public void sort() {
        for (int i = 0; i < deck.size(); i++) {
            for (int j = i + 1; j < deck.size(); j++) {
                if (deck.get(i).getSuit().compareTo(deck.get(j).getSuit()) > 0) {
                    Collections.swap(deck, i, j);
                } else if (deck.get(i).getSuit().compareTo(deck.get(j).getSuit()) == 0) {
                    if (deck.get(i).getRank().compareTo(deck.get(j).getRank()) > 0) {
                        Collections.swap(deck, i, j);
                    }
                }
            }
        }
    }
}
