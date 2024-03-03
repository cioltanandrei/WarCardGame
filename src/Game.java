import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private int numberOfMoves;
    private boolean gameEnded;

    public Game() {
        players = new ArrayList<Player>();
        deck = new Deck();
        numberOfMoves = 0;
        gameEnded = false;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void playRound() {
        ArrayList<PlayingCard> discardedCards = new ArrayList<PlayingCard>();
        int noOfPlayersWithMaxCard = 0;
        PlayingCard maxCard = null;
        int indexOfRoundWinner = 0;
        int counter = 0;

        //System.out.println("Cards this round: ");
        for (Player player : players) {
            if (player.getDeckSize() > 0) {
                player.drawCard();
                numberOfMoves++;
            }
            discardedCards.add(player.getCurrentCard());
            if (maxCard == null) {
                maxCard = player.getCurrentCard();
                noOfPlayersWithMaxCard = 1;
                indexOfRoundWinner = counter;
            } else {
                if (player.getCurrentCard().compareRank(maxCard) > 0) {
                    maxCard = player.getCurrentCard();
                    noOfPlayersWithMaxCard = 1;
                    indexOfRoundWinner = counter;
                } else {
                    if (player.getCurrentCard().compareRank(maxCard) == 0) {
                        noOfPlayersWithMaxCard++;
                    }
                }
            }
            counter++;
        }
        if (noOfPlayersWithMaxCard == 1) {
            counter = 0;
            for (Player player : players) {
                if (counter == indexOfRoundWinner) {
                    player.addCards(discardedCards);
                }
                counter++;
            }
        } else {
            while (noOfPlayersWithMaxCard > 1 && !gameEnded) {
                counter = 0;
                noOfPlayersWithMaxCard = 0;
                maxCard = null;
                for (Player player : players) {
                    if (player.getDeckSize() != 0) {
                        player.drawCard();
                        numberOfMoves++;
                        discardedCards.add(player.getCurrentCard());
                        if (player.getDeckSize() != 0) {
                            player.drawCard();
                            numberOfMoves++;
                            discardedCards.add(player.getCurrentCard());
                            if (maxCard == null) {
                                maxCard = player.getCurrentCard();
                                noOfPlayersWithMaxCard = 1;
                                indexOfRoundWinner = counter;
                            } else {
                                if (player.getCurrentCard().compareRank(maxCard) > 0) {
                                    maxCard = player.getCurrentCard();
                                    noOfPlayersWithMaxCard = 1;
                                    indexOfRoundWinner = counter;
                                } else {
                                    if (player.getCurrentCard().compareRank(maxCard) == 0) {
                                        noOfPlayersWithMaxCard++;
                                    }
                                }
                            }
                        }
                    }
                    counter++;
                }
            }
            //System.out.println("Index of round winner is  " + indexOfRoundWinner);
            counter = 0;
            for (Player player : players) {
                if (counter == indexOfRoundWinner) {
                    player.addCards(discardedCards);
                }
                counter++;
            }
        }
        for (Player player : players) {
            if (player.getDeckSize() == 0)
                gameEnded = true;
        }
        /*
        for (PlayingCard card : discardedCards) {
            System.out.print(card.getRank() + " ");
        }
        System.out.println();
        for (Player player : players) {
            System.out.println(player.deck.toString());
        }*/
    }

    public int startGame(int numberOfPlayers) {
        if(numberOfPlayers < 2 || numberOfPlayers > 4) {
            System.out.println("Invalid number of players");
        }
        else {
            deck.sort();
            deck.shuffle();
            for(Player player : players) {
                //System.out.println("Player: ");
                for (int i = 0; i < 52 / numberOfPlayers; i++) {
                    player.addCard(this.deck.drawCard());
                }
            }
            while (!gameEnded) {
                playRound();
            }
        }
        return numberOfMoves;
    }
}
