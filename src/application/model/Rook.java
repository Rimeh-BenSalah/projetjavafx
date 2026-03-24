package application.model;

public class Rook extends Piece {
    public Rook(boolean white) { super(white); }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        // Déplacement horizontal ou vertical
        return startX == endX || startY == endY;
    }
}