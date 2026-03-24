package application.model;

public class Queen extends Piece {
    public Queen(boolean white) { super(white); }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        // Ligne droite ou diagonale
        return startX == endX || startY == endY || Math.abs(endX - startX) == Math.abs(endY - startY);
    }
}