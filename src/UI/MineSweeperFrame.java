package UI;

import Board.BoardPanel;
import Board.BoardPanelFactory;
import Board.IBoardPanel;
import javax.swing.*;
import java.awt.*;

public class MineSweeperFrame extends JFrame {

    private static final MineSweeperFrame MINE_SWEEPER_FRAME = new MineSweeperFrame();

    int boardWidth = 1280;
    int boardHeight = 720;
    private final TextPanel textPanel;
    private final SettingsPanel settingsPanel;
    private final IBoardPanel IBoardPanel;
    private JPanel currentPanel;

    // Private constructor to prevent instantiation
    private MineSweeperFrame() {
        this.IBoardPanel = new BoardPanelFactory(this);
        // Sets size to declare the dimension of the frame, in order to call setLocationRelativeTo() method later
        setSize(boardWidth, boardHeight);
        // Centers a frame relative a component, in this case, it is centered on the screen
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // BorderLayout lets the frame places up to five areas: top, bot, left, right, cent
        setLayout(new BorderLayout());

        // Initialize the textPanel
        textPanel = new TextPanel();
        add(textPanel, BorderLayout.NORTH);


        // Initialize the settingsMenu
        SettingsMenu settingsMenu = new SettingsMenu(this);
        setJMenuBar(settingsMenu);

        settingsPanel = new SettingsPanel(this);

        // Initialize the boardPanel
        setBoardPanel(1);
        setTitle("MineSweeper");
        pack();
    }

    // Public method to provide access to the singleton instance
    public static MineSweeperFrame getInstance() {
        return MINE_SWEEPER_FRAME;
    }

    public void play() {
        setVisible(true);
    }

    public void showSettingsPanel() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        setBoardPanel(settingsPanel);
        add(this.currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void setBoardPanel(int level) {
        BoardPanel board = null;
        board = IBoardPanel.createBoardPanel(level);
        if (currentPanel != null) {
            remove(currentPanel);
        }
        setBoardPanel(board);
        add(this.currentPanel, BorderLayout.CENTER);
        pack();
        revalidate();
        repaint();
    }


    public void setTextPanel(String text) {
        this.textPanel.setTextLabel(text);
    }

    public void setBoardPanel(JPanel boardPanel) {
        this.currentPanel = boardPanel;
    }
}

