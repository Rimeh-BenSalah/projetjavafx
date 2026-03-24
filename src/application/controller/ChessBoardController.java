package application.controller;

import application.model.*;
import application.util.SoundManager;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class ChessBoardController {

    @FXML private GridPane boardGrid;
    @FXML private MenuItem savePgnButton, loadPgnButton, soundToggleButton;

    private Board board;
    private SoundManager soundManager = new SoundManager();

    private StackPane selectedCell = null;
    private int selectedX = -1, selectedY = -1;

    @FXML
    public void initialize() {
        board = new Board(); // initialise les pièces
        drawBoard();
    }

    private void drawBoard() {
        boardGrid.getChildren().clear();
        Piece[][] pieces = board.getBoard();

        for (int row=0; row<8; row++) {
            for (int col=0; col<8; col++) {
                StackPane cell = new StackPane();
                Rectangle rect = new Rectangle(60,60);
                rect.setFill((row+col)%2==0 ? Color.BEIGE : Color.BROWN);
                cell.getChildren().add(rect);

                if (pieces[row][col] != null) {
                    Text text = new Text(getSymbol(pieces[row][col]));
                    text.setStyle("-fx-font-size:30px;");
                    cell.getChildren().add(text);
                }

                final int x=row, y=col;
                cell.setOnMouseClicked(e -> handleClick(x,y));
                boardGrid.add(cell, col, row);
            }
        }
    }

    private void handleClick(int x, int y) {
        Piece[][] pieces = board.getBoard();

        if (selectedCell == null) {
            if (pieces[x][y] != null) {
                selectedCell = (StackPane) boardGrid.getChildren().get(x*8+y);
                selectedX = x;
                selectedY = y;
            }
        } else {
            if (pieces[selectedX][selectedY].isValidMove(selectedX, selectedY, x, y, pieces)) {
                board.movePiece(selectedX, selectedY, x, y);
                soundManager.playMove();
            }
            selectedCell = null;
            selectedX = -1;
            selectedY = -1;
            drawBoard();
        }
    }

    private String getSymbol(Piece piece) {
        if(piece instanceof Pawn) return piece.isWhite() ? "\u2659" : "\u265F";
        if(piece instanceof Rook) return piece.isWhite() ? "\u2656" : "\u265C";
        if(piece instanceof Knight) return piece.isWhite() ? "\u2658" : "\u265E";
        if(piece instanceof Bishop) return piece.isWhite() ? "\u2657" : "\u265D";
        if(piece instanceof Queen) return piece.isWhite() ? "\u2655" : "\u265B";
        if(piece instanceof King) return piece.isWhite() ? "\u2654" : "\u265A";
        return "";
    }

    @FXML public void savePGN() { System.out.println("Sauvegarde PGN"); }
    @FXML public void loadPGN() { System.out.println("Chargement PGN"); }
    @FXML public void toggleSound() { soundManager.toggle(); }
}