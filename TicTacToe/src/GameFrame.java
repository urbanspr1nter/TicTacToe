import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
    private GameModel model;

    public GameFrame(GameModel model) {
        super();

        this.model = model;

        Dimension gameSize = new Dimension(1024, 768);
        this.setMinimumSize(gameSize);
        this.setMaximumSize(gameSize);
        this.setTitle("TicTacToe");
        this.setSize(gameSize);
        this.setPreferredSize(gameSize);
        this.setLayout(new BorderLayout());

        // Close window action will exit the application
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        BoardPanel bPanel = new BoardPanel(this.model);
        StatusPanel sPanel = new StatusPanel(this.model);

        JTextArea gameLog = new JTextArea();
        gameLog.setLineWrap(true);
        gameLog.setEditable(false);
        gameLog.setAutoscrolls(true);
        gameLog.setRows(7);
        gameLog.append("Starting the game...\n");
        gameLog.setCaretPosition(gameLog.getDocument().getLength());

        bPanel.gameLog = gameLog;

        JScrollPane scrollPane = new JScrollPane(gameLog);
        scrollPane.setAutoscrolls(true);

        this.add(bPanel, BorderLayout.WEST, 0);
        this.add(sPanel, BorderLayout.EAST, 1);
        this.add(scrollPane, BorderLayout.SOUTH, 2);

        this.pack();
    }



}
