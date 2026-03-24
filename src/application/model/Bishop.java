package application.model;

public class Bishop extends Piece {
    public Bishop(boolean white) { super(white); }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        return Math.abs(endX - startX) == Math.abs(endY - startY);
    }
}