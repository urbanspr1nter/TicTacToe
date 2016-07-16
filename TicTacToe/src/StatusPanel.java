import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusPanel extends JPanel implements ActionListener {
    private GameModel model;
    private JPanel labelPanel;
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JButton newGameButton;
    private JLabel statusLabel;

    public StatusPanel(GameModel model) {
        super();

        this.model = model;

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200, 700));
        this.setBackground(Color.LIGHT_GRAY);

        this.labelPanel = new JPanel();

        this.titleLabel = new JLabel();
        this.titleLabel.setText("<html><h1><center>&emsp;TicTacToe</center></h1></html>");
        this.titleLabel.setBackground(Color.LIGHT_GRAY);
        this.titleLabel.setForeground(Color.DARK_GRAY);

        this.authorLabel = new JLabel();
        this.authorLabel.setText("<html><center><br/>Roger Ngo<br/><br/>http://rogerngo.com<br/><br/>July 2016</center></html>");
        this.authorLabel.setBackground(Color.LIGHT_GRAY);
        this.authorLabel.setForeground(Color.DARK_GRAY);

        this.statusLabel = new JLabel();

        this.labelPanel.setPreferredSize(new Dimension(200, 500));
        this.labelPanel.add(this.titleLabel);
        this.labelPanel.add(this.statusLabel);
        this.labelPanel.add(this.authorLabel);
        this.labelPanel.setBackground(Color.LIGHT_GRAY);

        this.newGameButton = new JButton();
        this.newGameButton.setText("NEW GAME");
        this.newGameButton.addActionListener(this);

        this.add(this.labelPanel, BorderLayout.NORTH);
        this.add(this.newGameButton, BorderLayout.SOUTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setStatus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame)SwingUtilities.getRoot(this);
        frame.setVisible(false);

        GameModel model = new GameModel();
        GameFrame newFrame = new GameFrame(model);
        newFrame.setVisible(true);

        frame.dispose();
    }

    public void setStatus() {
        this.statusLabel.setText("<html><h2>" + model.activePlayer.toString() + "'s TURN</h2></html>");

    }
}
