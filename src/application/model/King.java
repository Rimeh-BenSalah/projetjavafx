package application.model;

public class King extends Piece {
    public King(boolean white) { super(white); }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);
        return dx <= 1 && dy <= 1;
    }
}