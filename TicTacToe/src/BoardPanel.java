import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoardPanel extends JPanel implements MouseListener {
    private GameModel model;

    private Dimension boardSize;

    private BufferedImage currGameBoard;
    private ImageIcon currGameBoardImageIcon;
    private JLabel currGameBoardContainer;
    private BufferedImage currMarkerImg;
    private BufferedImage markerCrossImg;
    private BufferedImage markerCircleImg;

    public JTextArea gameLog;

    public BoardPanel(GameModel model) {
        this.model = model;

        this.boardSize = new Dimension(800, 600);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        try {
            this.markerCircleImg = ImageIO.read(new File("assets/marker_circle.png"));
            this.markerCrossImg = ImageIO.read(new File("assets/marker_cross.png"));

            if(this.model.activePlayer == MarkerType.CIRCLE) {
                this.currMarkerImg = this.markerCircleImg;
            }
            else {
                this.currMarkerImg = this.markerCrossImg;
            }
        } catch(IOException ioe) {}

        this.currGameBoard = new BufferedImage((int)this.boardSize.getWidth(),
                (int)this.boardSize.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.currGameBoardImageIcon = new ImageIcon();
        this.currGameBoardImageIcon.setImage(this.currGameBoard);

        this.currGameBoardContainer = new JLabel();
        this.currGameBoardContainer.setIcon(this.currGameBoardImageIcon);
        this.currGameBoardContainer.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.add(this.currGameBoardContainer);
        this.addMouseListener(this);

        repaint();
    }


    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int currX = e.getX();
        int currY = e.getY();

        if(model.handleTurn(currX, currY, boardSize)) {
            if (this.currMarkerImg == this.markerCrossImg) {
                this.currMarkerImg = this.markerCircleImg;
            } else {
                this.currMarkerImg = this.markerCrossImg;
            }
        }

        repaint();

        MarkerType winner = model.getWinner();

        gameLog.setText(model.getLog());

        if(winner != MarkerType.NONE) {
            JOptionPane.showMessageDialog(this, "We have a winner, and it is: " + winner.toString(),
                    "Winner, winner, chicken dinner!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(model.getNumTurns() == 9) {
            JOptionPane.showMessageDialog(this, "It is a tie!", "A tie!", JOptionPane.INFORMATION_MESSAGE);
        }

        JFrame frame = (JFrame)SwingUtilities.getRoot(this);
        for(Component c : frame.getComponents()) {
            c.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = this.currGameBoard.createGraphics();

        // Yay, I always forget the Graphics drawing api stuff...
        g2.setColor(Color.white);
        g2.fillRect(0, 0, (int)this.boardSize.getWidth(), (int)this.boardSize.getHeight());

        g2.setColor(Color.black);

        // Draw Vertical Lines
        g2.drawLine((int)this.boardSize.getWidth() / 3, 0,
                (int)this.boardSize.getWidth() / 3, (int)this.boardSize.getHeight());

        g2.drawLine((int)(2 * this.boardSize.getWidth() / 3), 0,
                (int)(2 * this.boardSize.getWidth() / 3), (int)this.boardSize.getHeight());

        // Draw the Horizontal Lines
        g2.drawLine(0, (int)this.boardSize.getHeight() / 3,
                (int)this.boardSize.getWidth(), (int)this.boardSize.getHeight() / 3);

        g2.drawLine(0, (int)(2 * this.boardSize.getHeight() / 3),
                (int)this.boardSize.getWidth(), (int)(2 * this.boardSize.getHeight() / 3));

        // draw the marker
        for(BoardLocation loc : this.model.markerLocations) {
            if(loc.markerType == MarkerType.CROSS) {
                g2.drawImage(this.markerCrossImg, loc.x, loc.y, null);
            }
            else {
                g2.drawImage(this.markerCircleImg, loc.x, loc.y, null);
            }

        }

        g2.drawImage(this.currGameBoard, 0, 0, null);

        this.currGameBoardImageIcon.setImage(this.currGameBoard);
        this.currGameBoardContainer.setIcon(this.currGameBoardImageIcon);
    }


}
