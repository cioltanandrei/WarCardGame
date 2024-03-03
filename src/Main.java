public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");

        int maxNoOfMoves = 0;
        int minNoOfMoves = 999999;
        int meanValue = 0;
        for(int i = 0 ; i < 10; i++) {
            Game game = new Game();
            game.addPlayer(player1);
            game.addPlayer(player2);
            game.addPlayer(player3);
            game.addPlayer(player4);
            int noOfMoves = game.startGame(4);
            System.out.println("Total moves for game " + (i + 1) + ": " + noOfMoves);
            if(noOfMoves > maxNoOfMoves)
                maxNoOfMoves = noOfMoves;
            if(noOfMoves < minNoOfMoves)
                minNoOfMoves = noOfMoves;
            meanValue = meanValue + noOfMoves;
        }
        meanValue /= 10;
        System.out.println("Max number of moves is: " + maxNoOfMoves);
        System.out.println("Min number of moves is: " + minNoOfMoves);
        System.out.println("Mean value is: " + meanValue);
    }
}
