import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {
    public MarkerType[][] board;
    public MarkerType activePlayer;
    public List<BoardLocation> markerLocations;
    public StringBuilder log;

    private int numTurns;

    public GameModel() {
        this.board = new MarkerType[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.board[i][j] = MarkerType.NONE;
            }
        }

        this.activePlayer = getInitialTurn();
        this.markerLocations = new ArrayList<BoardLocation>();
        this.numTurns = 0;
        this.log = new StringBuilder();
    }

    private MarkerType getInitialTurn() {
        Random rand = new Random();
        int markerChosen = rand.nextInt(2);
        if(markerChosen == 0) {
            this.activePlayer = MarkerType.CIRCLE;
        }
        else {
            this.activePlayer = MarkerType.CROSS;
        }

        return this.activePlayer;
    }

    public int getNumTurns() {
        return this.numTurns;
    }


    public MarkerType getWinner() {
        MarkerType winner = MarkerType.NONE;
        if(this.board[0][0] == this.board[0][1] && this.board[0][1] == this.board[0][2]) {
            winner = this.board[0][0];
        }
        else if(this.board[1][0] == this.board[1][1] && this.board[1][1] == this.board[1][2]) {
            winner = this.board[1][0];
        }
        else if(this.board[2][0] == this.board[2][1] && this.board[2][1] == this.board[2][2]) {
            winner = this.board[2][0];
        }
        else if(this.board[0][0] == this.board[1][0] && this.board[1][0] == this.board[2][0]) {
            winner = this.board[0][0];
        }
        else if(this.board[0][1] == this.board[1][1] && this.board[1][1] == this.board[2][1]) {
            winner = this.board[0][1];
        }
        else if(this.board[0][2] == this.board[1][2] && this.board[1][2] == this.board[2][2]) {
            winner = this.board[0][2];
        }
        else if(this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) {
            winner = this.board[0][0];
        }
        else if(this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0]) {
            winner = this.board[0][2];
        }
        else {
            winner = MarkerType.NONE;
        }

        if(winner != MarkerType.NONE) {
            log.append(winner.toString() + " is the winner!\n");
        }

        return winner;
    }

    public boolean handleTurn(int currX, int currY, Dimension boardSize) {

        BoardLocation loc = new BoardLocation(currX, currY, boardSize);

        if(this.numTurns < 9 &&
                this.board[loc.row][loc.col] == MarkerType.NONE &&
                getWinner() == MarkerType.NONE) {

            if(this.activePlayer == MarkerType.CROSS) {
                loc.markerType = MarkerType.CROSS;
            }
            else {
                loc.markerType = MarkerType.CIRCLE;
            }

            this.markerLocations.add(loc);

            this.board[loc.row][loc.col] = this.activePlayer;
            this.numTurns++;

            log.append(this.activePlayer.toString() + " placed their mark on " +
                    loc.row + ", " + loc.col + "\n");

            switchActivePlayers();

            return true;
        }
        else {
            if(this.numTurns == 9) {
                log.append("It is a tie!\n");
            }
            else {
                log.append("Location occupied!\n");
            }

            return false;
        }
    }

    public String getLog() {
        return this.log.toString();
    }

    public void switchActivePlayers() {
        if(this.activePlayer == MarkerType.CROSS) {
            this.activePlayer = MarkerType.CIRCLE;
        }
        else {
            this.activePlayer = MarkerType.CROSS;
        }
    }


    public void debugPrintBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print("[ " + this.board[i][j] + " ] ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
