public class PlayingCard {
    private Rank rank;
    private Suit suit;

    public PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(12), QUEEN(13), KING(14), ACE(15);

        private final int number;

        public int getNumber() {
            return number;
        }

        Rank(int number) {
            this.number = number;
        }
    }

    public enum Suit {
        DIAMONDS(1), SPADES(2), HEARTS(3), CLUBS(4);

        private final int number;

        public int getNumber() {
            return number;
        }

        Suit(int number) {
            this.number = number;
        }
    }

    public int compareRank(PlayingCard card) {
        if(this.rank.getNumber() > card.rank.getNumber())
            return 1;
        else {
            if(this.rank.getNumber() < card.rank.getNumber()) {
                return -1;
            }
            return  0;
        }
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
