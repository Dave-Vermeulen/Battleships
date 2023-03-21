public class Game {
    private GameBoard board;
    private ArrayList<Ship> ships;

    public Game(int boardSize) {
        this.board = new GameBoard(boardSize);
        this.ships = new ArrayList<Ship>();
    }

    public void addShip(Ship ship) {
        this.ships.add(ship);
    }

    public boolean isGameOver() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public boolean takeTurn(String guess) {
        int row = guess.charAt(0) - 'A';
        int col = Integer.parseInt(guess.substring(1)) - 1;
        boolean hit = board.markGuess(row, col);
        if (hit) {
            for (Ship ship : ships) {
                if (ship.checkHit(row, col)) {
                    System.out.println("Hit on " + guess + "!");
                    if (ship.isSunk()) {
                        System.out.println("You sank the " + ship.getName() + "!");
                    }
                    return true;
                }
            }
        }
        System.out.println("Miss on " + guess + ".");
        return false;
    }
}

