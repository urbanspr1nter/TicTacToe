public class TicTacToe {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameFrame gameFrame = new GameFrame(model);
        gameFrame.setVisible(true);
    }
}
